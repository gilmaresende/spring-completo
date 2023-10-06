package com.condelar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condelar.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
