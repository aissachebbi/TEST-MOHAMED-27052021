package com.bnp.person.spliter.job;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.bnp.person.spliter.Person;


public class PersonItemWriter implements ItemWriter<Person>{

	private List<List<Person>> out = new ArrayList<List<Person>>();
	
	
	@Override
	public void write(List<? extends Person> items) throws Exception {
		out.add((List<Person>) items);
		
	}


	public List<List<Person>> getOut() {
		return out;
	}


	public void setOut(List<List<Person>> out) {
		this.out = out;
	}
	
	
	





	

	
}
