# backend_java
docker-compose + Java + Spring Boot + mysql

### start
- deamonで立ち上げてbashに入る
```
$ docker-compose up -d
$ docker exec -it spring_app bash
```
- bashからbuild, 起動
```
bash-4.4# sh gradlew build
bash-4.4# java -jar build/libs/api-0.0.1-SNAPSHOT.jar
```

### test
```
$ curl http://localhost:8080/test
get /test.

$ curl http://localhost:8080/test/json -X POST -H 'Content-Type: application/json' -d '{"value1":"foo","value2":"bar"}' | jq .
{
  "value1": "foo_ok1",
  "value2": "bar_ok2"
}
```

### all responses
```
$ curl http://localhost:8080/users/ | jq .
$ curl http://localhost:8080/users/{user_id} | jq . 
$ curl -X POST -H 'Content-Type:application/json' -d '{"name":"test_name", "email":"email@test.com"}' localhost:8080/users | jq .
$ curl -X PUT -H 'Content-Type:application/json' -d '{"id":1, "test_name":"名前", "email":"email@test.com"}' localhost:8080/users/1 | jq . 
$ curl -X DELETE -H 'Content-Type:application/json'  localhost:8080/users/{user_id} | jq .
```

### look mysql
```
$ docker exec -it mysql_java bash
root@:/# mysql -u root -p
```
