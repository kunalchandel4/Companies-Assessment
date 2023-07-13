package com.test.model;

import lombok.Data;

@Data
public class JwtResponse {

    public JwtResponse(String token2) {
		// TODO Auto-generated constructor stub
    	this.token = token2 ;
	}

	private String token;

    // Constructor, getter, and setter

}

