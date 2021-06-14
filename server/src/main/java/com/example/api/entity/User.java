package com.example.api.entity;

import lombok.Data;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// @Data
// @Entity
// @Table(name="users")
// public class User {
//     @Id
//     @GeneratedValue
//     private Integer id;
//     private String name;
//     private String email;

//     public User(Integer id, String name, String email) {
//       this.id = id;
//       this.name = name;
//       this.email = email;
//     }

//     public Integer getId() {
//       return id;
//     }
//     public String getName() {
//       return name;
//     }
//     public String getEmail() {
//       return email;
//     }
// }

@Entity
@Data
@Table(name="users")
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column (name="id")
  private Integer id;

  @Column (name="name")
  private String name;

  @Column (name="email")
  private String email;

  public User(Integer id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

}