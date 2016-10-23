package com.makarevich.beans;

import com.makarevich.tools.Initialisation;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by j on 19.10.16.
 */
public class Waiter extends Person implements User{

    private Map<Integer,String> abilities = new HashMap<Integer,String>();
    private float experiance;
    private Restaurant restaurant;
    private List<Order> orders;
    private Order currentOrder;

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

    public float getExperiance() {
        return experiance;
    }

    public void setExperiance(float experiance) {
        this.experiance = experiance;
    }

    public Restaurant getRestaurant() {        return restaurant;    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Waiter(String firstName, String lastName,
                  GregorianCalendar birthDate, float experiance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.experiance = experiance;
        this.abilities.put(1,"Take order");
        this.abilities.put(2,"Create restaurant bill");
    }

    @Override
    public void showAbilities() {
        for (Map.Entry<Integer,String> entry: abilities.entrySet()) {
            System.out.println(entry.getKey()+". "+entry.getValue());
        }
    }

    @Override
    public void executeAbility(int indexOfAbility) {
        if (indexOfAbility==1){
            try {
                Order newOrder = new Order();
                currentOrder=newOrder;
                Initialisation.orders.add(newOrder);
                orders.add(newOrder);
            }
            catch (NullPointerException e){
                System.out.println("No orders");
            }
        }

        if (indexOfAbility==2){

        }


    }


}
