package com.mastercloudapps.airport;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("Starting example data...");
    }
    
}
