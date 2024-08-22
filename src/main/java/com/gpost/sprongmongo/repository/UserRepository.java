package com.gpost.sprongmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gpost.sprongmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	
}
