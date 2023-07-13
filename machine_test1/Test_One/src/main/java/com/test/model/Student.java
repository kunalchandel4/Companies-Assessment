package com.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity	
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rollNumber ;
	private String name ;
	private Integer marks ;
	

}
