package com.arm.springrest.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arm.springrest.spittr.Spittle;

@Component
public class SpittleRepositoryFakeImpl implements SpittleRepository
{
	private Random longi = new Random();
	private Random latit = new Random();
	private final double rangeMin=0;
	private final double rangeMax=180;

	public List<Spittle> findSpittle(long max, int count) 
	{
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i=0; i<count; i++)
			spittles.add(new Spittle("Spittle "+i, new Date(),
					Math.floor( ((rangeMin+(rangeMax-rangeMin)*longi.nextDouble())*100)/100 ),
					Math.floor( ((rangeMin+(rangeMax-rangeMin)*latit.nextDouble())*100)/100 )
					));
		
		return spittles;
	}

	public Spittle findOne(long spittleId) 
	{
		return new Spittle("Hello everybody!", new Date());
	}

}
