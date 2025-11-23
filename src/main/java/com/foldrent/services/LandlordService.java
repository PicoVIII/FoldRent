package com.foldrent.services;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import com.foldrent.models.Landlords;
import com.foldrent.models.Tenants;
import com.foldrent.database.JsonDatabase;

public class LandlordService {
    private List<Landlords> landlords; // store landlords in memory
    private JsonDatabase database; // handles file operations
    private int nextLandlordId;

    public LandlordService() {
        this.database = new JsonDatabase();
        this.landlords = database.loadLandlords();

        if (landlords.isEmpty()) {
            this.nextLandlordId = 1;
        } else {
            int maxId = 0;
            for (int i = 0; i < landlords.size(); i++) {
                Landlords landlord = landlords.get(i);
                if (landlord.getLandlordID() > maxId) {
                    maxId = landlord.getLandlordID();
                }
            }
            this.nextLandlordId = maxId + 1;
        }
    }

    public int addLandlord(String firstName, String lastName, char midInitial, String email, String phone) {
        Landlords newLandlord = new Landlords(nextLandlordId, firstName, lastName, midInitial, email, phone);
        landlords.add(newLandlord);
        int createdId = nextLandlordId;
        nextLandlordId++;
        saveData();
        return createdId;
    }

    private boolean saveData() {
        try {
            database.saveLandlords(landlords); // Only saves Landlords
            return true;
        } catch (Exception e) {
            System.out.println("Error saving tenants: " + e.getMessage());
            return false;
        }
    }
}
