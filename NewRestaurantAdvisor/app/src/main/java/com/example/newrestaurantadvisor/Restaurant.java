package com.example.newrestaurantadvisor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Restaurant {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("grade")
    @Expose
    private String grade;
    @SerializedName("localization")
    @Expose
    private String localization;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("hours")
    @Expose
    private String hours;

    public String getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getGrade() {
        return grade;
    }
    public String getLocalization() {
        return localization;
    }
    public String getPhone() {
        return phone;
    }
    public String getWebsite() {
        return website;
    }
    public String getHours() {
        return hours;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setGrade(String id) {
        this.grade = grade;
    }
    public void setLocalization(String localization) {
        this.localization = localization;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public void setHours(String hours) {
        this.hours = hours;
    }
}
