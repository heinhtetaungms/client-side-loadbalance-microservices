package org.example.userservice.client;

import org.example.userservice.config.SayHelloServiceConfiguration;
import org.example.userservice.config.SayHeyServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@LoadBalancerClients({
        @LoadBalancerClient(name = "sayhey-service", configuration = SayHeyServiceConfiguration.class),
        @LoadBalancerClient(name = "sayhello-service", configuration = SayHelloServiceConfiguration.class)
})
public class LoadBalancedClient {
    @Autowired
    private RestTemplate restTemplate;

    public String greetHey(String name) {
        return restTemplate.getForObject("http://sayhey-service/hey?name=" + name, String.class);
    }

    public String greetHello(String name) {
        return restTemplate.getForObject("http://sayhello-service/hello?name=" + name, String.class);
    }
}
