package com.makarevich.beans;


import com.makarevich.enums.MenuItems;
import com.makarevich.utils.BillUtil;

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

    public List<MenuItems> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<MenuItems> orderList) {
        this.orderList = orderList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bill)) return false;

        Bill bill1 = (Bill) o;

        if (Float.compare(bill1.getBill(), getBill()) != 0) return false;
        if (getWaiter() != null ? !getWaiter().equals(bill1.getWaiter()) : bill1.getWaiter() != null) return false;
        if (getOrder() != null ? !getOrder().equals(bill1.getOrder()) : bill1.getOrder() != null) return false;
        return getOrderList() != null ? getOrderList().equals(bill1.getOrderList()) : bill1.getOrderList() == null;

    }

    @Override
    public int hashCode() {
        int result = getWaiter() != null ? getWaiter().hashCode() : 0;
        result = 31 * result + (getOrder() != null ? getOrder().hashCode() : 0);
        result = 31 * result + (getBill() != +0.0f ? Float.floatToIntBits(getBill()) : 0);
        result = 31 * result + (getOrderList() != null ? getOrderList().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "waiter=" + waiter +
                ", order=" + order +
                ", bill=" + bill +
                ", orderList=" + orderList +
                '}';
    }

}
