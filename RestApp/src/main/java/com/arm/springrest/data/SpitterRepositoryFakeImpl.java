package com.arm.springrest.data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Component;

import com.arm.springrest.spittr.Spitter;

@Component
public class SpitterRepositoryFakeImpl implements SpitterRepository
{
	List<Spitter> spitters = new ArrayList<Spitter>();

	public Spitter save(Spitter unsaved) 
	{
		unsaved.setId(ThreadLocalRandom.current().nextLong(Long.MAX_VALUE));
		spitters.add(unsaved);
		return unsaved;
	}

	public Spitter findByUsername(String username) 
	{
		for(Spitter s: spitters)
		{
			if(s.getUsername().equals(username)) return s;
		}
		
		return null;
	}

}
