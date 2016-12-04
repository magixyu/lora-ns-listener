package lorapp.nslistener.nsmsgs.factory.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lorapp.nslistener.nsmsgs.ResponseMSG;
import lorapp.nslistener.nsmsgs.body.uplink.JoinAccept;
import lorapp.nslistener.nsmsgs.factory.ResponseBodyFactory;
import lorapp.nslistener.services.JacksonService;

@Component(value="JoinAcceptMessageHandler")
public class JoinAcceptMessageHandler implements IMessageHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(JoinAcceptMessageHandler.class);

	@Autowired(required = true)
	JacksonService jacksonService;
	
	public JoinAcceptMessageHandler(@Autowired ResponseBodyFactory factory){
		LOGGER.info("Register JoinAccept handler");
		factory.register(ResponseMSG.JOIN.getMSG(), this);
	}
	
	@Override
	public void handleMessage(String message) {
		jacksonService.toObject(message, JoinAccept.class);
	}

}
