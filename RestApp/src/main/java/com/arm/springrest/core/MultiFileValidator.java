package com.arm.springrest.core;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.arm.springrest.data.FileBucket;
import com.arm.springrest.data.MultiFileBucket;

@Service("fileValidator")
public class MultiFileValidator implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) 
	{
		return MultiFileBucket.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) 
	{
		int index=0;
		MultiFileBucket multiFileBucket = (MultiFileBucket) obj;
		
		for (FileBucket file : multiFileBucket.getFiles())
		{
			if( (file.getFile()==null) || file.getFile().getSize()==0)
				errors.rejectValue("files["+index+"].file", "missing.file");
			
			index++;
		}
		
	}

}
