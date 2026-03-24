package com.ca.service;

import org.springframework.stereotype.Service;
import com.ca.model.Record;
import java.nio.file.*;
import java.io.*;
import java.util.List;
import org.apache.commons.csv.*;

@Service
public class CsvService {

    public Path write(List<Record> records) {
        try {
            Path path = Paths.get("/tmp/output.csv");

            BufferedWriter writer = Files.newBufferedWriter(path);
            CSVPrinter csvPrinter = new CSVPrinter(writer,
                    CSVFormat.DEFAULT.withHeader("id", "origin", "destination", "status"));

            for (Record r : records) {
                csvPrinter.printRecord(r.getId(), r.getOrigin(), r.getDestination(), r.getStatus());
            }

            csvPrinter.close();
            return path;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
