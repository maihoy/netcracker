package com.makarevich.beans;

import com.makarevich.utils.WaiterUtil;

import java.util.*;

/**
 * Created by j on 19.10.16.
 */
public class Waiter extends Person  {

    private final WaiterUtil waiterUtil = new WaiterUtil(this);

    private float experience;
    private Restaurant restaurant;
    private List<Order> orders = new ArrayList<Order>();
    private Order currentOrder;

    public Waiter() {
        super();
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Waiter(String firstName, String lastName,
                  GregorianCalendar birthDate, float experience) {
        super(firstName,lastName,birthDate);
        this.experience = experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Waiter)) return false;
        if (!super.equals(o)) return false;

        Waiter waiter = (Waiter) o;

        if (Float.compare(waiter.getExperience(), getExperience()) != 0) return false;
        if (waiterUtil != null ? !waiterUtil.equals(waiter.waiterUtil) : waiter.waiterUtil != null) return false;
        if (getRestaurant() != null ? !getRestaurant().equals(waiter.getRestaurant()) : waiter.getRestaurant() != null)
            return false;
        if (getOrders() != null ? !getOrders().equals(waiter.getOrders()) : waiter.getOrders() != null) return false;
        return getCurrentOrder() != null ? getCurrentOrder().equals(waiter.getCurrentOrder()) : waiter.getCurrentOrder() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (waiterUtil != null ? waiterUtil.hashCode() : 0);
        result = 31 * result + (getExperience() != +0.0f ? Float.floatToIntBits(getExperience()) : 0);
        result = 31 * result + (getRestaurant() != null ? getRestaurant().hashCode() : 0);
        result = 31 * result + (getOrders() != null ? getOrders().hashCode() : 0);
        result = 31 * result + (getCurrentOrder() != null ? getCurrentOrder().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "waiterUtil=" + waiterUtil +
                ", experience=" + experience +
                ", restaurant=" + restaurant +
                ", orders=" + orders +
                ", currentOrder=" + currentOrder +
                '}';
    }
}

