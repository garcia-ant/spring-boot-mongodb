package com.gpost.sprongmongo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gpost.sprongmongo.domain.Post;
import com.gpost.sprongmongo.resource.util.URL;
import com.gpost.sprongmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id); // Chamando o método correto que retorna um único User
		return ResponseEntity.ok().body(obj); // Retorna o DTO do objeto User
	}

	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title", defaultValue = "") String title) {
		title = URL.decodeparam(title);
		List<Post> list = service.findByTitle(title);
		return ResponseEntity.ok().body(list);
	}

}