package com.makarevich.beans;


import com.makarevich.utils.CustomerUtil;

import java.util.GregorianCalendar;

/**
 * Created by j on 19.10.16.
 */
public class Customer extends Person {

    private float money;

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        if (!super.equals(o)) return false;

        Customer customer = (Customer) o;

        return Float.compare(customer.getMoney(), getMoney()) == 0;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getMoney() != +0.0f ? Float.floatToIntBits(getMoney()) : 0);
        return result;
    }

    public Customer(){
    }

    public Customer(String firstName, String lastName,
                    GregorianCalendar birthDate, float money) {
        this.firstName = firstName;
        this.lastName =lastName;
        this.birthDate= birthDate;
        this.money= money;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "money=" + money +
                '}';
    }

}
