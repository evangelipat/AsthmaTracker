/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.athmatracker.model;

/**
 *
 * @author eveli
 */
public class Medication {

    private int id;
    private String name;
    private Integer dosage;

    public Medication() {
        this.name = "";
        this.dosage = 0;
    }

    public Medication(String name, Integer dosage) {
        this.name = name;
        this.dosage = dosage;
    }

    public boolean checkEmpty(String name, Integer dosage, String email) {

        if ((email == null || email.trim().isEmpty())
                || (name == null || name.trim().isEmpty())
                || (dosage == 0 || dosage.toString().trim().isEmpty())) {
            return true;
        } else {
            return false;
        }

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

    public Integer getDosage() {
        return dosage;
    }

    public void setDosage(Integer dosage) {
        this.dosage = dosage;
    }

}
