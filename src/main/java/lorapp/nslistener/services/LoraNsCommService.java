package lorapp.nslistener.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import lorapp.nslistener.nsconnection.TCPConnection;

@Service
public class LoraNsCommService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoraNsCommService.class);
	
	@Autowired
	TCPConnection conn;
	
	private Channel ch;
	public void startClient(String ipAddr, int port, String transtype) throws InterruptedException {
		LOGGER.info("TCP Connection Start....");
		ch = conn.getConnection(ipAddr, port);
	}
	
	public void sendData(String msg) throws InterruptedException{
		LOGGER.info("Command send to NS: " + msg);
		byte[] req = msg.getBytes();
		ByteBuf clientMessage = Unpooled.buffer(req.length);
		clientMessage.writeBytes(req);
		ch.writeAndFlush(clientMessage).sync();
	}
	
	public void hearbeat() {
		LOGGER.info("Hearbeat sent");
		if(ch.isWritable()) {
			try {
				sendData("\n");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

}
