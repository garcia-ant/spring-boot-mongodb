package com.gpost.sprongmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gpost.sprongmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	
}
