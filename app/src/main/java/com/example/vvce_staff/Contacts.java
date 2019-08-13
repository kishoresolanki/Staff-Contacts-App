package com.example.vvce_staff;

public class Contacts {
    String contactName;
    int contactNumber;
    String contactDesignation;
    int contactExtensionNumber;

    public Contacts(String mContactName,int mContactNumber,String mContactDesignation,int mContactExtensionNumber){
        this.contactName=mContactName;
        this.contactNumber = mContactNumber;
        this.contactDesignation= mContactDesignation;
        this.contactExtensionNumber=mContactExtensionNumber;
    }
    public int getContactNumber() {
        return contactNumber;
    }

    public int getContactExtensionNumber() {
        return contactExtensionNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactDesignation() {
        return contactDesignation;
    }
}
