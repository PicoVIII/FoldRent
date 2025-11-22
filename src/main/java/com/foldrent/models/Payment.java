package com.foldrent.models;

import java.time.LocalDate;

public class Payment {
    int paymentID;
    int tenantID;
    double paymentAmount;
    LocalDate paymentDate;
    String paymentMethod;
    String paymentDescription;
    int paymentLateFee;

    public Payment(int paymentID, int tenantID, 
        double paymentAmount, LocalDate paymentDate, 
        String paymentMethod, String paymentDescription, 
        int paymentLateFee) {
        this.paymentID = paymentID;
        this.tenantID = tenantID;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.paymentDescription = paymentDescription;
        this.paymentLateFee = paymentLateFee;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getTenantID() {
        return tenantID;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    public int getPaymentLateFee() {
        return paymentLateFee;
    }

    public void setPaymentLateFee(int paymentLateFee) {
        this.paymentLateFee = paymentLateFee;
    }
    
    
}
