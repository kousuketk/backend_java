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
$ curl http://localhost:8080/api/test
get /test.

$ curl http://localhost:8080/api/test/example -X POST -H 'Content-Type: application/json' -d '{"value1":"foo","value2":"bar"}' | jq .
{
  "value1": "foo_ok1",
  "value2": "bar_ok2"
}
```

- all responses
```
$ curl http://localhost:8080/api/users | jq .
$ curl http://localhost:8080/api/users/{user_id} | jq . 
$ curl -X POST -H 'Content-Type:application/json' -d '{"name":"test_name", "email":"email@test.com"}' localhost:8080/api/users | jq .
$ curl -X PUT -H 'Content-Type:application/json' -d '{"id":1, "name":"tupdated_name", "email":"updated_email@test.com"}' localhost:8080/api/users/1 | jq .
$ curl -X DELETE -H 'Content-Type:application/json'  localhost:8080/api/users/{user_id} | jq .
```

### mysql connect
```
docker exec -it backend_java_mysql_1 bash
```
