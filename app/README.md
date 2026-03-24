# CA Pipeline

Simple Java-based Commercial Analytics export pipeline.

## What it does
- Fetch mock data (simulating OpenSearch)
- Convert to CSV
- Upload to S3

## Run locally
mvn clean package
java -jar target/*.jar
