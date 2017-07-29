package com.arm.springrest.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppWideExceptionHandler 
{
	@ExceptionHandler(ResourceNotFoundException.class)
	public String resourceNotFound()
	{
		return "error/noresource";
	}
	
	@ExceptionHandler(IllegalStateException.class)
	public String illegalState()
	{
		return "error/bad_request";
	}
}
