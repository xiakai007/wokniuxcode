package com.woniu.listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
@WebListener
public class MyOnlineListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
        String name=arg0.getName();
        if(name.equals("loginUser")){
        	ServletContext app=arg0.getSession().getServletContext();
        	int count=0;
        	if(app.getAttribute("online")!=null){
        		count=(Integer)app.getAttribute("online");
        	}
        	count++;
        	app.setAttribute("online", count);
        }
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		String name=arg0.getName();
        if(name.equals("loginUser")){
        	ServletContext app=arg0.getSession().getServletContext();
        	if(app.getAttribute("online")!=null){
        		int count=(Integer)app.getAttribute("online");
        		count--;
            	app.setAttribute("online", count);
        	}
        }
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
