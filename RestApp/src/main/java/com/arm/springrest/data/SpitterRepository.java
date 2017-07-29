package com.arm.springrest.data;

import com.arm.springrest.spittr.Spitter;

public interface SpitterRepository 
{
	Spitter save(Spitter unsaved);
	Spitter findByUsername(String username);
}
