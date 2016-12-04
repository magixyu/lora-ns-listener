package lorapp.nslistener.nsmsgs.factory.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lorapp.nslistener.nsmsgs.ResponseMSG;
import lorapp.nslistener.nsmsgs.body.uplink.JoinAccept;
import lorapp.nslistener.nsmsgs.factory.ResponseBodyFactory;
import lorapp.nslistener.services.JacksonService;

@Component
public class JoinAcceptMessageHandler implements IMessageHandler {

	@Autowired
	JacksonService jacksonService;
	
	public JoinAcceptMessageHandler(@Autowired ResponseBodyFactory factory){
		factory.register(ResponseMSG.JOIN.getMSG(), this);
	}
	
	@Override
	public void handleMessage(String message) {
		jacksonService.toObject(message, JoinAccept.class);
	}

}
