package com.example.api.controllers;

import java.util.List;
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

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User userGet() {
		// return userRepository.findAll();
		return new User(4, "saf", "eeee@email.com");
	}

	@RequestMapping(value = "/user/test", method = RequestMethod.GET)
	public User getUserByName2() {
		return userService.findUserByName("test_user1");
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	List<User> getUsers() {
		return userService.findUsers();
	}

	@RequestMapping(path = "/user/post", method = RequestMethod.POST)
	public User insertUser(@RequestBody User obj) {
		return userService.save(obj);
	}

}