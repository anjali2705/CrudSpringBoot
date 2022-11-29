package com.example.crudproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudproject.model.User;
import com.example.crudproject.repository.CrudRepository;

@Service
public class CrudService {
	
	@Autowired
	private CrudRepository repo;

	public User saveUser(User user) {
		
		return repo.save(user) ;
	}

	public List<User> getAllUser() {
		return repo.findAll();  
	}

	public void delete(int id) {
	   repo.deleteById(id);
		
	}

	public Optional<User> get(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}


	


	
}
