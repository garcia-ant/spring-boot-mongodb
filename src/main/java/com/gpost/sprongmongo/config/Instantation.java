package com.gpost.sprongmongo.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gpost.sprongmongo.domain.Post;
import com.gpost.sprongmongo.domain.User;
import com.gpost.sprongmongo.dto.AuthorDTO;
import com.gpost.sprongmongo.dto.CommentDTO;
import com.gpost.sprongmongo.repository.PostRepository;
import com.gpost.sprongmongo.repository.UserRepository;

@Configuration
public class Instantation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		// Limpar dados antigos
		userRepository.deleteAll();
		postRepository.deleteAll();

		// Criar usuários
		User pio = new User(null, "Garcia Piota", "piota@gmail.com");
		User pombo = new User(null, "Albano Pombo", "pombo@gmail.com");
		User isi = new User(null, "Isidoro Capita", "isi@gmail.com");

		// Salvar usuários no repositório de usuários
		userRepository.saveAll(Arrays.asList(pio, pombo, isi));
		
		// Criar posts
		Post post1 = new Post(null, sdf.parse("21/08/2024"), "Férias de verão", "Vou viajar para Spain",
				new AuthorDTO(pio));
		Post post2 = new Post(null, sdf.parse("24/08/2024"), "Boas", "Hoje vou nadar na praia de Ibiza",
				new AuthorDTO(pio));
		

		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("27/08/2024"),new AuthorDTO(pombo));
		CommentDTO c2 = new CommentDTO("Enjoy", sdf.parse("28/08/2024"),new AuthorDTO(isi));		
		CommentDTO c3 = new CommentDTO("Have a nice day!", sdf.parse("21/08/2024"),new AuthorDTO(pombo));		// Associar os posts ao usuário
		
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		// Salvar posts no repositório de posts
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		pio.getPosts().addAll(Arrays.asList(post1, post2));
		// Atualizar o usuário no banco de dados
		userRepository.save(pio);
	}
}
