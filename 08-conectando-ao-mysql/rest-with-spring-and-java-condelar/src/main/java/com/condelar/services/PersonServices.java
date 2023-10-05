package com.condelar.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condelar.exception.ResourceNotFoundException;
import com.condelar.model.Person;
import com.condelar.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public Person findById(Long id) {
		logger.info("Finding one person!");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No recors found for this ID!"));
	}

	public List<Person> findAll() {
		return repository.findAll();
	}

	public Person create(Person person) {
		logger.info("Creating one person!");
		return repository.save(person);
	}

	public Person update(Person person) {
		logger.info("Update one person!");
		Person entiti = findById(person.getId());

		entiti.setFirstName(person.getFirstName());
		entiti.setLastName(person.getLastName());
		entiti.setAddress(person.getAddress());
		entiti.setGender(person.getGender());

		return repository.save(entiti);
	}

	public void delete(Long id) {
		logger.info("delete one person!");

		Person entiti = findById(id);
		repository.delete(entiti);
	}
}
