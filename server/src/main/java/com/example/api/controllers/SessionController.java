package com.example.api.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.redis.core.StringRedisTemplate;

// import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Optional;
import com.example.api.SessionInfo;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;


@RestController
@RequestMapping("/api/session")
public class SessionController {
  @Autowired
  private StringRedisTemplate stringRedisTemplate;
  // @Autowired
  // UserService userService;
  @RequestMapping(value="/get", method=RequestMethod.GET)
	public String get(@RequestParam(value="key", required=true) String key) {

		// キーを指定してredisから値を取得
		String result = stringRedisTemplate.opsForValue().get(key);

		return "redisstr/get_end";
	}

	@RequestMapping(value="/set", method=RequestMethod.GET)
	public String set(HttpServletResponse response, @RequestParam(value="key", required=true) String key,
			@RequestParam(value="value", required=true) String value) {

		// キーと値を指定してredisにセット
		stringRedisTemplate.opsForValue().set(key, value);
    Cookie cookie = new Cookie(key, value);
    response.addCookie(cookie);
		return "redisstr/set_end";
	}

	@RequestMapping(value="/del", method=RequestMethod.GET)
	public String del(@RequestParam(value="key", required=true) String key) {

		// キーを指定してredisから削除
		stringRedisTemplate.delete(key);

		return "redisstr/del_end";
	}


  // // curl -X POST -d '{"email": "email@test.com", "password":"password"}'  http://localhost:8080/api/session
  // @RequestMapping(method = RequestMethod.POST)
  // public String hello(@RequestBody requestInfo) {
  //   // emailとpassword(requestInfo)をrequestbodyからもらって、userdbと検証
  //   // User.findbyEmail(requestInfo.email) and passwordをhashにして確認
  //   // 成功したら、session_id(ランダムでいいや)を発行してそれをcookie, redisのキーとする
  //   // redis側には、userid, createdAtを入れる。
  //   // sessionInfo.setId(user_id), sessionInfo.createdAt(new Date());
  //   // if (sessionInfo.getName() == null) {
  //   //   sessionInfo.setName(name.orElse("anonymous"));
  //   //   sessionInfo.setCreatedAt(new Date());
  //   //   sessionInfo.setCreatedBy(instanceName);
  //   // }
  //   // return "Hi " + sessionInfo.getName() + ". Enter at " + sessionInfo.getCreatedAt() + " by " + sessionInfo.getCreatedBy() + " (Echo by " + instanceName + ")";
  // }

  // @GetMapping("/goodbye")
  // public String goodbye(HttpSession session) {
  //   Optional<String> name = Optional.ofNullable(sessionInfo.getName());
  //   session.invalidate();
  //   return "Goodbye " + name.orElse("anonymous") + " (Echo by " + instanceName + ")";
  // }

  // public static class requestInfo {
  //   public String email;
  //   public String password;
  // }

}