package com.ca;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ca.job.ExportJob;

@SpringBootApplication
public class CaApplication implements CommandLineRunner {

    private final ExportJob exportJob;

    public CaApplication(ExportJob exportJob) {
        this.exportJob = exportJob;
    }

    public static void main(String[] args) {
        SpringApplication.run(CaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        exportJob.run();
        System.exit(0);
    }
}
