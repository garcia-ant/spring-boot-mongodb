package com.gpost.sprongmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpost.sprongmongo.domain.Post;
import com.gpost.sprongmongo.repository.PostRepository;
import com.gpost.sprongmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	// Busca um usuário pelo ID
	public Post findById(String id) {
		Optional<Post> Post = repository.findById(id);
		return Post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

}
