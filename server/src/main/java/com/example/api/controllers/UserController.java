package com.example.api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Date;
import com.example.api.entity.User;
import com.example.api.repository.UserRepository;
import com.example.api.service.UserService;
import com.example.api.serializer.UserSerializer;
import com.example.api.serializer.model.UserInfo;
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
	public List<UserInfo> getUsers() {
		List<User> users = userService.findUsers();
		List<UserInfo> result = UserSerializer.serializeListUsers(users);
		return result;
	}

	@RequestMapping(path = "/{userId}", method = RequestMethod.GET)
	public UserInfo getOneUser(@PathVariable("userId") Integer params_id) {
		Optional<User> user = userService.findById(params_id);
		UserInfo result = UserSerializer.serializeOptionalUser(user);
		return result;
	}

	// createに問題ある
	@RequestMapping(method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		user.setCreated_at(new Date());
		user.setUpdated_at(new Date());
		user.setPassword_digest(user.getPassword_digest());
		User result = userService.createUser(user);
		return result;
	}

	@RequestMapping(path = "/{userId}", method = RequestMethod.PUT)
	public UserInfo updateUser(@PathVariable("userId") Integer params_id, @RequestBody User params_user) {
		User user = userService.updateUser(params_user);
		UserInfo result = UserSerializer.serializeUser(user);
		return result;
	}

	@RequestMapping(path = "/{userId}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable("userId") Integer params_id) {
		userService.deleteById(params_id);
	}
}