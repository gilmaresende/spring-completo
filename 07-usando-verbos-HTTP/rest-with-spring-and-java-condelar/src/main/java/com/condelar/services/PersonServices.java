package com.condelar.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.condelar.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public Person findById(String id) {
		logger.info("Finding one person!");

		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Dev");
		person.setLastName("Java");
		person.setAddress("Net - Wold");
		person.setGender("M");
		return person;
	}

	public List<Person> findAll() {

		logger.info("Finding all peoples!");
		List<Person> peoples = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			peoples.add(mockPerson(i));
		}
		return peoples;
	}

	public Person create(Person person) {
		logger.info("Creating one person!");
		return person;
	}

	public Person update(Person person) {
		logger.info("Update one person!");
		return person;
	}

	public void delete(String id) {
		logger.info("delete one person!");
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(i + 1L);
		person.setFirstName("Dev" + i);
		person.setLastName("Java" + i);
		person.setAddress("Net - Wold" + i);
		person.setGender("M");
		return person;
	}

}
