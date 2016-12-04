package lorapp.nslistener.nsmsgs.factory.handlers;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import lorapp.nslistener.db.entity.UploadMessage;
import lorapp.nslistener.db.repo.UploadMessageRepo;
import lorapp.nslistener.nsmsgs.ResponseMSG;
import lorapp.nslistener.nsmsgs.body.uplink.Upload;
import lorapp.nslistener.nsmsgs.factory.ResponseBodyFactory;
import lorapp.nslistener.services.JacksonService;

@Component
public class UploadMessgeHandler implements IMessageHandler{

	@Autowired
	JacksonService jacksonService;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	UploadMessageRepo umRepo;
	
	@Value("${lora.rabbitmq.exchange}")
	private String exchange;
	
	public UploadMessgeHandler(@Autowired ResponseBodyFactory factory) {
		factory.register(ResponseMSG.UPLOAD.getMSG(), this);
	}

	@Override
	public void handleMessage(String message) {
		Upload um = jacksonService.toObject(message, Upload.class);
		UploadMessage upMsg = new UploadMessage(um.getAppEUI(), um.getDevEUI(), um.getPayload());
		umRepo.save(upMsg);
		try {
			rabbitTemplate.convertAndSend(exchange, um.getAppEUI()+"." + um.getDevEUI(), jacksonService.toJsonString(upMsg));
		} catch (AmqpException | JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
