package com.makarevich.beans;


import com.makarevich.tools.Initialisation;
import com.makarevich.tools.Operations;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by j on 19.10.16.
 */
public class Customer extends Human implements User{

    private Map<Integer,String> abilities = new HashMap<Integer,String>();
    private float money;
    private Order order;

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Customer(String firstName, String lastName,
                    GregorianCalendar birthDate, float money) {
        this.firstName = firstName;
        this.lastName =lastName;
        this.birthDate= birthDate;
        this.money= money;
        this.abilities.put(1,"Create order");
        this.abilities.put(2,"Pay");
    }

    private void createOrdedr(){

    }

    @Override
    public void showAbilities() {
        for (Map.Entry<Integer,String> entry: abilities.entrySet()) {
            System.out.println(entry.getKey()+". "+entry.getValue());
        }
    }

    @Override
    public void executeAbility(int indexOfAbility) {
        if(indexOfAbility==1){
            try {
                createOrdedr();
               // Initialisation.newtStep(newOrder);

            }
            catch (NullPointerException e){
                System.out.println("No orders");
            }
        }
        if (indexOfAbility==2){

        }
    }
}
