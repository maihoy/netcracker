package com.makarevich.beans;

import java.util.ListIterator;

/**
 * Created by j on 19.10.16.
 */
public class Bill extends Order {
    private Customer customer;
    private Waiter waiter;
    private Order order;
    private float bill;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public float getBill() {
        return bill;
    }

    public void setBill(float bill) {
        this.bill = bill;
    }

    public float calcBill(){
        ListIterator<Order> lit =orderList.listIterator();
        while (lit.hasNext()){
           // bill =lit.next().orderList
        }
        return bill;
    }
}
