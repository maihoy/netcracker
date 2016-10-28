package com.makarevich.utils;

import com.makarevich.beans.Customer;
import com.makarevich.beans.Order;
import com.makarevich.interfaces.User;
import com.makarevich.tools.Initialisation;
import com.makarevich.tools.Operations;

import java.util.HashMap;
import java.util.Map;

public class CustomerUtil implements User {
    private final Customer customer;
    private Map<Integer,String> abilities = new HashMap<Integer,String>();

    public CustomerUtil(Customer customer) {
        this.abilities.put(1,"Create order");
        this.abilities.put(2,"Pay");
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<Integer, String> getAbilities() {
        return abilities;
    }

    public void setAbilities(Map<Integer, String> abilities) {
        this.abilities = abilities;
    }

    @Override
    public void showAbilities() {
        for (Map.Entry<Integer, String> entry : this.abilities.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }

    @Override
    public void executeAbility(int indexOfAbility) {

        Customer customer = Operations.createCustomer();

        if (indexOfAbility == 1) {
            //create order
            Order order = new Order(customer);
            Initialisation.newtStep(new OrderUtil(order));
        }
        if (indexOfAbility == 2) {
            //pay
        }

    }
}