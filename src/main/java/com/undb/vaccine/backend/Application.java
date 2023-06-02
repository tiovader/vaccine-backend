package com.undb.vaccine.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        Locale.setDefault(new Locale("pt", "BR"));
        SpringApplication.run(Application.class, args);
    }

}
