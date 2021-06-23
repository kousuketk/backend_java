package com.example.api.serializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.api.entity.User;
import com.example.api.repository.UserRepository;
import com.example.api.serializer.model.UserInfo;

public class UserSerializer {
  public static List<UserInfo> serializeListUsers(List<User> users) {
    List<UserInfo> userInfoes = new ArrayList<UserInfo>();
    for(User user : users) {
      UserInfo userInfo = new UserInfo(user.getId(), user.getName(), user.getSelf_introduction());
      userInfoes.add(userInfo);
    }
    return userInfoes;
  }

  public static UserInfo serializeOptionalUser(Optional<User> user) {
    // if(user == null) return null;
    UserInfo userInfo = new UserInfo(user.get().getId(), user.get().getName(), user.get().getSelf_introduction());
    return userInfo;
  }

  public static UserInfo serializeUser(User user) {
    UserInfo userInfo = new UserInfo(user.getId(), user.getName(), user.getSelf_introduction());
    return userInfo;
  }
}