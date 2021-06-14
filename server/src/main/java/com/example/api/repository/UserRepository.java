package com.example.api.repository;

import com.example.api.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository
// public interface UserRepository extends CrudRepository<User, Integer> {
// }

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  User findByName(String name);
}