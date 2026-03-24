package com.ca.model;

public class Record {
    private String id;
    private String origin;
    private String destination;
    private String status;

    public Record(String id, String origin, String destination, String status) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.status = status;
    }

    public String getId() { return id; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public String getStatus() { return status; }
}
