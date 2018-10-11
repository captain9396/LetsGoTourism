package com.example.asus.letsgotourism;

public class PoliceItem {

    private String division;
    private String region;
    private String name;
    private String phoneNumber;


    public PoliceItem(String division, String region, String name, String phoneNumber) {
        this.division = division;
        this.region = region;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
