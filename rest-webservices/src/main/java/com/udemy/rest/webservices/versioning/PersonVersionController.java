package com.udemy.rest.webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {

	// version option 1
	//  use different URL compeletely
	@GetMapping("v1/person")
	public PersonV1 personV1(){
		return new PersonV1("Bob Charles");
	}

	@GetMapping("v2/person")
	public PersonV2 personV2(){
		return new PersonV2(new Name("Bob","Charles"));
	}
	

	// version option 2
	//  use same URL but with different parameters
	
	
	@GetMapping(value="/person/param", params="version=1")
	// use http://localhost:8080/person/param?version=1
	public PersonV1 paramV1(){
		return new PersonV1("Bob Charles");
	}

	@GetMapping(value="/person/param", params="version=2")
	//use http://localhost:8080/person/param?version=2
	public PersonV2 paramV2(){
		return new PersonV2(new Name("Bob","Charles"));
	}
	

	// version option 3
	//  use same URL but with "X-API-VERSION" header parameters
	// not as good for caching because you would have to look at the headers
	
	@GetMapping(value="/person/header", headers="X-API-VERSION=1")
	// use http://localhost:8080/person/header with proper header variable
	public PersonV1 headerV1(){
		return new PersonV1("Bob Charles");
	}

	@GetMapping(value="/person/header", headers="X-API-VERSION=2")
	//use http://localhost:8080/person/header with proper header variable
	public PersonV2 headerV2(){
		return new PersonV2(new Name("Bob","Charles"));
	}
	
	
	// version option 4
	//  use same URL but with "Accept" header parameters
	// not as good for caching because you would have to look at the headers
	
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")
	// use http://localhost:8080/person/header with proper header variable
	public PersonV1 producesV1(){
		return new PersonV1("Bob Charles");
	}

	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v2+json")
	//use http://localhost:8080/person/header with proper header variable
	public PersonV2 producesV2(){
		return new PersonV2(new Name("Bob","Charles"));
	}
}
