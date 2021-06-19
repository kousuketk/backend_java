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
@RequestMapping(path = "/api/users")
public class UserController {
	@Autowired
  UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUsers() {
		List<User> result = userService.findUsers();
		return result;
	}
	@RequestMapping(path = "/{userId}", method = RequestMethod.GET)
	public Optional<User> getOneUser(@PathVariable("userId") Integer params_id) {
		Optional<User> result = userService.findById(params_id);
		return result;
	}

	@RequestMapping(method = RequestMethod.POST)
	public User createUser(@RequestBody User params_user) {
		User result = userService.createUser(params_user);
		return result;
	}

	@RequestMapping(path = "/{userId}", method = RequestMethod.PUT)
	public User updateUser(@PathVariable("userId") Integer params_id, @RequestBody User params_user) {
		User result = userService.updateUser(params_user);
		return result;
	}

	@RequestMapping(path = "/{userId}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable("userId") Integer params_id) {
		userService.deleteById(params_id);
	}
}