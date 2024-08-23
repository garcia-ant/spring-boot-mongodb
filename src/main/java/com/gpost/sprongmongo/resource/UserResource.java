package com.gpost.sprongmongo.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpost.sprongmongo.domain.User;
import com.gpost.sprongmongo.dto.UserDTO;
import com.gpost.sprongmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	// Retorna uma lista de todos os usuários
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> lisDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(lisDto);
	}
}
