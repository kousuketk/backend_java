package com.example.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.api.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Optional;
import java.util.List;

import com.example.api.entity.User;
import com.example.api.repository.UserRepository;
import com.example.api.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/api")
public class MeController {
  @Autowired
  UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;

  private final SessionInfo sessionInfo;

  public MeController(SessionInfo sessionInfo) {
    // this.instanceName = instanceName;
    this.sessionInfo = sessionInfo;
  }

  @RequestMapping(path = "/login", method = RequestMethod.POST)
  public String login(@RequestBody requestInfo obj) {
    if (sessionInfo.getUserId() == null) {
      List<User> user = userService.findByEmail(obj.email);
      if(user.isEmpty()) return "login failed. user not found.";
      String digest = user.get(0).getPassword_digest();
      if(!passwordEncoder.matches(obj.password, digest)) return "login failed. password is not correct.";
      sessionInfo.setUserId(user.get(0).getId());
      sessionInfo.setCreatedAt();
      sessionInfo.setCreatedBy();
    }
    return "userId: " + sessionInfo.getUserId().toString() + ". createdAt: " + sessionInfo.getCreatedAt() + " CreatedBy " + sessionInfo.getCreatedBy();
  }

  @RequestMapping(path = "/logout", method = RequestMethod.GET)
  public String goodbye(HttpSession session) {
    Optional<Integer> userId = Optional.ofNullable(sessionInfo.getUserId());
    if(userId.isPresent()) {
      session.invalidate();
      return "logout, userid: " + userId.orElse(9999999);
    } else return "already logout";
  }

  @RequestMapping(path = "/me", method = RequestMethod.GET)
	public Optional<User> getMe(HttpSession session) {
    Integer userId = sessionInfo.getUserId();
    Optional<User> result = userService.findById(userId);
    return result;
	}

	@RequestMapping(path = "/me/edit", method = RequestMethod.PUT)
	public User updateMe(HttpSession session, @RequestBody User params_user) {
    Integer userId = sessionInfo.getUserId();
	  User result = userService.updateUser(userId, params_user);
	  return result;  
	}

	@RequestMapping(path = "/me/delete", method = RequestMethod.DELETE)
	public String deleteById(HttpSession session) {
    Integer userId = sessionInfo.getUserId();
		userService.deleteById(userId);
    session.invalidate();
    return "deleted";
	}

  public static class requestInfo {
    public String email;
    public String password;
  }
}