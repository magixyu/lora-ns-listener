package lorapp.nslistener.nsconnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lorapp.nslistener.nsmsgs.ResponseMSG;
import lorapp.nslistener.nsmsgs.factory.ResponseBodyFactory;

@Component
public class NSClientHandler extends ChannelInboundHandlerAdapter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NSClientHandler.class);
	
	@Autowired
	ResponseBodyFactory factory;

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.fireChannelActive();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];

		buf.readBytes(req);
		String message = new String(req, "UTF-8");
		LOGGER.info("Netty-Client:Receive Message," + message);
		String[] res = message.split("\n", 3);
		
		for (ResponseMSG rMSG : ResponseMSG.values()){
			if (message.contains(rMSG.getMSG())) {
				if (factory.getHandler(rMSG.getMSG()) == null) {
					LOGGER.error("No Handler defined for "  + rMSG.getMSG());
				} else {
					factory.getHandler(rMSG.getMSG()).handleMessage(res[2]);
				}
				break;
			}
		}
		
		buf.release();		
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		LOGGER.info("InboundHandler.channelReadComplete");
		ctx.flush();
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		LOGGER.error("InboundHandler.exception" + cause.getMessage());
		cause.printStackTrace();
		ctx.close();
	}
}