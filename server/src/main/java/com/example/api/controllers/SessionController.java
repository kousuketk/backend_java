package com.example.api.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.api.SessionInfo;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/session")
public class SessionController {
  // private final String instanceName;
  private final SessionInfo sessionInfo;

  public SessionController(SessionInfo sessionInfo) {
    // this.instanceName = instanceName;
    this.sessionInfo = sessionInfo;
  }

  @GetMapping("/hello")
  public String hello(@RequestParam Optional<Integer> userId) {
    if (sessionInfo.getUserId() == null) {
      sessionInfo.setUserId(userId.orElse(9999999));
      sessionInfo.setCreatedAt();
      sessionInfo.setCreatedBy();
    }
    return "userId: " + sessionInfo.getUserId().toString() + ". createdAt: " + sessionInfo.getCreatedAt() + " CreatedBy " + sessionInfo.getCreatedBy();
  }

  @GetMapping("/goodbye")
  public String goodbye(HttpSession session) {
    Optional<Integer> userId = Optional.ofNullable(sessionInfo.getUserId());
    session.invalidate();
    return "Goodbye " + userId.orElse(9999999);
  }

}