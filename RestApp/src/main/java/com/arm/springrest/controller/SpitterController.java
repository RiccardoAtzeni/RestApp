package com.arm.springrest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.arm.springrest.data.SpitterRepository;
import com.arm.springrest.spittr.Spitter;

@Controller
@RequestMapping("/spitter")
public class SpitterController 
{
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
			@Valid Spitter spitter, Errors errors)
	{ 
		if(errors.hasErrors()) return "registerForm";
		
		//saveImage(profilePicture);
		spitterRepository.save(spitter);
		return "redirect:/spitter/" + spitter.getUsername();
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showSpitterProfile(
			@PathVariable String username, Model model)
	{
		String view = null;
		Spitter spitter = spitterRepository.findByUsername(username);
		
		if(spitter==null) return "redirect: /homepage";
		else 
		{
			model.addAttribute(spitter);
			return "profile";
		}

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
