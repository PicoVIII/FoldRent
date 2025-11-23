package com.foldrent.services;

import java.util.List;
import java.util.ArrayList;

import com.foldrent.models.User;
import com.foldrent.database.JsonDatabase;
import com.foldrent.services.TenantService;
import com.foldrent.models.Tenants;

public class AuthService {
    private List<User> users;
    private JsonDatabase database;
    private User currentUser;
    private int nextUserId;

    public AuthService() {
        this.database = new JsonDatabase();
        this.users = database.loadUsers();

        if (users.isEmpty()) {
            this.nextUserId = 1;
        } else {
            // to find highest userId and set the nextUserId
            int maxId = 0;
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                if (user.getUserId() > maxId) {
                    maxId = user.getUserId();
                }
            }
            this.nextUserId = maxId + 1;
        }
    }

    public boolean registerUser(String username, String password, String role, int tenantId, int landlordId) {
        // validate role
        if (!role.equals("LANDLORD") && !role.equals("TENANT")) {
            return false; // Invalid role
        }

        // check if username already exists
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getUsername().equals(username)) {
                return false; // username taken
            }
        }

        User newUser = new User(nextUserId, username, password, role, tenantId, landlordId, true);
        users.add(newUser);
        nextUserId++;
        return saveData();
    }

    public Integer getCurrentUserLandlordId() {
        if (currentUser != null) {
            return currentUser.getLandlordId();
        }
        return null;
    }

    public Integer getCurrentUserTenantId() {
        if (currentUser != null) {
            return currentUser.getTenantId();
        }
        return null;
    }

    public User findUserByLandlordId(int landlordId) {
        for (User user : users) {
            if (user.getLandlordId() == landlordId) {
                return user;
            }
        }
        return null;
    }

    public User findUserByTenantId(int tenantId) {
        for (User user : users) {
            if (user.getTenantId() == tenantId) {
                return user;
            }
        }
        return null;
    }

    public boolean loginUser(String username, String password) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getUsername().equals(username) && user.getPassword().equals(password) && user.isActive()) { // check
                                                                                                                 // credentials
                currentUser = user;
                return true; // login successful
            }
        }
        return false; // login failed
    }

    public void logout() {
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public String getCurrentUserRole() {
        if (currentUser != null) {
            return currentUser.getRole();
        } else {
            return null;
        }
    }

    public boolean saveData() {
        try {
            database.saveUsers(users);
            return true;
        } catch (Exception e) {
            System.out.println("Error saving user data: " + e.getMessage());
            return false;
        }
    }

}
