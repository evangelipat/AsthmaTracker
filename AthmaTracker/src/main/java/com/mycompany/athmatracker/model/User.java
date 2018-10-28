/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.athmatracker.model;

import java.util.Date;

/**
 *
 * @author eveli
 */
/**
 * gender-> 0 male , 1 female
 */
public class User {

    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String birth_date;
    private String gender;
    private String city;

    public User() {
        this.email = "";
        this.password = "";
        this.firstname = "";
        this.lastname = "";
        this.birth_date = "";
        this.gender = "";
        this.city = "";
    }

    public User(String email, String password, String firstname, String lastname, String birthDate, String gender) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birth_date = birthDate;
        this.gender = gender;
    }

    public User(String email, String password, String firstname, String lastname, String birthDate, String city, String gender) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birth_date = birthDate;
        this.gender = gender;
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
