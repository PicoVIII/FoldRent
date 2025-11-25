package com.foldrent.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"tenantID", "tenantFirstName", "tenantLastName", "tenantMidInitial", "tenantBirthDate", "tenantEmail", "tenantPhone", "tenantRoomNumber", "rentAmount", "rentBalance", "rentMissed", "moveInDate", "moveOutDate", "active"})

public class Tenants {
    private int tenantID;
    private String tenantFirstName;
    private String tenantLastName;
    private char tenantMidInitial;
    private char tenantGender;
    private LocalDate tenantBirthDate;
    private String tenantEmail;
    private String tenantPhone;
    private int tenantRoomNumber;
    private double rentAmount; // rent price per month
    private double rentBalance; // total balance = rentAmount x rent missed
    private int rentMissed; // months missed
    private LocalDate moveInDate;
    private LocalDate moveOutDate;
    private boolean isActive;

    public Tenants(int id, String firstName, String lastName, char middleInitial, char gender, LocalDate birthDate, String email, String phoneNumber) {
        this.tenantID = id;
        this.tenantFirstName = firstName;
        this.tenantLastName = lastName;
        this.tenantMidInitial = middleInitial;
        this.tenantBirthDate = birthDate;
        this.tenantGender = gender;
        this.tenantEmail = email;
        this.tenantPhone = phoneNumber;
        this.tenantRoomNumber = 0; // set to 0 by default, landlord will assign later.
        this.rentAmount = 0; //set to 0, landlord will assign later.
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

    public LocalDate getTenantBirthDate() {
        return tenantBirthDate;
    }

    public void setTenantBirthDate(LocalDate tenantBirthDate) {
        this.tenantBirthDate = tenantBirthDate;
    }

    public String getTenantEmail() {
        return tenantEmail;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    public String getTenantPhoneNumber() {
        return tenantPhone;
    }

    public void setTenantPhoneNumber(String tenantPhone) {
        this.tenantPhone = tenantPhone;
    }

    public int getTenantRoomNumber() {
        return tenantRoomNumber;
    }

    public void setTenantRoomNumber(int tenantRoomNumber) {
        this.tenantRoomNumber = tenantRoomNumber;
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
