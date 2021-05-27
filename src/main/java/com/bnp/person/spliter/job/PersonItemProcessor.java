package com.bnp.person.spliter.job;

import org.springframework.batch.item.ItemProcessor;

import com.bnp.person.spliter.Person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

	
	
	private Logger logger = LoggerFactory.getLogger(PersonItemProcessor.class);
	
	@Override
	public Person process(Person person) throws Exception {
		logger.info("Processing Person {}", person);
		return person;
	}

}
