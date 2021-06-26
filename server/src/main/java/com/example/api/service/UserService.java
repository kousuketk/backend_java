package com.example.api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api.entity.User;
import com.example.api.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  public List<User> findUsers() {
    List<User> users = userRepository.findAll();
    return users;
  }

  public Optional<User> findById(Integer params_id) {
    Optional<User> user = userRepository.findById(params_id);
    return user;
  }

  public List<User> findByEmail(String email) {
    List<User> user = userRepository.findByEmail(email);
    return user;
  }

  public User createUser(User params_user) {
    params_user.setPassword_digest(passwordEncoder.encode(params_user.getPassword_digest()));
    User user = userRepository.save(params_user);
    return user;
  }

  public User updateUser(User params_user) {
    params_user.setPassword_digest(passwordEncoder.encode(params_user.getPassword_digest()));
    User user = userRepository.save(params_user);
    return user;
  }

  public void deleteById(Integer params_id) {
    userRepository.deleteById(params_id);
  }
}