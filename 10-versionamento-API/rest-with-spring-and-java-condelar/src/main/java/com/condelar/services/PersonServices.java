package com.condelar.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condelar.data.vo.v1.PersonVO;
import com.condelar.data.vo.v2.PersonVOV2;
import com.condelar.exception.ResourceNotFoundException;
import com.condelar.mapper.DozerMapper;
import com.condelar.mapper.custom.PersonMapper;
import com.condelar.model.Person;
import com.condelar.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	@Autowired
	PersonMapper mapper;

	public PersonVO findById(Long id) {
		logger.info("Finding one person!");
		Person person = getPerson(id);
		return DozerMapper.parceObject(person, PersonVO.class);
	}

	public List<PersonVO> findAll() {
		return DozerMapper.parceListObject(repository.findAll(), PersonVO.class);
	}

	public PersonVO create(PersonVO personVO) {
		logger.info("Creating one person!");

		Person person = DozerMapper.parceObject(personVO, Person.class);
		person = repository.save(person);
		personVO = DozerMapper.parceObject(person, PersonVO.class);

		return personVO;
	}

	public PersonVO update(PersonVO personVO) {
		logger.info("Update one person!");
		Person person = getPerson(personVO.getId());
		person.setFirstName(personVO.getFirstName());
		person.setLastName(personVO.getLastName());
		person.setAddress(personVO.getAddress());
		person.setGender(personVO.getGender());

		person = repository.save(person);
		personVO = DozerMapper.parceObject(person, PersonVO.class);

		return personVO;
	}

	public void delete(Long id) {
		logger.info("delete one person!");

		Person entiti = getPerson(id);
		repository.delete(entiti);
	}

	private Person getPerson(Long id) {
		Person person = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No recors found for this ID!"));
		return person;
	}

	public PersonVOV2 createV2(PersonVOV2 personVO) {
		logger.info("Creating one person V2!");

		Person person = mapper.convertVoToEntiti(personVO);
		person = repository.save(person);
		personVO = mapper.convertEntityToVo(person);

		return personVO;
	}
}
