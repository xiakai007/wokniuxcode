package com.woniu.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
    
	public MySessionListener() {
		super();
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("session对象被创建了"+arg0.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("session对象被销毁了"+arg0.getSession().getId());
	}

}
