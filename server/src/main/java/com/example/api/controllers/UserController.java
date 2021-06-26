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
import org.apache.commons.codec.digest.DigestUtils;

@RestController
@RequestMapping(path = "/api")
public class UserController {
	@Autowired
  UserService userService;

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestBody requestInfo obj) {
    List<User> user = userService.findByEmail(obj.email);
    if(user.isEmpty()) return "login failed. user not found.";
    String pass = user.get(0).getPassword_digest();
    String requestPass = DigestUtils.sha256Hex(obj.password);
		System.out.println(pass);
		System.out.println(obj.password);
		System.out.println(requestPass);
    if(!pass.equals(requestPass)) return "login failed. password is not correct.";
    return "success!";
    // sessionidを発行して, cookie, redisに入れる
		// sessionidの発行の仕方、ランダムでいいのか?
		// キーと値を指定してredisにセット
    // redisに入れるデータ(userid, createdat, expiredat) 
		// stringRedisTemplate.opsForValue().set(key, value);
    // Cookie cookie = new Cookie(key, value);
    // response.addCookie(cookie);
		// return "redisstr/set_end";
	}

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<UserInfo> getUsers() {
		List<User> users = userService.findUsers();
		List<UserInfo> result = UserSerializer.serializeListUsers(users);
		return result;
	}

	@RequestMapping(path = "/users/{userId}", method = RequestMethod.GET)
	public UserInfo getOneUser(@PathVariable("userId") Integer params_id) {
		Optional<User> user = userService.findById(params_id);
		UserInfo result = UserSerializer.serializeOptionalUser(user);
		return result;
	}

	@RequestMapping(path = "/users", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		user.setCreated_at();
		user.setUpdated_at();
		User result = userService.createUser(user);
		return result;
	}

	// me/edit, me/deleteでやる
	// @RequestMapping(path = "/{userId}", method = RequestMethod.PUT)
	// public UserInfo updateUser(@PathVariable("userId") Integer params_id, @RequestBody User params_user) {
	// 	User user = userService.updateUser(params_user);
	// 	UserInfo result = UserSerializer.serializeUser(user);
	// 	return result;
	// }

	// @RequestMapping(path = "/{userId}", method = RequestMethod.DELETE)
	// public void deleteById(@PathVariable("userId") Integer params_id) {
	// 	userService.deleteById(params_id);
	// }
	public static class requestInfo {
    public String email;
    public String password;
  }
}