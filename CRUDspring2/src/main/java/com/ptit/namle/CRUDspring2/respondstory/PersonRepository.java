package com.ptit.namle.CRUDspring2.respondstory;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.namle.CRUDspring2.entity.Person;
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
