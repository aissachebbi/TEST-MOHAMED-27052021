package com.bnp.person.spliter.job;
import org.springframework.batch.item.ItemReader;

import com.bnp.person.spliter.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
 
public class PersonItemReader implements ItemReader<Person> {
 
    private int nextPersonIndex;
    private List<Person> personData;
 
    @Override
    public Person read() throws Exception {
    	Person nextStudent = null;
 
        if (nextPersonIndex < personData.size()) {
            nextStudent = personData.get(nextPersonIndex);
            nextPersonIndex++;
        }
        else {
        	nextPersonIndex = 0;
        }
 
        return nextStudent;
    }

 
  
}
