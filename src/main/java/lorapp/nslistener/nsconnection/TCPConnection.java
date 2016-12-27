package lorapp.nslistener.nsconnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

@Component
public class TCPConnection {
		
	@Autowired
	NSClientHandler nsClientHandler;

	public Channel getConnection(String host, int port) throws InterruptedException {
		EventLoopGroup group = new NioEventLoopGroup();
		Bootstrap bootstrap = new Bootstrap();
		
		bootstrap.group(group).channel(NioSocketChannel.class)
		.option(ChannelOption.TCP_NODELAY, true)
		.option(ChannelOption.SO_KEEPALIVE, true)
				.handler(new ChannelInitializer<Channel>() {
					@Override
					protected void initChannel(Channel ch) throws Exception {
						ch.pipeline().addLast(nsClientHandler);
					}
				});

		
		ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
		Channel channel = channelFuture.channel();
		return channel;
	}
}
