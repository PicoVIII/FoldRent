package com.foldrent.database;

import tools.jackson.core.exc.StreamWriteException;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.cfg.DateTimeFeature;
import tools.jackson.databind.json.JsonMapper;

import com.foldrent.models.Tenants;
import com.foldrent.models.User;
import com.foldrent.models.Landlords;
import com.foldrent.models.Payment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonDatabase {
    private final ObjectMapper objectMapper;
    private final String DATA_DIR = "data";
    private final String TENANTS_FILE = DATA_DIR + "/tenants.json";
    private final String LANDLORDS_FILE = DATA_DIR + "/landlords.json";
    private final String PAYMENTS_FILE = DATA_DIR + "/payments.json";
    private final String USERS_FILE = DATA_DIR + "/users.json";

    public JsonDatabase() {
        this.objectMapper = JsonMapper.builder()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .disable(DateTimeFeature.WRITE_DATES_AS_TIMESTAMPS)
                .build();

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
        } catch (StreamWriteException | DatabindException e) {
            System.out.println("Error saving tenants: " + e.getMessage());
        }
    }

    // Load tenants from JSON file
    public List<Tenants> loadTenants() {
        try {
            File file = new File(TENANTS_FILE);
            if (file.exists()) {
                return objectMapper.readValue(file,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Tenants.class));
            }
        } catch (StreamWriteException | DatabindException e) {
            System.out.println("Error loading tenants: " + e.getMessage());
        }
        return new ArrayList<>(); // Return empty list if file doesn't exist or error
    }

    public void saveLandlords(List<Landlords> landlords) {
        try {
            objectMapper.writeValue(new File(LANDLORDS_FILE), landlords);
            System.out.println("Tenants saved successfully to " + LANDLORDS_FILE);
        } catch (StreamWriteException | DatabindException e) {
            System.out.println("Error saving Landlords: " + e.getMessage());
        }
    }

    // Load tenants from JSON file
    public List<Landlords> loadLandlords() {
        try {
            File file = new File(LANDLORDS_FILE);
            if (file.exists()) {
                return objectMapper.readValue(file,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Landlords.class));
            }
        } catch (StreamWriteException | DatabindException e) {
            System.out.println("Error loading landlords: " + e.getMessage());
        }
        return new ArrayList<>(); // Return empty list if file doesn't exist or error
    }

    // Save payments to JSON file
    public void savePayments(List<Payment> payments) {
        try {
            objectMapper.writeValue(new File(PAYMENTS_FILE), payments);
            System.out.println("Payments saved successfully to " + PAYMENTS_FILE);
        } catch (StreamWriteException | DatabindException e) {
            System.out.println("Error saving payments: " + e.getMessage());
        }
    }

    // Load payments from JSON file
    public List<Payment> loadPayments() {
        try {
            File file = new File(PAYMENTS_FILE);
            if (file.exists()) {
                return objectMapper.readValue(file,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Payment.class));
            }
        } catch (StreamWriteException | DatabindException e) {
            System.out.println("Error loading payments: " + e.getMessage());
        }
        return new ArrayList<>(); // Return empty list if file doesn't exist or error
    }

    public List<User> loadUsers() {
        try {
            File file = new File(USERS_FILE);
            if (file.exists()) {
                return objectMapper.readValue(file,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));
            }
        } catch (StreamWriteException | DatabindException e) {
            System.out.println("Error loading Users: " + e.getMessage());
        }
        return new ArrayList<>(); // Return empty list if file doesn't exist or error
    }

    public void saveUsers(List<User> users) {
        try {
            objectMapper.writeValue(new File(USERS_FILE), users);
            System.out.println("User saved successfully to " + USERS_FILE);
        } catch (Exception e) {
            System.out.println("Error saving user: " + e.getMessage());
        }
    }
}