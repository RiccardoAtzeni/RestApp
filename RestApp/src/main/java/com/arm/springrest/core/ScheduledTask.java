package com.arm.springrest.core;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ScheduledTask 
{
	private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	//fixedRate: interval between method invocations measured from the start time of each invocations
	//@Scheduled(fixedDelay=10000)
	//@Scheduled(fixedRate=5000)
	@Scheduled(cron="0 0/1 * * * ?")
	public void getJson()
	{
		RestTemplate restTemplate = new RestTemplate();
		//Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		Greeting greeting = restTemplate.getForObject("http://localhost:8080/RestApp/greeting", Greeting.class);
		log.info("The time is now {}", dateFormat.format(new Date()));
		//log.info(quote.toString());
		log.info(greeting.toString());
	}
}
