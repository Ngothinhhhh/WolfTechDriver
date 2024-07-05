package com.example.appdriver.Object;

import com.google.firebase.Timestamp;


import java.util.Date;

public class Driver {
    private String name;
    private String email;
    private  String phone_number ;
    private  String password_hash;
    private Timestamp created_at;
    private Boolean status;
    private String vehicle_ref;
    // còn phần phương tiện và biển số xe


    public Driver(String name, String email, String phone_number, String password_hash, Timestamp created_at, Boolean status, String vehicle_ref) {
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.password_hash = password_hash;
        this.created_at = created_at;
        this.status = status;
        this.vehicle_ref = vehicle_ref;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getVehicle_ref() {
        return vehicle_ref;
    }

    public void setVehicle_ref(String vehicle_ref) {
        this.vehicle_ref = vehicle_ref;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }


//    private boolean isValid(String clearTextPassword, String hashedPass) {
//        // returns true if password matches hash
//       // return BCrypt.checkpw(clearTextPassword, hashedPass);
//    }





}
