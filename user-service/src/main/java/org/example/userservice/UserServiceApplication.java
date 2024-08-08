package org.example.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {
    //curl "http://localhost:8080/userSayHello?name=Hein"
    //curl "http://localhost:8080/userSayHey?name=Hein"
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
