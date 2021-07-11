# backend_java
docker-compose + nginx + Java + Spring Boot + mysql + redis

### overview
![image](https://user-images.githubusercontent.com/42241308/124126252-73b35380-dab5-11eb-979b-d4cf96a7ac1f.png)


### start
- deamonで立ち上げてbashに入る
```
$ docker-compose up -d
$ docker exec -it spring_api1 bash
```
- bashからbuild, 起動
```
bash-4.4# sh gradlew build
bash-4.4# java -jar build/libs/api-0.0.1-SNAPSHOT.jar --instance.name=api1
```

### health check
```
$ curl http://localhost:8080/api/test
get /test. by api1

$ curl http://localhost:8080/api/test/example -X POST -H 'Content-Type: application/json' -d '{"value1":"foo","value2":"bar"}' | jq .
{
  "value1": "foo_ok1",
  "value2": "bar_ok2"
}
```

### endpoints
```
$ curl http://localhost:8080/api/users | jq .
$ curl http://localhost:8080/api/users/{user_id} | jq . 
$ curl -X POST -H 'Content-Type:application/json' -d '{"name":"test_name", "self_introduction":"test_self_introduction", "email":"testuser@test.com", "password_digest":"test123", "address":"test_address", "phone_number":"00000000000"}' localhost:8080/api/users | jq .

// session
$ curl http://localhost:8080/api/login -X POST -H 'Content-Type:application/json' -d '{"email":"test", "password":"test"}'
$ curl http://localhost:8080/api/me
$ curl http://localhost:8080/api/me/edit -X PUT -H 'Content-Type:application/json' -d
$ curl http://localhost:8080/api/me/delete -X DELETE
$ curl http://localhost:8080/api/logout
```

### look mysql, redis
```
$ docker exec -it mysql_java bash
root@:/# mysql -u root -p

$ docker exec -it redis-server bash
root@:/# redis-cli
```
