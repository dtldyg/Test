package com.mina.server;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * @author liyiyue
 * @date 2017年3月31日下午6:24:28
 * @desc mina_服务器业务逻辑主类
 */
public class TimeServerHandler extends IoHandlerAdapter {

	/**
	 * 会话创建
	 */
	@Override
	public void sessionCreated(IoSession session) throws Exception {
	}

	/**
	 * 会话打开
	 */
	@Override
	public void sessionOpened(IoSession session) throws Exception {
	}

	/**
	 * 会话空闲
	 */
	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
	}

	/**
	 * 消息接收
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		System.out.println(message.toString());
		session.write("Roger that!");
	}

	/**
	 * 消息发送
	 */
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
	}

	/**
	 * 会话关闭
	 */
	@Override
	public void sessionClosed(IoSession session) throws Exception {
	}

	/**
	 * 捕获异常
	 */
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		cause.printStackTrace();
	}

}
