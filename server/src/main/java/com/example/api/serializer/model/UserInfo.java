package com.example.api.serializer.model;

import java.io.Serializable;

public class UserInfo implements Serializable {
  public String name;
  public String self_introduction;

  public UserInfo (String name, String self_introduction) {
    this.name = name;
    this.self_introduction = self_introduction;
  }
}