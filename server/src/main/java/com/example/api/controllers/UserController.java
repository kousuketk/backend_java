package com.example.api.controllers;

import java.util.List;
import java.util.Optional;
import com.example.api.entity.User;
import com.example.api.repository.UserRepository;
import com.example.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
  UserService userService;

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.findUsers();
	}
	@RequestMapping(path = "/users/{userId}", method = RequestMethod.GET)
	public Optional<User> getOneUser(@PathVariable("userId") Integer id) {
		return userService.findById(id);
	}

	@RequestMapping(path = "/users", method = RequestMethod.POST)
	public User createUser(@RequestBody User obj) {
		return userService.createUser(obj);
	}

	@RequestMapping(path = "/users/{userId}", method = RequestMethod.PUT)
	public User updateUser(@PathVariable("userId") Integer id, @RequestBody User obj) {
		return userService.updateUser(obj);
	}

	@RequestMapping(path = "/users/{userId}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable("userId") Integer id) {
		userService.deleteById(id);
	}
}