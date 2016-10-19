package com.makarevich;

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public float getBill() {
        return bill;
    }

    public void setBill(float bill) {
        this.bill = bill;
    }

    public float calcBill(){
        for (Order order: orderList) {
          //  bill+=orderList.listIterator()
        }
        return bill;
    }
}
