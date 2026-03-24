package com.ca.job;

import org.springframework.stereotype.Service;
import com.ca.service.DataSourceService;
import com.ca.service.CsvService;
import com.ca.service.S3Service;

@Service
public class ExportJob {

    private final DataSourceService dataSourceService;
    private final CsvService csvService;
    private final S3Service s3Service;

    public ExportJob(DataSourceService dataSourceService,
                     CsvService csvService,
                     S3Service s3Service) {
        this.dataSourceService = dataSourceService;
        this.csvService = csvService;
        this.s3Service = s3Service;
    }

    public void run() {
        System.out.println("Starting CA pipeline...");

        var records = dataSourceService.fetchData();
        var filePath = csvService.write(records);
        s3Service.upload(filePath);

        System.out.println("Pipeline complete");
    }
}
