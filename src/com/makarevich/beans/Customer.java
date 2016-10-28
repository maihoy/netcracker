package com.makarevich.beans;


import com.makarevich.utils.CustomerUtil;

import java.util.GregorianCalendar;

/**
 * Created by j on 19.10.16.
 */
public class Customer extends Person {

    private final CustomerUtil customerUtil = new CustomerUtil(this);
    private float money;
    private Order order;


    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public CustomerUtil getCustomerUtil() {
        return customerUtil;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        if (!super.equals(o)) return false;

        Customer customer = (Customer) o;

        if (Float.compare(customer.getMoney(), getMoney()) != 0) return false;
        if (customerUtil != null ? !customerUtil.equals(customer.customerUtil) : customer.customerUtil != null)
            return false;
        return getOrder() != null ? getOrder().equals(customer.getOrder()) : customer.getOrder() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (customerUtil != null ? customerUtil.hashCode() : 0);
        result = 31 * result + (getMoney() != +0.0f ? Float.floatToIntBits(getMoney()) : 0);
        result = 31 * result + (getOrder() != null ? getOrder().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerUtil=" + customerUtil +
                ", money=" + money +
                ", order=" + order +
                '}';
    }

}
