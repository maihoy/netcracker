package com.makarevich.beans;

import java.util.Calendar;

/**
 * Created by j on 19.10.16.
 */
public class Human {
    protected String firstName;
    protected String lastName;
    protected Calendar birthDate;


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

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }




}
