package edu.neu.csye6200.peoplemanagementsystem.builder;

import edu.neu.csye6200.peoplemanagementsystem.pojo.CountryEnum;
import edu.neu.csye6200.peoplemanagementsystem.pojo.Gender;
import edu.neu.csye6200.peoplemanagementsystem.pojo.Person;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class PersonBuilder implements Builder {

    //protected so that extending class can only access this object
    protected Person person;

    Person build() {
        return this.person;
    }

    @Override
    public PersonBuilder createEntity() {
        person = new Person();
        return this;
    }

    @Override
    public PersonBuilder setFName(String value) {
        this.person.setCity(value);
        return this;
    }

    @Override
    public PersonBuilder setLName(String value) {
        this.person.setLName(value);
        return this;
    }

    @Override
    public PersonBuilder setGender(Gender value) {
        this.person.setGender(value);
        return this;
    }

    @Override
    public PersonBuilder setPhone(String value) {
        this.person.setPhone(value);
        return this;
    }

    @Override
    public PersonBuilder setEmail(String value) {
        this.person.setEmail(value);
        return this;
    }

    @Override
    public PersonBuilder setDob(LocalDateTime value) {
        this.person.setDob(value);
        return this;
    }

    @Override
    public PersonBuilder setCity(String value) {
        this.person.setCity(value);
        return this;
    }

    @Override
    public PersonBuilder setStreetAddress(String value) {
        this.person.setStreetAddress(value);
        return this;
    }

    @Override
    public PersonBuilder setZipCode(String value) {
        this.person.setZipCode(value);
        return this;
    }

    @Override
    public PersonBuilder setIdType(String value) {
        this.person.setIdType(value);
        return this;
    }

    @Override
    public PersonBuilder setPassword(String value) {
        this.person.setPassword(value);
        return this;
    }

    @Override
    public PersonBuilder setCountry(CountryEnum value) {
        this.person.setCountry(value);
        return this;
    }

    @Override
    public PersonBuilder setUserName(String value) {
        this.person.setUserName(value);
        return this;
    }

}
