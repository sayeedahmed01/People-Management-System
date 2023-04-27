package edu.neu.csye6200.peoplemanagementsystem.Factory.personFactories;

import edu.neu.csye6200.peoplemanagementsystem.builder.PersonBuilder;

public class PersonBuilderFactory implements BaseBuilderFactory {

    private static PersonBuilderFactory personBuilderFactory;

    private PersonBuilderFactory() {}

    public static PersonBuilderFactory getInstance() {
        if (personBuilderFactory == null) {
            personBuilderFactory = new PersonBuilderFactory();
        }
        return personBuilderFactory;
    }

    @Override
    public PersonBuilder getBuilder() {
        return new PersonBuilder();
    }
}
