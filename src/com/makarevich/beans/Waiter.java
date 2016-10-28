package com.makarevich.beans;

import com.makarevich.tools.Initialisation;
import com.makarevich.tools.Operations;

import java.util.*;

/**
 * Created by j on 19.10.16.
 */
public class Waiter extends Person implements User {

    private Map<Integer, String> abilities = new HashMap<Integer, String>();
    private float experience;
    private Restaurant restaurant;
    private List<Order> orders = new ArrayList<Order>();
    private Order currentOrder;

    public Waiter() {
        super();
        this.abilities.put(1, "Take order");
        this.abilities.put(2, "Create restaurant bill");
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
        this.abilities.put(1, "Take order");
        this.abilities.put(2, "Create restaurant bill");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Waiter)) return false;

        Waiter waiter = (Waiter) o;

        if (Float.compare(waiter.getExperience(), getExperience()) != 0) return false;
        if (abilities != null ? !abilities.equals(waiter.abilities) : waiter.abilities != null) return false;
        if (!getRestaurant().equals(waiter.getRestaurant())) return false;
        if (getOrders() != null ? !getOrders().equals(waiter.getOrders()) : waiter.getOrders() != null) return false;
        return getCurrentOrder() != null ? getCurrentOrder().equals(waiter.getCurrentOrder()) : waiter.getCurrentOrder() == null;

    }

    @Override
    public int hashCode() {
        int result = abilities != null ? abilities.hashCode() : 0;
        result = 31 * result + (getExperience() != +0.0f ? Float.floatToIntBits(getExperience()) : 0);
        result = 31 * result + getRestaurant().hashCode();
        result = 31 * result + (getOrders() != null ? getOrders().hashCode() : 0);
        result = 31 * result + (getCurrentOrder() != null ? getCurrentOrder().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "abilities=" + abilities +
                ", experience=" + experience +
                ", restaurant=" + restaurant +
                ", orders=" + orders +
                ", currentOrder=" + currentOrder +
                '}';
    }

    @Override
    public void showAbilities() {
        for (Map.Entry<Integer, String> entry : abilities.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }

    @Override
    public void executeAbility(int indexOfAbility) {
        if (indexOfAbility == 1) {
            //take order
            Customer customer = Operations.createCustomer();
            Order order = new Order(customer);
            Initialisation.newtStep(order);
            orders.add(order);
            currentOrder= order;
        }
        if (indexOfAbility == 2) {
            //create bill
            if (!orders.isEmpty()) {
                int posCount = orders.size();
                posCount--;
                int i = 0;
                System.out.println("Choose order: ");
                while (i <= posCount) {
                    System.out.println(i + 1 + "." + orders.get(i));
                    i++;
                }
                System.out.println();

                while (true) {
                    int indexOfOrder = Operations.inputNum();
                    if (indexOfOrder == 0) {
                        break;
                    } else {
                        Bill bill=new Bill(Waiter.this,orders.get(indexOfOrder-1));
                        bill.out();
                        return;
                    }
                }

            } else {
                System.out.println("No orders");
            }

        }
    }
}

