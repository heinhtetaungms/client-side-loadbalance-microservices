package org.example.sayheyservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHeyController {
    @Value("${server.instance.id}")
    String instanceId;

    @GetMapping("/hey")
    public String sayHey(@RequestParam String name) {
        return String.format("Hey %s from instance %s", name, instanceId);
    }
}
