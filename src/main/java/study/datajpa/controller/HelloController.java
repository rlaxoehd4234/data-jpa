package study.datajpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    //git branch test
    //master branch merge test
    @GetMapping("/")
    public String hello(){
        return "hello";
    }
}
