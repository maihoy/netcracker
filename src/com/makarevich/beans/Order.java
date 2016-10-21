package com.makarevich.beans;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by j on 19.10.16.
 */
public class Order implements User{
    private Map<Integer,String> abilities = new HashMap<Integer,String>();
    public List<Order> orderList ;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void addOrderItem(int indexOfItem ){

    }

    public Order() {
        this.orderList = orderList;
        this.abilities.put(1,"Show menu");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return orderList != null ? orderList.equals(order.orderList) : order.orderList == null;


    }

    @Override
    public int hashCode() {
        return orderList != null ? orderList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Order:" +getOrderList();
    }

    @Override
    public void showAbilities() {
        for (Map.Entry<Integer,String> entry: abilities.entrySet()) {
            System.out.println(entry.getKey()+". "+entry.getValue());
        }

    }

    @Override
    public void executeAbility(int indexOfAbility) {

    }
}
