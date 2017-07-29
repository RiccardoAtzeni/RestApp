package com.arm.springrest.spittr;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Spittle 
{
	private static final String[] excludeFields = {"id", "time"};
	private final Long id;
	private final String message;
	private final Date time;
	private final Double latitude;
	private final Double longitude;
	
	public Spittle(String message, Date time)
	{
		this.id=null;
		this.message=message;
		this.time=time;
		this.latitude=null;
		this.longitude=null;
	}
	
	public Spittle(String message, Date time, Double longitude, Double latitude)
	{
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		
		this.id=(long) ThreadLocalRandom.current().nextInt(min, max);
		this.message=message;
		this.time=time;
		this.latitude=latitude;
		this.longitude=longitude;
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public Date getTime() {
		return time;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	@Override
	public int hashCode() 
	{
		return HashCodeBuilder.reflectionHashCode(this, excludeFields);
	}

	@Override
	public boolean equals(Object that) 
	{
		return EqualsBuilder.reflectionEquals(this, that, excludeFields);
	}
	
	
	
}
