package edu.chdtu;

import edu.chdtu.controller.DownloadController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.util.Random;

@SpringBootApplication
@EnableAutoConfiguration
public class LibraryApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LibraryApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }
}
