package com.example.spring.resources;

import com.example.spring.model.entities.User;
import com.example.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.print.attribute.standard.Media;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> userList = userService.findAllUsers();

        return ResponseEntity.ok().body(userList);
    }
    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findUserById(@PathVariable(value = "userId") long userId) {
        User user = userService.findUserById(userId);

        return ResponseEntity.ok().body(user);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        User user = userService.createUser(newUser);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody User userArgument) {
        User userPersistence = userService.updateUser(userArgument);

        return ResponseEntity.ok().body(userPersistence);
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "userId") long userId) {
        userService.deleteUser(userId);

        return ResponseEntity.noContent().build();
    }
}
