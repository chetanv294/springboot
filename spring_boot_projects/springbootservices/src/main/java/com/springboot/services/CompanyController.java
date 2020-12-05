package com.springboot.services;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.custom.exception.RecordNotFoundException;
import com.springboot.services.model.Person;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class CompanyController {

	@GetMapping("/duplicate/{id}")
    public ResponseEntity<Person> findOne(@PathVariable Long id) throws Exception{
		Person p = new Person();
		p.setName("welcome");
		ArrayList al =new ArrayList(0);
		al.add("abc");
		al.add("abc");
		
		if(id==0) {
			//throw new RuntimeException("Employee id '" + id + "' is duplicate");
			//throw new RecordNotFoundException("duplicate employee id : " + id);
			throw new RecordNotFoundException("duplicate employee id : " + id, al );
		}
		return new ResponseEntity<Person>( p ,HttpStatus.NOT_FOUND);
		//return p;
	}
}
