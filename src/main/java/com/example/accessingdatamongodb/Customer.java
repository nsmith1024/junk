package com.example.accessingdatamongodb;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;


public class Customer {

	@Id
	public String id;

	public String name;
    public String type;	
	public String description;
	public String imageURL;
	public String modelURL;	
	public ArrayList<String> connected;
	public ArrayList<String> compatible;

	public String firstName;
	public String lastName;

	public Customer() {}

	public Customer(String firstName, String lastName,String name,String type,String description,String imageURL, String modelURL,ArrayList<String> connected, ArrayList<String> compatible) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.name=name;
		this.type=type;
		this.description=description;
		this.imageURL=imageURL;
		this.modelURL=modelURL;
		this.connected=connected;
		this.compatible=compatible;
	}

	@Override
	public String toString() {
		return String.format(
				"Customer[id=%s, firstName='%s', lastName='%s', name='%s', type='%s', description=%s, imageURL=%s, modelURL=%ss]",
				id, firstName, lastName,name,type,description,imageURL,modelURL);
	}

}

