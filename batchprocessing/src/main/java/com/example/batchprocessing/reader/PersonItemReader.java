package com.example.batchprocessing.reader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.example.batchprocessing.model.Person;

@Configuration
public class PersonItemReader {
	
  @Value("${file.input}")
    private String source;
	
    @Bean
    @StepScope
    public ItemReader<Person> reader() {
    	List<Person> people = new ArrayList<>();
    	people.add(new Person("John", "Doe"));
        people.add(new Person("Jane", "Smith"));
        return new ListItemReader<>(people);
	}
    
    @Bean
    public FlatFileItemReader<Person> csvReader() {
        return new FlatFileItemReaderBuilder<Person>().name("productItemReader")
                .resource(new ClassPathResource(source))
                .linesToSkip(1) // PULE O CABEÇALHO, SE HOUVER
                .delimited()
                .names(new String[]{"firstName", "lastName"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
                    setTargetType(Person.class);
                }})
                .build();
    }
    
}

