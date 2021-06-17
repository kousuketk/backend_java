package com.example.api.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// getter, setterを書いたら、@Dataは必要ないかも
@Entity
@Data
@Table(name="users")
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private Integer id;

  private String name;

  private String email;

  // public User () {
  //   super();
  // }

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public User() {

  }

}