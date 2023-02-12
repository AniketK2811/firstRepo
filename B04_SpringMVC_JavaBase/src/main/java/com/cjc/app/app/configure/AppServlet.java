package com.cjc.app.app.configure;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppServlet implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
	AnnotationConfigWebApplicationContext context= new AnnotationConfigWebApplicationContext();
	
	context.setServletContext(servletContext);
	context.register(AppConfigure.class);
	
	ServletRegistration.Dynamic reDynamic=servletContext.addServlet("dispatcher", new DispatcherServlet(context));
	reDynamic.addMapping("/");
	
	}


	
	
	
}