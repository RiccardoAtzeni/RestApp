package com.arm.springrest.core;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.arm.springrest.data.FileBucket;

@Component
public class FileValidator implements Validator
{
 
	@Override
	public boolean supports(Class<?> clazz) 
	{
		return FileBucket.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) 
	{
		FileBucket file = (FileBucket) obj;
		
		try
		{
			if(file.getFile()!=null && file.getFile().isEmpty())	
				errors.rejectValue("file", "missing.file");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
