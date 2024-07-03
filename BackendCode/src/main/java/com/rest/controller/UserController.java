package com.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entity.User;
import com.rest.service.UserService;
//@RequestMapping("user")
@RestController
public class UserController {
	
	@Autowired
	private UserService uService;

	@PostMapping("/add")
	public User createUser(@RequestBody User u1) {
		return uService.newUser(u1);
	}

	@GetMapping("/getall")
	public List<User> ListUser() {
		return uService.getAllUser();
	}

	@GetMapping("/getone/{id}")
	public Optional<User> findIndivitualBook(@PathVariable Long id) {
		return uService.getSingleUser(id);
	}

	@DeleteMapping("/del/{id}")
	public void deleteUser(@PathVariable Long id) {
		uService.dltUser(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserByID(@PathVariable Long id) {
		User u = uService.getSingleUser1(id);
		if (u == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(u);
		}
	}

	@GetMapping("/update/{id}")
	public ResponseEntity<User> UpdateUserByID(@PathVariable Long id, @RequestBody User z) {
		User u = uService.UpdateSingleUser1(id, z);
		if (u == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(u);
		}
	}


}

