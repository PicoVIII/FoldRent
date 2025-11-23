package com.foldrent.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder({"landlordID", "landlordFirstName", "landlordLastName", "landlordMidInitial", "landlordEmail", "landlordPhone"})

public class Landlords {
    private int landlordID;
    private String landlordFirstName;
    private String landlordLastName;
    private char landlordMidInitial;
    private String landlordEmail;
    private String landlordPhone;

    public Landlords(int landlordID, String landlordFirstName, String landlordLastName, char landlordMidInitial,
            String landlordEmail, String landlordPhone) {
                
        this.landlordID = landlordID;
        this.landlordFirstName = landlordFirstName;
        this.landlordLastName = landlordLastName;
        this.landlordMidInitial = landlordMidInitial;
        this.landlordEmail = landlordEmail;
        this.landlordPhone = landlordPhone;
    }

    public int getLandlordID() {
        return landlordID;
    }

    public void setLandlordID(int landlordID) {
        this.landlordID = landlordID;
    }

    public String getLandlordFirstName() {
        return landlordFirstName;
    }

    public void setLandlordFirstName(String landlordFirstName) {
        this.landlordFirstName = landlordFirstName;
    }

    public String getLandlordLastName() {
        return landlordLastName;
    }

    public void setLandlordLastName(String landlordLastName) {
        this.landlordLastName = landlordLastName;
    }

    public char getLandlordMidInitial() {
        return landlordMidInitial;
    }

    public void setLandlordMidInitial(char landlordMidInitial) {
        this.landlordMidInitial = landlordMidInitial;
    }

    public String getLandlordEmail() {
        return landlordEmail;
    }

    public void setLandlordEmail(String landlordEmail) {
        this.landlordEmail = landlordEmail;
    }

    public String getLandlordPhone() {
        return landlordPhone;
    }

    public void setLandlordPhone(String landlordPhone) {
        this.landlordPhone = landlordPhone;
    }

    
}
