package com.arm.springrest.spittr;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

public class Spitter 
{
	private Long id;
	
	@NotNull
	@Size(min=5, max=16, message="{username.size}")
	private String username;
	
	@NotNull
	@Size(min=5, max=25, message="{password.size}")
	private String password;
	
	@NotNull
	@Size(min=2, max=30, message="{firstname.size}")
	private String firstName;
	
	@NotNull
	@Size(min=2, max=30, message="{lastname.size}")
	private String lastName;
	
	@NotNull
	@Email(message="{email.valid}")
	private String email;
	
	public Spitter(String username,String password,String firstName,String lastName)
	{
		this.id=null;
		this.username=username;
		this.password=password;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=null;
	}
	
	public Spitter(Long id, String username,String password,String firstName,String lastName)
	{
		this.id=id;
		this.username=username;
		this.password=password;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=null;
	}
	
	public Spitter(){}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
