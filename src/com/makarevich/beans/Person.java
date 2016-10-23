package com.makarevich.beans;

import java.util.GregorianCalendar;

/**
 * Created by j on 19.10.16.
 */
public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected GregorianCalendar birthDate;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GregorianCalendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(GregorianCalendar birthDate) {
        this.birthDate = birthDate;
    }




}
