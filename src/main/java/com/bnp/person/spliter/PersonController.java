package com.bnp.person.spliter;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnp.person.spliter.job.JobConfiguration;
import com.bnp.person.spliter.job.PersonItemProcessor;

@RestController
@RequestMapping("/rest/v1/persons")
public class PersonController {
	
	private Logger logger = LoggerFactory.getLogger(PersonController.class);
	@Autowired
	private JobConfiguration jobConfiguration;
	@PostMapping
	public void listOfPerson(SplitConfiguration splitConfiguration) {
		
		try {
			jobConfiguration.lunchJob(splitConfiguration.getSubListSize());
		} catch (Exception e) {
			logger.error("Error while executing Job", e);
		}
		
	}
	
	@PostMapping
	public void filterOfPerson(SplitConfiguration splitConfiguration) {
		
		try {
			jobConfiguration.lunchJob(splitConfiguration.getSubListSize());
		} catch (Exception e) {
			logger.error("Error while executing Job", e);
		}
		
	}
	
	

}
