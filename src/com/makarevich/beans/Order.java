package com.makarevich.beans;

import com.makarevich.enums.MenuItems;
import com.makarevich.utils.OrderUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j on 19.10.16.
 */
public class Order{
    private final OrderUtil orderUtil = new OrderUtil(this);
    public List<MenuItems> orderList = new ArrayList<MenuItems>();
    public static int orderCount;
    private int orderNum;
    private Customer customer;

    private Menu menu=new Menu();

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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public OrderUtil getOrderUtil() {
        return orderUtil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (getOrderNum() != order.getOrderNum()) return false;
        if (orderUtil != null ? !orderUtil.equals(order.orderUtil) : order.orderUtil != null) return false;
        if (getOrderList() != null ? !getOrderList().equals(order.getOrderList()) : order.getOrderList() != null)
            return false;
        if (getCustomer() != null ? !getCustomer().equals(order.getCustomer()) : order.getCustomer() != null)
            return false;
        return getMenu() != null ? getMenu().equals(order.getMenu()) : order.getMenu() == null;

    }

    @Override
    public int hashCode() {
        int result = orderUtil != null ? orderUtil.hashCode() : 0;
        result = 31 * result + (getOrderList() != null ? getOrderList().hashCode() : 0);
        result = 31 * result + getOrderNum();
        result = 31 * result + (getCustomer() != null ? getCustomer().hashCode() : 0);
        result = 31 * result + (getMenu() != null ? getMenu().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderUtil=" + orderUtil +
                ", orderList=" + orderList +
                ", orderNum=" + orderNum +
                ", customer=" + customer +
                ", menu=" + menu +
                '}';
    }
}
