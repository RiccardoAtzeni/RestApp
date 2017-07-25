package com.arm.springrest.config;

import com.arm.springrest.config.*;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

	//Routing the request through all other components: automatically used
	//to configure a DispatcherServlet and the Spring application Context
	public class RestAppWebInitializer 
		extends AbstractAnnotationConfigDispatcherServletInitializer{
		
		//temporany location where files will be stored
		private static final String LOCATION ="C:/Users/Public/springmvc_storage";
		//5 MB: Max File size (beyond that size sping will throw exception
		private static final long MAX_FILE_SIZE=5242880;
		//20 MB: Total request size containing Multi part
		private static final long MAX_REQUEST_SIZE=20971520;
		//Size threshold after which files will be written to disk
		private static final int FILE_SIZE_THRESHOLD = 0;
		
		
		@Override
		protected Class<?>[] getRootConfigClasses() {
			return new Class<?>[] { RootConfig.class };
		}

		//Specify configuration class
		@Override
		protected Class<?>[] getServletConfigClasses() {
			return new Class<?>[] { WebConfig.class };
		}

		//Map DispatcherServlet to / : it's the default servlet
		@Override
		protected String[] getServletMappings() {
			return new String[] { "/" };
		}
		
		@Override
		protected void customizeRegistration(ServletRegistration.Dynamic registration)
		{
			registration.setMultipartConfig(getMultipartConfigElement());
		}
		
		private MultipartConfigElement getMultipartConfigElement()
		{
			MultipartConfigElement multipartConfigElement = new MultipartConfigElement(
					LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
			return multipartConfigElement;
		}

	}