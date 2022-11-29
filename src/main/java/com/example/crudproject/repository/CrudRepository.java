package com.example.crudproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudproject.model.User;

public interface CrudRepository  extends JpaRepository<User, Integer> {


}
