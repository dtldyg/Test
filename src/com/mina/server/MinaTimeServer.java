package com.mina.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * @author liyiyue
 * @date 2017年3月31日下午6:12:02
 * @desc mina_服务器主类
 */
public class MinaTimeServer {
	private static final int PORT = 9123;

	public static void main(String[] args) throws IOException {
		// 创建监听器
		IoAcceptor acceptor = new NioSocketAcceptor();
		// 设置过滤器
		acceptor.getFilterChain().addLast("Logger", new LoggingFilter()); // 日志过滤器
		acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8")))); // 编码过滤器
		// 设置空闲等待时间
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 3);
		// 设置buffer大小
		acceptor.getSessionConfig().setReadBufferSize(2048);

		// 设置handler
		acceptor.setHandler(new TimeServerHandler());
		// 打开监听
		acceptor.bind(new InetSocketAddress(PORT));
		System.out.println("Mina server bind on:" + PORT);
	}
}
