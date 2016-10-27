package com.makarevich.beans;


import com.makarevich.tools.Initialisation;
import com.makarevich.tools.Operations;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by j on 19.10.16.
 */
public class Customer extends Person implements User{

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

    public Customer(){
        this.abilities.put(1,"Create order");
        this.abilities.put(2,"Pay");
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

    private void createOrder(){

    }

    @Override
    public void showAbilities() {
        for (Map.Entry<Integer,String> entry: abilities.entrySet()) {
            System.out.println(entry.getKey()+". "+entry.getValue());
        }
    }

    @Override
    public void executeAbility(int indexOfAbility) {

        Operations.createCustomer();

        if(indexOfAbility==1){
                //create order
                Order order = new Order();
                Initialisation.newtStep(order);
        }
        if (indexOfAbility==2){
            //pay
        }

    }
}
