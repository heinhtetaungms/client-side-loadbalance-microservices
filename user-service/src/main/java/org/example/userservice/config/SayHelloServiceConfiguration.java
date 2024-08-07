package org.example.userservice.config;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.core.WeightFunction;
import org.springframework.cloud.loadbalancer.support.ServiceInstanceListSuppliers;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SayHelloServiceConfiguration {

    @Bean
    public ServiceInstanceListSupplier serviceInstanceListSupplier(ConfigurableApplicationContext context) {

        WeightFunction weightFunction = instance -> {
            if (instance.getPort() == 8091) {
                return 4;
            } else if (instance.getPort() == 8092) {
                return 1;
            }
            return 0;
        };

        ServiceInstanceListSupplier serviceInstanceListSupplier = ServiceInstanceListSuppliers
                .from("sayhello-service",
                        new DefaultServiceInstance("sayhello-instance1", "sayhello-service", "localhost", 8091, false),
                        new DefaultServiceInstance("sayhello-instance2", "sayhello-service", "localhost", 8092, false)
                        );
        return ServiceInstanceListSupplier.builder()
                .withBase(serviceInstanceListSupplier)
                .withWeighted(weightFunction)
                .build(context);
    }
}
