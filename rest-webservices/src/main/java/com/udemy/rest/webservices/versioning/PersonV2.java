                    package com.udemy.rest.webservices.versioning;

public class PersonV2 {
	
	private Name name;

	public PersonV2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public PersonV2() {
		super();
	}

	public void setName(Name name) {
		this.name = name;
	}

}
