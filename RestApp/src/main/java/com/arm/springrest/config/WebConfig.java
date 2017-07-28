package com.arm.springrest.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= "com.arm.springrest")
//@EnableScheduling
public class WebConfig extends WebMvcConfigurerAdapter
{
	@Bean(name= "multipartResolver")
	public StandardServletMultipartResolver resolver()
	{
		return new StandardServletMultipartResolver();
	}
	
	@Bean
	public MessageSource messageSource()
	{	//file properties under resources folder 
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("file:/Users/Riccardo/Documents/Restapp_config/messages");
		return messageSource;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry)
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		//true: make all Spring beans in the app context accessible as request attribute
		//viewResolver.setExposeContextBeansAsAttributes(true);
		registry.viewResolver(viewResolver);
	}
	
	    //to serve static resources
		@Override
		public void configureDefaultServletHandling(
				DefaultServletHandlerConfigurer configurer) 
		{
			configurer.enable();
		}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		//set path to static resources like css 
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
}
