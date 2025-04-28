package com.demo.workshopMongo.dto;

import java.io.Serializable;

import com.demo.workshopMongo.domain.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public AuthorDTO(User obj) {
		id = obj.getId();
		name = obj.getNome();
	
	}
}
