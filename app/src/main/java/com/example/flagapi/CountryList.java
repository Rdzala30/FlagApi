package com.example.flagapi;

public class CountryList {
    private final String countryName;
    private final String countryCapital;
    private final String countryFlag;

    public CountryList(String countryName, String countryCapital, String countryFlag) {
        this.countryName = countryName;
        this.countryCapital = countryCapital;
        this.countryFlag = countryFlag;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

}

