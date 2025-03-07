package com.joaoahaupt.picpay;

import com.joaoahaupt.picpay.config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PicpayDesafioApplication {

    public static void main(String[] args) {
        SpringApplication.run(PicpayDesafioApplication.class, args);
    }

}
