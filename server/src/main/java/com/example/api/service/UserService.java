package com.example.api.service;

import java.util.List;
import com.example.api.entity.User;
import com.example.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Service
// public class UserService {
//   @Autowired
//   UserRepository userRepository;
// }

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public List<User> findUsers() {
    return userRepository.findAll();
  }

  public User findUserByName(String name) {
    return userRepository.findByName(name);
  }

  public User save(User user) {
    return userRepository.save(user);
  }
}