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
    

    
}
