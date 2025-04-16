package com.demo.workshopMongo.dto;

import java.io.Serializable;

import com.demo.workshopMongo.domain.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private String email;
	
	public UserDTO(User obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
	}
}
