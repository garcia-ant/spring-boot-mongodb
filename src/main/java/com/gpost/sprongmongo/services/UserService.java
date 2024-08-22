package com.gpost.sprongmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpost.sprongmongo.domain.User;
import com.gpost.sprongmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository  repository;
	
	public List<User> findAll(){
		return repository.findAll();	
	}
}
