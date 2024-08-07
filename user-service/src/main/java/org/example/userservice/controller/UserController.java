package org.example.userservice.controller;

import org.example.userservice.client.SayHelloServiceLoadBalancedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private SayHelloServiceLoadBalancedClient sayHelloServiceLoadBalancedClient;

    @GetMapping("/user")
    public String user(@RequestParam String name) {
        return sayHelloServiceLoadBalancedClient.greet(name);
    }

}
