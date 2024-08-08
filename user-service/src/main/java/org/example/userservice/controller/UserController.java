package org.example.userservice.controller;

import org.example.userservice.client.LoadBalancedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private LoadBalancedClient loadBalancerClient;

    @GetMapping("/userSayHello")
    public String userSayHello(@RequestParam String name) {
        return loadBalancerClient.greetHello(name);
    }

    @GetMapping("/userSayHey")
    public String userSayHey(@RequestParam String name) {
        return loadBalancerClient.greetHey(name);
    }

}
