package com.chetan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping({ "/datalist" })
	public String firstPage() {
		return "list successful";
	}

}