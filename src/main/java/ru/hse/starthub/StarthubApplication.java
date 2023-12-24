package ru.hse.starthub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackages = {"ru.hse.starthub.*"})
@EntityScan("ru.hse.starthub.model")
public class StarthubApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarthubApplication.class, args);
    }

}
