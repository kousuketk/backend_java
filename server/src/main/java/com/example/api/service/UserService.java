package com.example.api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api.entity.User;
import com.example.api.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public List<User> findUsers() {
    List<User> result = userRepository.findAll();
    return result;
  }

  public Optional<User> findOneUser(Integer id) {
    // User result  = userRepository.getOne(id);
    Optional<User> result = userRepository.findById(id);
    return result;
  }

  public User findUserByName(String name) {
    User result = userRepository.findByName(name);
    return result;
  }

  public User createUser(User obj) {
    User result = userRepository.save(obj);
    return result;
  }

  public boolean deleteById(Integer id) {
    userRepository.deleteById(id);
    return true;
  }
}