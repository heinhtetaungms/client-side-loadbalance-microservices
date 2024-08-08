package org.example.sayheyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SayheyServiceApplication {

    //add this VM Option in Run Configuration and run two instances running on port 8071 and 8072
    // -Dserver.port=8071 -Dserver.instance.id=1
    // -Dserver.port=8072 -Dserver.instance.id=2
    public static void main(String[] args) {
        SpringApplication.run(SayheyServiceApplication.class, args);
    }

}
