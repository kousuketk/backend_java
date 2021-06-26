package com.example.api.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;

@Entity
@Data
@Table(name="users")
public class User implements Serializable {

  @Id
  @GeneratedValue
  @Column(name="id")
  private Integer id;

  private String name;
  private String self_introduction;
  private String email;
  private String password_digest;
  private String address;
  private String phone_number;
  private Date created_at;
  private Date updated_at;
  private Date deleted_at;

  public User(
    String name,
    String self_introduction,
    String email,
    String password,
    String address,
    String phone_number
  ) {
    this.name = name;
    this.self_introduction = self_introduction;
    this.email = email;
    this.password_digest = DigestUtils.sha256Hex(password);
    this.address = address;
    this.phone_number = phone_number;
    this.created_at = new Date();
    this.updated_at = new Date();
  }

  public User(
    String name,
    String self_introduction
  ) {
    this.name = name;
    this.self_introduction = self_introduction;
  }

  public User() {
  
  }

  public void setPassword_digest(String password) {
    this.password_digest = DigestUtils.sha256Hex(password);
  }

  public void setCreated_at() {
    this.created_at = new Date();
  }

  public void setUpdated_at() {
    this.updated_at = new Date();
  }
}