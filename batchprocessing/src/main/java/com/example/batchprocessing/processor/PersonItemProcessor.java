package com.example.batchprocessing.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.batchprocessing.model.Person;

@Component
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

	@Override
	public Person process(Person person) throws Exception {

		String firstName = person.getFirstName();
		String lastName = person.getLastName();

		// VERIFICA SE FIRSTNAME E LASTNAME SÃO NULOS ANTES DE CONVERTER PARA MAIÚSCULO
		if (firstName != null) {
			firstName = firstName.toUpperCase();
		}
		if (lastName != null) {
			lastName = lastName.toUpperCase();
		}

		Person transformedPerson = new Person(firstName, lastName);

		System.out.println("Processing first Name " + person.getFirstName() + " into " + transformedPerson.getFirstName()
						+ " and last Name " + person.getLastName() + " into " + transformedPerson.getLastName());

		return transformedPerson;
	}
}
