package com.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.entity.User;
import com.project.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private final UserService userService;
	
    public UserController(UserService userService) {
        this.userService = userService;
    }

@PostMapping
public ResponseEntity<User> registerUser(@RequestBody User user){
	return new ResponseEntity <User>(userService.registerUser(user),HttpStatus.CREATED);
	}


@GetMapping("/{id}")
public ResponseEntity<User> getUserById(@PathVariable Integer id) {
    User user = userService.getUserById(id);
    return new ResponseEntity<>(user, HttpStatus.OK);
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteUserById(@PathVariable Integer id){
	userService.deleteUserById(id);
	return new ResponseEntity<String>("The User is deleted successfully",HttpStatus.OK );
}
@GetMapping
public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.getAllUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
}

@PutMapping("/{id}")
public ResponseEntity<User> updateUserById(@PathVariable Integer id, @RequestBody User user ){
	return new ResponseEntity<User>(userService.UpdateUserById(id, user), HttpStatus.OK);

}
@PostMapping("login")
public ResponseEntity<User> loginUser(@RequestBody User user) {
	return new ResponseEntity<User> (this.userService.loginUser(user),HttpStatus.OK);
}

}

