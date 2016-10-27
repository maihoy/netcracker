package com.makarevich.beans;


/**
 * Created by j on 19.10.16.
 */
public class Bill {
    private Waiter waiter;
    private Order order;
    private float bill;

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Bill(Waiter waiter,
                Order order) {
        this.waiter=waiter;
        this.order=order;
    }

    public void out() {
        try {

        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
