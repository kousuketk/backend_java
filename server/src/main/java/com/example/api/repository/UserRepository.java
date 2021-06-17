package com.example.api.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  // public List<User> findAll();
  // public List<User> findAllById(Integer id);
  // public User getOne(Integer id);
  // User findById(Integer id);
  User findByName(String name);
  // public User save(User obj);
  // public void deleteById(Integer id);
}