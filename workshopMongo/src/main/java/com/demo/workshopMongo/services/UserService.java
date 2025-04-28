package com.demo.workshopMongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.workshopMongo.domain.User;
import com.demo.workshopMongo.dto.UserDTO;
import com.demo.workshopMongo.repository.UserRepository;
import com.demo.workshopMongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		 return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = repo.findById(obj.getId()).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), null);
	}
	
	
}
