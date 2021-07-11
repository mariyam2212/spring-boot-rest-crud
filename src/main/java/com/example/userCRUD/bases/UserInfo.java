/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.userCRUD.bases;

/**
 *
 * @author lpt-2030
 */
public class UserInfo extends Output_Base{
    private int id ;
    private String name ;
    private String email ; 
    private String contact ; 
    private String location ; 
    private String designation ; 

    public UserInfo(int id, String name, String email, String contact, String location, String designation) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.location = location;
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    
}
