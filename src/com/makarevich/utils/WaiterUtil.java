package com.makarevich.utils;

import com.makarevich.beans.*;
import com.makarevich.interfaces.User;
import com.makarevich.tools.Initialisation;
import com.makarevich.tools.Operations;

import java.util.HashMap;
import java.util.Map;

public class WaiterUtil implements User {
    private final Waiter waiter;
    private Map<Integer, String> abilities = new HashMap<Integer, String>();

    public Map<Integer, String> getAbilities() {
        return abilities;
    }

    public void setAbilities(Map<Integer, String> abilities) {
        this.abilities = abilities;
    }

    public WaiterUtil( Waiter waiter) {
        this.abilities.put(1, "Take order");
        this.abilities.put(2, "Create restaurant bill");
        this.waiter = waiter;
    }


    @Override
    public void showAbilities() {
        for (Map.Entry<Integer, String> entry : this.abilities.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }

    @Override
    public void executeAbility(int indexOfAbility) {
        if (indexOfAbility == 1) {
            //take order
            Customer customer = Operations.createCustomer();
            Order order = new Order(customer);
            Initialisation.newtStep(new OrderUtil(order));
            waiter.getOrders().add(order);
            waiter.setCurrentOrder(order);
        }
        if (indexOfAbility == 2) {
            //create bill

            if (!waiter.getOrders().isEmpty()) {
                int posCount = waiter.getOrders().size();
                posCount--;
                int i = 0;
                System.out.println("Choose order: ");
                while (i <= posCount) {
                    System.out.println(i + 1 + "." + waiter.getOrders().get(i));
                    i++;
                }
                System.out.println();

                while (true) {
                    int indexOfOrder = Operations.inputNum();
                    if (indexOfOrder == 0) {
                        break;
                    } else {
                        Bill bill = new Bill(waiter, waiter.getOrders().get(indexOfOrder - 1));
                        BillUtil billUtil=new BillUtil(bill);
                        billUtil.out();
                        return;
                    }
                }

            } else {
                System.out.println("No orders");
            }

        }
    }
}