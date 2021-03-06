package com.arm.springrest.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.validation.Valid;

import com.arm.springrest.service.SpitterService;
import com.arm.springrest.util.SpitterRoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arm.springrest.data.SpitterRepository;
import com.arm.springrest.spittr.Spitter;

@Controller
@RequestMapping("/spitter")
public class SpitterController 
{
	@Autowired
	private SpitterService spitterService;

	private SpitterRepository spitterRepository;
	
	@Autowired
	public SpitterController(SpitterRepository spitterRepository)
	{
		this.spitterRepository=spitterRepository;
	}

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationForm(Model model)
	{
		model.addAttribute(new Spitter());
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegistration(@RequestPart("profilePicture") MultipartFile profilePicture,
			@Valid Spitter spitter, Errors errors, RedirectAttributes model) throws IllegalStateException
	{ 
		try
		{
			if(errors.hasErrors()) return "registerForm";
			//saveImage(profilePicture);
			spitterRepository.save(spitter);        
			if(profilePicture!=null && !profilePicture.getOriginalFilename().isEmpty())
				profilePicture.transferTo(new File("C:/Users/Public/springmvc_upload/"+profilePicture.getOriginalFilename()));
			
			model.addAttribute("username",spitter.getUsername());
			model.addFlashAttribute("spitter",spitter);

			com.arm.springrest.model.Spitter s = new com.arm.springrest.model.Spitter();
			s.setUsername(spitter.getUsername());
			s.setPassword(spitter.getPassword());
			s.setEmail(spitter.getEmail());
			s.setEnabled(true);
			s.setFirstname(spitter.getFirstName());
			s.setLastname(spitter.getLastName());
			s.setInsert_date(Calendar.getInstance());
			s.setLast_update(Calendar.getInstance());
			s.setRole_user(SpitterRoleEnum.USER);

			spitterService.createSpitter(s);


			
		}catch(IOException e){
			//there's no need to handle this specific IOException
			if(!e.getMessage().toLowerCase().contains("Failed to perform cleanup of multipart items"))
				e.printStackTrace();
		}
		
		return "redirect:/spitter/{username}";
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showSpitterProfile(
			@PathVariable String username, Model model)
	{
		if( (model.containsAttribute("spitter")) && (spitterRepository.findByUsername(username)!=null) )
			return "profile";
		else
			return "redirect:/welcome";
		
	}
	
	
	/*
	private void saveImage(MultipartFile image) //throws ImageUploadException
	{
		String s3AccessKey="AKIAI53MPQDOKW2YREOQ";
		String s2SecretKey="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";
		
		try
		{
			AWSCredentials awsCredentials = new AWSCredentials(s3AccessKey,s2SecretKey);
			S3Service s3 = new RestS3Service(awsCredentials);
			S3Bucket bucket = s3.getBucket("spittrimages");
			//bucket.setOwner(s3.getAccountOwner());
			S3Object imageObject = new S3Object(image.getOriginalFilename());
			
			imageObject.setDataInputStream(image.getInputStream());
			imageObject.setContentLength(image.getSize());
			imageObject.setContentType(image.getContentType());
			
			AccessControlList acl = new AccessControlList();
			//acl.setOwner(bucket.getOwner());
			acl.grantPermission(GroupGrantee.ALL_USERS, Permission.PERMISSION_READ);
			imageObject.setAcl(acl);
			
			s3.putObject(bucket, imageObject);			
		}catch(Exception e)
		{
			System.out.println("Image cannot be saved");
			e.printStackTrace();
		}
	}*/
}
