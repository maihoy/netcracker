package com.makarevich.beans;

import com.makarevich.tools.Initialisation;

import java.util.ListIterator;
import java.util.Map;

public class ManagerUtil implements User {
    private final Manager manager;

    public ManagerUtil(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void showAbilities() {
        for (Map.Entry<Integer, String> entry : manager.getAbilities().entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }

    @Override
    public void executeAbility(int indexOfAbility) {
        try {
            ListIterator<Order> iterator = Initialisation.orders.listIterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (NullPointerException e) {
            System.out.println("No orders");
        }

    }
}