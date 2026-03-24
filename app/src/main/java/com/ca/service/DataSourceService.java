package com.ca.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.ca.model.Record;

@Service
public class DataSourceService {

    public List<Record> fetchData() {
        return List.of(
            new Record("1", "LHR", "DXB", "CONFIRMED"),
            new Record("2", "MAN", "JFK", "CANCELLED")
        );
    }
}
