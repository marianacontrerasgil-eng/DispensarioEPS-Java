package com.dispensario.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.dispensario") // Rastreará tus nuevos componentes controladores
public class Main {
    public static void main(String[] args) {
        // Inicializador oficial del ciclo de vida de Spring Boot
        SpringApplication.run(Main.class, args);
    }
}
