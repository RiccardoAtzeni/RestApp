package com.arm.springrest.controller;

import java.util.List;

import com.arm.springrest.service.SpittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.arm.springrest.data.SpittleRepository;
import com.arm.springrest.exception.ResourceNotFoundException;
import com.arm.springrest.spittr.Spittle;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/spittle")
public class SpittleController 
{
	private SpittleRepository spittleRepository;

	@Autowired
	private SpittleService spittleService;
	
	@Autowired
	public SpittleController(SpittleRepository spittleRepository) 
	{
		this.spittleRepository=spittleRepository;
	}
	
	public SpittleController()
	{
		spittleRepository=null;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String spittles(Model model,
			//@RequestParam(value="max", defaultValue="100000000") long max,
			@RequestParam(value="maxperiod", defaultValue="20") int maxperiod)
	{
		//model is like a map: if the key is not stated, it will be the type of the 
	  //value: in this case spittleList
	  //model.addAttribute("spittleList", spittleRepository.findSpittle(max, count));
		model.addAttribute("spittleList",spittleService.findLatest(maxperiod));

	  return "spittles";
	}
	
	@RequestMapping(value="/show", method=RequestMethod.GET)
	public String showSpittle(
			@RequestParam("spittle_id") long spittleId, Model model)
	{
		Spittle spittle = spittleRepository.findOne(spittleId);
		spittle=null;
		if (spittle==null)
			throw new ResourceNotFoundException();
		
		return "spittle"; 
	}
	
	@RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
	public String spittle(
			@PathVariable long spittleId, Model model)
	{
		Spittle spittle = spittleRepository.findOne(spittleId);
		if (spittle==null)
			throw new ResourceNotFoundException();
		
		model.addAttribute(spittle);
		return "spittle";
	}	
	
}
