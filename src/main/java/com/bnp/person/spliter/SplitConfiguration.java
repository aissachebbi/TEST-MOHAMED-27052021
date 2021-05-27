package com.bnp.person.spliter;

import java.util.List;

public class SplitConfiguration {
	
	private List<Person> persons;
	private int subListSize;
	
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	public int getSubListSize() {
		return subListSize;
	}
	public void setSubListSize(int subListSize) {
		this.subListSize = subListSize;
	}
	

}
