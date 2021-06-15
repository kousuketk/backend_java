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

### spring connect mysql problems
```
1. 普通に立ち上げると→指定のmysqlを見ていない
➜  backend_java git:(main) ✗ curl http://localhost:8080/user/post -X POST -H 'Content-Type: application/json' -d '{"id":7,"name":"test_user1","email":"eeee@email.com"}' | jq .
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   106    0    53  100    53    103    103 --:--:-- --:--:-- --:--:--   206
{
  "id": 1,
  "name": "test_user1",
  "email": "eeee@email.com"
}
➜  backend_java git:(main) ✗ curl http://localhost:8080/users | jq .
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100    55    0    55    0     0    268      0 --:--:-- --:--:-- --:--:--   266
[
  {
    "id": 1,
    "name": "test_user1",
    "email": "eeee@email.com"
  }
]
```

2. application.propertiesの場所を変更する(configフォルダを作る)→同じ
3. 実行時に指定するとエラー
```
java -jar build/libs/api-0.0.1-SNAPSHOT.jar --spring.datasource.driver-class-name=com.mysql.jdbc.Driver --spring.datasource.url=jdbc:mysql://localhost:3306/sample_db2?serverTimezone=JST --spring.profiles=localhost --spring.datasource.username=root --spring.datasource.password=rootpass --spring.jpa.database=MYSQL
```
→以下のようにHikaripoolのエラーが出る(mysqlとうまくコネクションできていない)
```
2021-06-15 02:07:39.653 ERROR 1073 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Exception during pool initialization.

com.mysql.cj.jdbc.exceptions.CommunicationsException: Communications link failure
```
→/usersや/user/postにアクセスするとinternail server errorが帰ってくる
→　どのようにapplication.propertiesを指定すれば、mysqlとコネクション(データのやり取り)できるのか？
