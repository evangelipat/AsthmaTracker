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
    private String name;
    private String surname;
    private String birth_date;
    private int gender;
    private double height;

    public User() {
        this.email = "";
        this.password = "";
        this.name = "";
        this.surname = "";
        this.birth_date = "";
        this.gender = 0;
        this.height = 0;
    }

    public User(String email, String password, String birthDate, int gender) {
        this.email = email;
        this.password = password;
        this.birth_date = birthDate;
        this.gender = gender;
    }

    public User(String email, String password, String name, String surname, String birthDate, double height, int gender) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.birth_date = birthDate;
        this.gender = gender;
        this.height = height;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

}
