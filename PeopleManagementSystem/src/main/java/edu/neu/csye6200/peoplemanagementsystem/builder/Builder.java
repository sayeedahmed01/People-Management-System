package edu.neu.csye6200.peoplemanagementsystem.builder;

import edu.neu.csye6200.peoplemanagementsystem.pojo.CountryEnum;
import edu.neu.csye6200.peoplemanagementsystem.pojo.Gender;

import java.time.LocalDateTime;

public interface Builder {

    public Builder createEntity();

    public Builder setFName(String value);

    public Builder setLName(String value);

    public Builder setGender(Gender value);

    public Builder setPhone(String value);

    public Builder setEmail(String value);

    public Builder setDob(LocalDateTime value);

    public Builder setCity(String value);

    public Builder setStreetAddress(String value);

    public Builder setZipCode(String value);

    public Builder setIdType(String value);

    public Builder setPassword(String value);

    public Builder setCountry(CountryEnum value);

    public Builder setUserName(String value);
}
