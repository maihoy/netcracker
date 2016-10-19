package com.makarevich;

import java.util.Calendar;

/**
 * Created by j on 19.10.16.
 */
public class Customer extends Human {

    private float money;

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Customer(String firstName, String lastName,
                    Calendar birthDate, float money) {
        this.firstName = firstName;
        this.lastName =lastName;
        this.birthDate= birthDate;
        this.money= money;
    }
}
