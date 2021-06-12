package com.example.api.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.weg.bind.annotation*;でもいい

@RestController
public class TestController {
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test() {
      return "ok from test.";
    }

    @RequestMapping(path = "/test/json", method = RequestMethod.GET)
    public Example testJson() {
      var obj = new Example();
      obj.value1 = "foo";
      obj.value2 = "bar";
      return obj;
    }

    @RequestMapping(path = "/test/json", method = RequestMethod.POST)
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