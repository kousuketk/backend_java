package com.example.api;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.Date;

@SessionScope
@Component
public class SessionInfo implements Serializable {

  private static final long serialVersionUID = 8048097948251750715L;
  private Integer userId;
  private Date createdAt;
  private String createdBy;

  public Integer getUserId() {
    return this.userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt() {
    this.createdAt = new Date();
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy() {
    this.createdBy = "created_by_setter";
  }

}