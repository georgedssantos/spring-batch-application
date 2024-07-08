package com.example.batchprocessing.writer;

import com.example.batchprocessing.model.Person;
import com.example.batchprocessing.repository.PersonRepository;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonItemWriter implements ItemWriter<Person> {
	
    private final PersonRepository pessoaRepository;

    @Autowired
    public PersonItemWriter(PersonRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }


	@Override
	public void write(Chunk<? extends Person> people) throws Exception {
		
		people.forEach(person -> System.out.println("Save "+ person.getFirstName()+ " and "+ person.getLastName()));
		
		this.pessoaRepository.saveAll(people);

	}
}
