package com.gpost.sprongmongo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpost.sprongmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {


    // Retorna uma lista de todos os usuários
    @GetMapping
    public ResponseEntity<List< User>> findAll() {
        User mar = new User("1", "Mar Antonio", "mar@gmail.com");
        User alex = new User("2", "Alex Antonio", "alex@gmail.com");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(mar, alex));

        return ResponseEntity.ok().body(list);
    }
}
