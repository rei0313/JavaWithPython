package com.rei.javawithpython;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class JavaWithPythonApplication {

    public static void main(String[] args) {
        
        SpringApplication.run(JavaWithPythonApplication.class, args);
        log.info("SERVER IS READY!!");
    }

}
