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
public class Logbook {

    private int id;
    private String attack_date;
    private int attack_duration;
    private String unit;
    private String attack_triggers;
    private String peakflow_date;
    private int peakflow_value;
    private int wheeze;
    private int cough;
    private int phlegm;
    private int tightness;      //0 den exei -> 1 exei
    private int breathing;
    private int wakeup;
    private String notes;
    private String created;

    public Logbook() {
        this.id = -1;
        this.attack_date = "";
        this.attack_duration = 0;
        this.unit = "";
        this.attack_triggers = "";
        this.peakflow_date = "";
        this.peakflow_value = 0;
        this.wheeze = 0;
        this.cough = 0;
        this.phlegm = 0;
        this.tightness = 0;
        this.breathing = 0;
        this.wakeup = 0;
        this.notes = "";
        this.created = "";
    }

    public Logbook(String attack_date,
            int attack_duration,
            String unit, String attack_triggers,
            String peakflow_date,
            int peakflow_value,
            int wheeze, int cough, int phlegm, int tightness, int breathing, int wakeup,
            String notes, String created) {
        this.attack_date = attack_date;
        this.attack_duration = attack_duration;
        this.unit = unit;
        this.attack_triggers = attack_triggers;
        this.peakflow_date = peakflow_date;
        this.peakflow_value = peakflow_value;
        this.wheeze = wheeze;
        this.cough = cough;
        this.phlegm = phlegm;
        this.tightness = tightness;
        this.breathing = breathing;
        this.wakeup = wakeup;
        this.notes = notes;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttack_date() {
        return attack_date;
    }

    public void setAttack_date(String attack_date) {
        this.attack_date = attack_date;
    }

    public int getAttack_duration() {
        return attack_duration;
    }

    public void setAttack_duration(int attack_duration) {
        this.attack_duration = attack_duration;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAttack_triggers() {
        return attack_triggers;
    }

    public void setAttack_triggers(String attack_triggers) {
        this.attack_triggers = attack_triggers;
    }

    public String getPeakflow_date() {
        return peakflow_date;
    }

    public void setPeakflow_date(String peakflow_date) {
        this.peakflow_date = peakflow_date;
    }

    public int getPeakflow_value() {
        return peakflow_value;
    }

    public void setPeakflow_value(int peakflow_value) {
        this.peakflow_value = peakflow_value;
    }

    public int getWheeze() {
        return wheeze;
    }

    public void setWheeze(int wheeze) {
        this.wheeze = wheeze;
    }

    public int getCough() {
        return cough;
    }

    public void setCough(int cough) {
        this.cough = cough;
    }

    public int getPhlegm() {
        return phlegm;
    }

    public void setPhlegm(int phlegm) {
        this.phlegm = phlegm;
    }

    public int getTightness() {
        return tightness;
    }

    public void setTightness(int tightness) {
        this.tightness = tightness;
    }

    public int getBreathing() {
        return breathing;
    }

    public void setBreathing(int breathing) {
        this.breathing = breathing;
    }

    public int getWakeup() {
        return wakeup;
    }

    public void setWakeup(int wakeup) {
        this.wakeup = wakeup;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
