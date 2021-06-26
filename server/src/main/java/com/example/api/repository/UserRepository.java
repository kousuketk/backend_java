package com.example.api.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  List<User> findAll();
  Optional<User> findById(Integer id);
  // Optional<User> findByName(String name);
  List<User> findByEmail(String email);
  User save(User user);
  void deleteById(Integer id);
}