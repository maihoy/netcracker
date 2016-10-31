package com.makarevich.beans;

import com.makarevich.enums.MenuItems;
import com.makarevich.utils.OrderUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by j on 19.10.16.
 */
public class Order implements Comparable<Order>, Serializable{


    private List<MenuItems> orderList = new ArrayList<MenuItems>();
    private static int orderCount;
    private int orderNum;
    private Customer customer;



    public List<MenuItems> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<MenuItems> orderList) {
        this.orderList = orderList;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order(Customer customer) {
        orderCount++;
        orderNum=orderCount;
        this.customer= customer;
    }


    public static int getOrderCount() {
        return orderCount;
    }

    public static void setOrderCount(int orderCount) {
        Order.orderCount = orderCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (getOrderNum() != order.getOrderNum()) return false;
        if (getOrderList() != null ? !getOrderList().equals(order.getOrderList()) : order.getOrderList() != null)
            return false;
        return getCustomer() != null ? getCustomer().equals(order.getCustomer()) : order.getCustomer() == null;

    }

    @Override
    public int hashCode() {
        int result = getOrderList() != null ? getOrderList().hashCode() : 0;
        result = 31 * result + getOrderNum();
        result = 31 * result + (getCustomer() != null ? getCustomer().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order: " +
                "orderList=" + orderList +
                ", orderNum=" + orderNum +
                ", customer=" + customer.getFirstName()+" " +customer.getLastName()+
                '.';
    }

    @Override
    public int compareTo(Order o) {
        if(this.orderNum>o.orderNum){
            return 1;        }
        else return -1;
    }

}
