package org.example.sayhelloservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {
    @Value("${server.instance.id}")
    String instanceId;

    @GetMapping("/hello")
    public String sayHello(@RequestParam String name) {
        return String.format("Hello %s from instance %s", name, instanceId);
    }
}
