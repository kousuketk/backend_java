# backend_java
docker-compose + Java + Spring Boot

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
```

### mysql connect
```
mysql -u root -p -h localhost -P 3307 --protocol=tcp
docker exec -it backend_java_mysql_1 bash
```

### others
- docker内でvim
```
apt-get update
apt-get install vim
```