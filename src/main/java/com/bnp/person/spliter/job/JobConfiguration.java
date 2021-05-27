package com.bnp.person.spliter.job;

import java.util.Date;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bnp.person.spliter.Person;

@Configuration
public class JobConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	private PersonItemReader personItemReader=new PersonItemReader() ;
	
	private PersonItemWriter personItemWriter =new PersonItemWriter();
	
	private PersonItemProcessor personItemProcessor =new PersonItemProcessor();
	
	
	public JobLauncher jobLauncher() throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        return jobLauncher;
    }
	
	public Job personSplitJob(int subListSize) {
		return this.jobBuilderFactory.get("personSplitJob").start(step1(subListSize)).build();
	}

	
	
	public void lunchJob(int subListSize) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException, Exception {
		
		JobExecution jobExecution = jobLauncher()
		          .run(personSplitJob(subListSize), new JobParametersBuilder()
		            .addDate("launchDate", new Date())
		            .toJobParameters());
	}
	
	//step1 pour le service 1
	@Bean
	public Step step1(int subListSize) {
		return this.stepBuilderFactory
				.get("step1").<Person, List<List<Person>>>chunk(subListSize)
				.reader(personItemReader)
				.processor(personItemProcessor)
				.writer(personItemWriter)
				.build();
	}
	
	/**
	step pour le service 2
	
	On va utiliser Stream et l'expression lambda por le service 2
	
	Stream<Person> sp=list.stream(); // pour afficher la liste des personne
	
	sp=listePerson.stream();
	sp.filter(p-->p.getAget()>40);


*/
	

	

}
