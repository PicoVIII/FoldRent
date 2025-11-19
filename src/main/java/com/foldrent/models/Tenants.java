package com.foldrent.models;

import java.time.LocalDate;

public class Tenants {
    private int tenantID;
    private String tenantFirstName;
    private String tenantLastName;
    private char tenantMidInitial;
    private double rentAmount; // rent price per month
    private double rentBalance; // total balance = rentAmount x rent missed
    private int rentMissed; // months missed
    private LocalDate moveInDate;
    private LocalDate moveOutDate;
    private boolean isActive;

    public Tenants(int id, String firstName, String lastName, double rentAmount) {
        this.tenantID = id;
        this.tenantFirstName = firstName;
        this.tenantLastName = lastName;
        this.rentAmount = rentAmount;
        this.rentBalance = 0.0;
        this.rentMissed = 0;
        this.moveInDate = LocalDate.now();
        this.isActive = true;
    }

    public int getTenantID() {
        return tenantID;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    public String getTenantFirstName() {
        return tenantFirstName;
    }

    public void setTenantFirstName(String tenantFirstName) {
        this.tenantFirstName = tenantFirstName;
    }

    public String getTenantLastName() {
        return tenantLastName;
    }

    public void setTenantLastName(String tenantLastName) {
        this.tenantLastName = tenantLastName;
    }

    public char getTenantMidInitial() {
        return tenantMidInitial;
    }

    public void setTenantMidInitial(char tenantMidInitial) {
        this.tenantMidInitial = tenantMidInitial;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public double getRentBalance() {
        return rentBalance;
    }

    public void setRentBalance(double rentBalance) {
        this.rentBalance = rentBalance;
    }

    public int getRentMissed() {
        return rentMissed;
    }

    public void setRentMissed(int rentMissed) {
        this.rentMissed = rentMissed;
    }

    public LocalDate getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(LocalDate moveInDate) {
        this.moveInDate = moveInDate;
    }

    public LocalDate getMoveOutDate() {
        return moveOutDate;
    }

    public void setMoveOutDate(LocalDate moveOutDate) {
        this.moveOutDate = moveOutDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    

}
