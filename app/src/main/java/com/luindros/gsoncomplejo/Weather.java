package com.luindros.gsoncomplejo;

public class Weather {

    private String cod;
    private String name;
    private String country;
    private String description;

    public Weather() {
    }

    public Weather(String cod, String name, String country, String description) {
        this.cod = cod;
        this.name = name;
        this.country = country;
        this.description = description;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
