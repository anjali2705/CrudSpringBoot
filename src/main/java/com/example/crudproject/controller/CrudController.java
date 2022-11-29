package com.example.crudproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudproject.model.User;
import com.example.crudproject.service.CrudService;


@RestController
public class CrudController {
	
	@Autowired
	private CrudService service;
	
	   //Save User
	    @PostMapping("/registeruser")
	    @CrossOrigin("http://localhost:3000")
         public User saveUser(@RequestBody User user) {
        		User userObj = null;
            	userObj = service.saveUser(user);
            	return userObj;
         }
         
	    //Display User
	    @GetMapping("/show")
	    @CrossOrigin("http://localhost:3000")
         public List<User> showUser() {
        	 return service.getAllUser();
         }
	    
	    //Update User By Id
	    @PutMapping("/user/{id}")
	    @CrossOrigin("http://localhost:3000")
	    public void update(@RequestBody User user, @PathVariable Integer id) {
	    	 User existuser = service.get(id).get();
	    	  existuser.setAddress(user.getAddress());
	    	  existuser.setEmail(user.getEmail());
	    	  existuser.setMobile(user.getMobile());
	    	  existuser.setName(user.getName());
	    	  existuser.setPassword(user.getPassword());
	    	  service.saveUser(existuser);
	    }
 
	    //DeleteUserById
	    @DeleteMapping("/user/{id}")
	    @CrossOrigin("http://localhost:3000")
	    public void delete(@PathVariable Integer id) {
	    	int productid = (int)id;
	        service.delete(productid);
	    }
	     
}
