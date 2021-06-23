package com.example.api.serializer.model;

import java.io.Serializable;

public class UserInfo implements Serializable {
  public Integer id;
  public String name;
  public String self_introduction;

  public UserInfo (Integer id, String name, String self_introduction) {
    this.id = id;
    this.name = name;
    this.self_introduction = self_introduction;
  }
}