package com.condelar.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.condelar.data.vo.v2.PersonVOV2;
import com.condelar.model.Person;

@Service
public class PersonMapper {

	public PersonVOV2 convertEntityToVo(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setBirthDay(new Date());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		return vo;
	}
	
	public Person convertVoToEntiti(PersonVOV2 vo) {
		Person entiti = new Person();
		entiti.setId(vo.getId());
		entiti.setAddress(vo.getAddress());
		//vo.setBirthDay(new Date());
		entiti.setLastName(vo.getLastName());
		entiti.setGender(vo.getGender());
		return entiti;
	}

}
