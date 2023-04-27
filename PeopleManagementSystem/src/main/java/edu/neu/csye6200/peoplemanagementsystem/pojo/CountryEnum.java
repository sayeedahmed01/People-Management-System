/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.peoplemanagementsystem.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 *
 * @author mehul
 */
public enum CountryEnum {
    //CountryEnum("India", ),

    na("NA", null),
    india("India", new HashMap<String, Consumer<String>>() {{
        put("Aadhar", new Consumer<String>() {
            @Override
            public void accept(String s) {
                s.isEmpty(); // treated as void here
            }
        });
        put("PAN", new Consumer<String>() {
            @Override
            public void accept(String s) {
                s.isEmpty(); // treated as void here
            }
        });
        put("License", new Consumer<String>() {
            @Override
            public void accept(String s) {
                s.isEmpty(); // treated as void here
            }
        });
    }}),
    us("US", new HashMap<String, Consumer<String>>() {{
        put("StateID", new Consumer<String>() {
            @Override
            public void accept(String s) {
                s.isEmpty(); // treated as void here
            }
        });
        put("SSN", new Consumer<String>() {
            @Override
            public void accept(String s) {
                s.isEmpty(); // treated as void here
            }
        });
        put("Passport", new Consumer<String>() {
            @Override
            public void accept(String s) {
                s.isEmpty(); // treated as void here
            }
        });
    }});
    String country;
    Map<String, Consumer<String>> idValidatorMapping;

    CountryEnum(String country) {
        this.country = country;
    }
    CountryEnum(String country, Map<String, Consumer<String>> val) {
        this.idValidatorMapping = val;
        this.country = country;
    }
    
    public static CountryEnum getCountryEnum(String value) {
        for (CountryEnum countryEnum : CountryEnum.values()) {
            if (countryEnum.country.equals(value.toLowerCase())) {
                return countryEnum;
            }
        }
        return CountryEnum.na;
    }
}

