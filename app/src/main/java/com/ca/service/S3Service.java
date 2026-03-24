package com.ca.service;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.nio.file.Path;

@Service
public class S3Service {

    public void upload(Path filePath) {
        String bucket = System.getenv("S3_BUCKET");

        if (bucket == null || bucket.isBlank()) {
            System.out.println("No S3_BUCKET set, skipping upload");
            return;
        }

        String region = System.getenv("AWS_REGION");
        if (region == null || region.isBlank()) {
            System.out.println("No AWS_REGION set, skipping upload");
            return;
        }

        try (S3Client s3Client = S3Client.builder()
                .region(Region.of(region))
                .build()) {

            s3Client.putObject(
                    PutObjectRequest.builder()
                            .bucket(bucket)
                            .key("output.csv")
                            .build(),
                    filePath
            );

            System.out.println("Uploaded to S3: s3://" + bucket + "/output.csv");
        }
    }
}