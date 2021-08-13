package com.masimo.jasperreports;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.File;

@SpringBootApplication
public class JasperReportsApplication {
    @Value("${pdfReport.dir}")
    private String pdfDir;

    public static void main(String[] args) {
        SpringApplication.run(JasperReportsApplication.class, args);

        /*SpringApplicationBuilder builder = new SpringApplicationBuilder(JasperReportsApplication.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);*/
    }

    @PostConstruct
    public void init() {
        System.out.println("Hello, this is pdf generator project");
        File directory = new File(pdfDir);
        if (! directory.exists()){
            directory.mkdirs();
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }
    }

}
