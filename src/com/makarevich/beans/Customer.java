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

    @Override
    public String toString() {
        return "Customer{" +
                "abilities=" + abilities +
                ", money=" + money +
                ", order=" + order +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        if (Float.compare(customer.getMoney(), getMoney()) != 0) return false;
        if (abilities != null ? !abilities.equals(customer.abilities) : customer.abilities != null) return false;
        return getOrder() != null ? getOrder().equals(customer.getOrder()) : customer.getOrder() == null;

    }

    @Override
    public int hashCode() {
        int result = abilities != null ? abilities.hashCode() : 0;
        result = 31 * result + (getMoney() != +0.0f ? Float.floatToIntBits(getMoney()) : 0);
        result = 31 * result + (getOrder() != null ? getOrder().hashCode() : 0);
        return result;
    }

    @Override
    public void showAbilities() {
        for (Map.Entry<Integer,String> entry: abilities.entrySet()) {
            System.out.println(entry.getKey()+". "+entry.getValue());
        }
    }

    @Override
    public void executeAbility(int indexOfAbility) {

         Customer customer=Operations.createCustomer();

        if(indexOfAbility==1){
                //create order
                Order order = new Order(customer);
                Initialisation.newtStep(order);
        }
        if (indexOfAbility==2){
            //pay
        }

    }
}
