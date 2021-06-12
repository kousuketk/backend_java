# backend_java

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
```
