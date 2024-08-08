package org.example.userservice.config;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.ServiceInstanceListSuppliers;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SayHeyServiceConfiguration {

    @Bean
    public ServiceInstanceListSupplier sayHeyServiceInstanceListSupplier(ConfigurableApplicationContext context) {
        ServiceInstanceListSupplier sayHeyServiceInstanceListSupplier = ServiceInstanceListSuppliers
                .from("sayhey-service",
                        new DefaultServiceInstance("sayhey-instance1", "sayhey-service", "localhost", 8071, false),
                        new DefaultServiceInstance("sayhey-instance2", "sayhey-service", "localhost", 8072, false)
                        );
        return ServiceInstanceListSupplier.builder()
                .withBase(sayHeyServiceInstanceListSupplier)
                .build(context);
    }
}
