package de.hschaeufler.bookshop.bookservice.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/hello")
    String sayHello(){
        return "hello!";
    }

}
