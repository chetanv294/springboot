package com.developerstack.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.services.model.Person;

@RestController
public class PersonController {

	@Autowired
	private Person person;
	
	@RequestMapping("/healthCheck")
	public String healthCheck() {
		System.out.println("healthCheck : call...");
		return "OK";
	}
	
	@RequestMapping("/person/get")
	public Person getPerson(@RequestParam(name="name", required=false, defaultValue="java") String name) {
		// name = "chetan";
		person.setName( name );
		
		return person;
	}
	
//	@RequestMapping(value="/person/update", method=RequestMethod.POST)
//	public Person updatePerson(@RequestParam(name="name", required=true) String name) {
//		person.setName(name);
//		return person;
//	}
	
	@RequestMapping(value="/person/update", method=RequestMethod.POST, consumes = "application/json")
	public Person updatePerson(@RequestBody Person p) {
		person.setName(p.getName());
		return person;
	}
}