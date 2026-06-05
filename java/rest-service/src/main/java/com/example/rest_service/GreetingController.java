package com.example.rest_service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
public class GreetingController {
    @GetMapping("/greet")
    public String greet(@RequestParam(defaultValue = "World") String name) {
        return "hello" + name;
    }

    @PostMapping("/hello")
    public String post(@RequestBody String name) {
        return "hello " + name;
    }
}
