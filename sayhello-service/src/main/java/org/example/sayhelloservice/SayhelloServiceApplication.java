package org.example.sayhelloservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SayhelloServiceApplication {

    //add this VM Option in Run Configuration and run two instances running on port 8091 and 8092
    // -Dserver.port=8091 -Dserver.instance.id=1
    // -Dserver.port=8092 -Dserver.instance.id=2
    public static void main(String[] args) {
        SpringApplication.run(SayhelloServiceApplication.class, args);
    }

}
