# backend_java
docker-compose + Java + Spring Boot + mysql

### start
- deamonで立ち上げてbashに入る
```
$ docker-compose up -d
$ docker-compose exec app bash
```
- bashからbuild, 起動
```
bash-4.4# sh gradlew build
bash-4.4# java -jar build/libs/api-0.0.1-SNAPSHOT.jar
```

### test
```
$ curl http://localhost:8080/test
ok from test.

$ curl http://localhost:8080/test/json | jq .
{
  "value1": "foo",
  "value2": "bar"
}

$ curl http://localhost:8080/test/json -X POST -H 'Content-Type: application/json' -d '{"value1":"foo","value2":"bar"}' | jq .
{
  "value1": "foo_ok1",
  "value2": "bar_ok2"
}


$ curl http://localhost:8080/users | jq .  
% Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   237    0   237    0     0    341      0 --:--:-- --:--:-- --:--:--   341
[
  {
    "id": 1,
    "name": "test_user1",
    "email": "test_user1@test.com"
  },
  {
    "id": 2,
    "name": "test_user2",
    "email": "test_user2@test.com"
  },
  {
    "id": 3,
    "name": "test_user3",
    "email": "test_user3@test.com"
  },
  {
    "id": 4,
    "name": "test_user4",
    "email": "test_user4@test.com"
  }
]

$ curl http://localhost:8080/user/post -X POST -H 'Content-Type: application/json' -d '{"id":5,"name":"user5","email":"test@email.com"}' | jq .
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100    96    0    48  100    48    222    222 --:--:-- --:--:-- --:--:--   444
{
  "id": 5,
  "name": "user5",
  "email": "test@email.com"
}

```

### mysql connect
```
docker exec -it backend_java_mysql_1 bash
```
