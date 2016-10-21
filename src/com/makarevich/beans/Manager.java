package com.makarevich.beans;

import com.makarevich.tools.Initialisation;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

/**
 * Created by j on 21.10.16.
 */
public class Manager extends Human implements User {

    private Map<Integer,String> abilities = new HashMap<Integer,String>();

    public Manager(String firstName, String lastName,
                    GregorianCalendar birthDate) {
        this.firstName = firstName;
        this.lastName =lastName;
        this.birthDate= birthDate;
        this.abilities.put(1,"Show all orders");

    }

    @Override
    public void showAbilities() {
        for (Map.Entry<Integer,String> entry: abilities.entrySet()) {
            System.out.println(entry.getKey()+". "+entry.getValue());
        }
    }

    @Override
    public void executeAbility(int indexOfAbility) {
        try {
            ListIterator<Order> iterator=Initialisation.orders.listIterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }catch (NullPointerException e){
            System.out.println("No orders");
        }

    }
}
