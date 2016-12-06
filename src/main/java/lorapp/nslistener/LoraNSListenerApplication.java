package lorapp.nslistener;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.fasterxml.jackson.core.JsonProcessingException;

import lorapp.db.entity.AppEUI;
import lorapp.db.repo.AppEUIRepo;
import lorapp.nslistener.nsmsgs.Message;
import lorapp.nslistener.nsmsgs.body.downlink.Join;
import lorapp.nslistener.nsmsgs.util.Authentication;
import lorapp.nslistener.services.JacksonService;
import lorapp.nslistener.services.LoraNsCommService;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories(basePackages="lorapp.db.repo")
@EntityScan(basePackages="lorapp.db.entity")

public class LoraNSListenerApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoraNSListenerApplication.class);

	@Autowired
	private LoraNsCommService loraNSClient;

	@Autowired
	private AppEUIRepo repo;

	@Autowired
	private JacksonService cmdToStr;

	@Value("${lora.csif-ip}")
	private String ipAddr;
	@Value("${lora.csif-port}")
	private int port;
	@Value("${lora.csif-transtype}")
	private String transtype;

	public static void main(final String... args) {
		new SpringApplicationBuilder(LoraNSListenerApplication.class).web(false).run(args);
		LOGGER.info("LoraNSListenerStarted");
	}

	@PostConstruct
	public void connectToNS() throws InterruptedException {
		LOGGER.info("Start TCP Client on host=" + ipAddr + "\nport=" + port);
		loraNSClient.startClient(ipAddr, port, transtype);

		for (AppEUI app : repo.findAll()) {
			String jsonStr;
			try {
				jsonStr = cmdToStr.toJsonString(new Join(app.getAppEUI(), 2, Authentication.generateNonce(),
						Authentication.generateChallenge()));
				String cmdStr = new Message(jsonStr).toString();
				loraNSClient.sendData(cmdStr);
			} catch (JsonProcessingException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Scheduled(fixedRate = 1000 * 60 * 10, initialDelay = 1000 * 6)
	public void nskeepAlive() {
		loraNSClient.hearbeat();
	}
}
