package com.makarevich.beans;


import com.makarevich.enums.MenuItems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j on 19.10.16.
 */
public class Bill {
    private Waiter waiter;
    private Order order;
    private float bill;
    public List<MenuItems> orderList = new ArrayList<MenuItems>();

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public float getBill() {
        for (MenuItems order: orderList) {
            bill+=order.getCost();
        }
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
            System.out.println("Waiter: "+this.getWaiter().getFirstName()+" "+this.getWaiter().getLastName());
            System.out.println("Customer: "+this.getOrder().getCustomer().getFirstName()+" "+this.getOrder().getCustomer().getLastName());
            System.out.println("Order: "+this.getOrder());
            System.out.println("Your order's cost is "+this.getBill()+"$");

        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
