package com.example.api.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.weg.bind.annotation*;でもいい

@RestController
@RequestMapping(path = "/test")
public class TestController {
    @RequestMapping(method = RequestMethod.GET)
    public String getTest() {
      return "get /test";
    }

    // curl -X POST http://localhost:8080/test  
    @RequestMapping(method = RequestMethod.POST)
    public String postTest() {
      return "post /test";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String putTest() {
      return "put /test";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteTest() {
      return "delete /test";
    }

    // curl http://localhost:8080/test/json -X POST -H 'Content-Type: application/json' -d '{"value1":"foo","value2":"bar"}' | jq .
    @RequestMapping(path = "/example", method = RequestMethod.POST)
    public Example testPost(@RequestBody Example obj) {
      obj.value1 = obj.value1 + "_ok1";
      obj.value2 = obj.value2 + "_ok2";
      return obj;
    }

    // public classだとRequestBodyで受け取れない(internal server error)から、static classで宣言(詳しくはstatic clas)
    public static class Example {
      public String value1;
      public String value2;
    }
}