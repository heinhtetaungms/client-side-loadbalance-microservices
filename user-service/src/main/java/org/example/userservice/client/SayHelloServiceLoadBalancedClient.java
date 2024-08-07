package org.example.userservice.client;

import org.example.userservice.config.SayHelloServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@LoadBalancerClient(value = "sayhello-service", configuration = SayHelloServiceConfiguration.class)
public class SayHelloServiceLoadBalancedClient {
    @Autowired
    private RestTemplate restTemplate;

    public String greet(String name) {
        return restTemplate.getForObject("http://sayhello-service/hello?name=" + name, String.class);
    }
}
