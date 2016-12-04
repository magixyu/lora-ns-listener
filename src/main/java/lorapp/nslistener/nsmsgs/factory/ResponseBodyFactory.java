package lorapp.nslistener.nsmsgs.factory;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lorapp.nslistener.nsconnection.NSClientHandler;
import lorapp.nslistener.nsmsgs.factory.handlers.IMessageHandler;

@Component
public class ResponseBodyFactory {

	private HashMap<String, IMessageHandler> handlers;
	private static final Logger LOGGER = LoggerFactory.getLogger(NSClientHandler.class);

	public ResponseBodyFactory() {
		handlers = new HashMap<String, IMessageHandler>();
	}
	public void register(String command, IMessageHandler resHandler) {
		if(handlers.containsKey(command)){
			LOGGER.warn("Duplicated Handler found");
		} else {
			handlers.put(command, resHandler);
		}
	}
	
	public IMessageHandler getHandler(String command) {
		return handlers.get(command);
	}
}
