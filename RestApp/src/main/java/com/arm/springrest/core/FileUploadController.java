package com.arm.springrest.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.arm.springrest.data.FileBucket;
import com.arm.springrest.data.MultiFileBucket;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@Controller
public class FileUploadController 
{
	private static String UPLOAD_LOCATION="C:/Users/Public/springmvc_upload/";
	
	
	@Autowired
	private FileValidator filevalidator;
	
	//@InitBinder identifies WebDataBinder method in the controller
	@InitBinder("fileBucket")
	protected void initBinderFileBucket(WebDataBinder binder){
		binder.setValidator(filevalidator);
	}
	
	@Autowired
	private MultiFileValidator multiFileValidator;
	
	@InitBinder("multiFileBucket")
	protected void initBinderMultiFileBucket(WebDataBinder binder){
		binder.setValidator(multiFileValidator);
	}
	
	@RequestMapping(value= {"/","/welcome"}, method=RequestMethod.GET)
	public String getHomePage (ModelMap model)
	{
		return "welcome";
	}
	
	@RequestMapping(value="/singleUpload", method=RequestMethod.GET)
	public String getSingleUploadPage(ModelMap model)
	{
		FileBucket fileModel = new FileBucket();
		model.addAttribute("fileBucket",fileModel);
		return "singleFileUploader";
	}
	
	@RequestMapping(value="/singleUpload", method=RequestMethod.POST)
	public String singleFileUpload (@Validated FileBucket fileBucket,BindingResult result,
			ModelMap model) throws IOException
	{
		//BindingResult result needs to be immediately after FileBucket fileBucket!!!!!!!
		if(result.hasErrors()){
				System.out.println("validation errors");
				return "singleFileUploader";
			} 
			else {
				System.out.println("Fetching file");
				MultipartFile multipartFile = fileBucket.getFile();
				FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(
						UPLOAD_LOCATION+fileBucket.getFile().getOriginalFilename()));
				String fileName = multipartFile.getOriginalFilename();
				model.addAttribute("fileName",fileName);
				
				if (model.containsAttribute("fileName"))
					System.out.println("I got it");
				
				return "success";
			}		
	}
	
	@RequestMapping(value="/multiUpload", method=RequestMethod.GET)
	public String getMultiUploadPage (ModelMap model)
	{
		MultiFileBucket filesModel = new MultiFileBucket();
		model.addAttribute("multiFileBucket", filesModel);
		return "multiFileUploader";
	}
	
	@RequestMapping(value="/multiUpload", method=RequestMethod.POST)
	public String multiFileUpload(@Valid MultiFileBucket multiFileBucket, 
			BindingResult result,
			ModelMap model) throws IOException
	{
		if(result.hasErrors())
		{
			System.out.println("validation errors in multi upload");
			return "multiFileUploader";
		}
		else
		{
			System.out.println("Fetching files");
			List<String> fileNames = new ArrayList();
			
			for(FileBucket f: multiFileBucket.getFiles())
			{
				FileCopyUtils.copy(f.getFile().getBytes(), new File(UPLOAD_LOCATION+f.getFile().getOriginalFilename()));
				fileNames.add(f.getFile().getOriginalFilename());
			}
			
			model.addAttribute("fileNames",fileNames);
			return "multiSuccess";
		}
	}
}
