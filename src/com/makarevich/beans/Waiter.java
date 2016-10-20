package com.makarevich.beans;

import java.util.Calendar;

/**
 * Created by j on 19.10.16.
 */
public class Waiter extends Human {

    private float experiance;
    private Restaurant restaurant;

    public float getExperiance() {
        return experiance;
    }

    public void setExperiance(float experiance) {
        this.experiance = experiance;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Waiter(String firstName, String lastName,
                  Calendar birthDate, float experiance) {
        this.firstName = firstName;
        this.lastName =lastName;
        this.birthDate= birthDate;
        this.experiance= experiance;
    }

    public void takeOrder(){

    }
}
