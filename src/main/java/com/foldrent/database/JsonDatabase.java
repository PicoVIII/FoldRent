package com.foldrent.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.foldrent.models.Tenants;
import com.foldrent.models.Payment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonDatabase {
    private final ObjectMapper objectMapper;
    private final String DATA_DIR = "data";
    private final String TENANTS_FILE = DATA_DIR + "/tenants.json";
    private final String PAYMENTS_FILE = DATA_DIR + "/payments.json";

    public JsonDatabase() {
        this.objectMapper = new ObjectMapper();
        // Configure ObjectMapper to work with Java 8 dates and pretty print
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        
        ensureDataDirectoryExists();
    }

    private void ensureDataDirectoryExists() {
        File dataDir = new File(DATA_DIR);
        if (!dataDir.exists()) {
            dataDir.mkdirs(); // Create the directory if it doesn't exist
        }
    }

    // Save tenants to JSON file
    public void saveTenants(List<Tenants> tenants) {
        try {
            objectMapper.writeValue(new File(TENANTS_FILE), tenants);
            System.out.println("Tenants saved successfully to " + TENANTS_FILE);
        } catch (IOException e) {
            System.out.println("Error saving tenants: " + e.getMessage());
        }
    }

    // Load tenants from JSON file
    public List<Tenants> loadTenants() {
        try {
            File file = new File(TENANTS_FILE);
            if (file.exists()) {
                return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Tenants.class));
            }
        } catch (IOException e) {
            System.out.println("Error loading tenants: " + e.getMessage());
        }
        return new ArrayList<>(); // Return empty list if file doesn't exist or error
    }

    // Save payments to JSON file
    public void savePayments(List<Payment> payments) {
        try {
            objectMapper.writeValue(new File(PAYMENTS_FILE), payments);
            System.out.println("Payments saved successfully to " + PAYMENTS_FILE);
        } catch (IOException e) {
            System.out.println("Error saving payments: " + e.getMessage());
        }
    }

    // Load payments from JSON file
    public List<Payment> loadPayments() {
        try {
            File file = new File(PAYMENTS_FILE);
            if (file.exists()) {
                return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Payment.class));
            }
        } catch (IOException e) {
            System.out.println("Error loading payments: " + e.getMessage());
        }
        return new ArrayList<>(); // Return empty list if file doesn't exist or error
    }
}