package com.makarevich.beans;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by j on 21.10.16.
 */
public class Manager extends Person implements User{

    private final ManagerUtil managerUtil = new ManagerUtil(this);
    private Map<Integer,String> abilities = new HashMap<Integer,String>();

    public Manager(String firstName, String lastName,
                    GregorianCalendar birthDate) {
        this.firstName = firstName;
        this.lastName =lastName;
        this.birthDate= birthDate;
        this.abilities.put(1,"Show all orders");

    }

    public Manager() {
        this.abilities.put(1,"Show all orders");
    }

    public Map<Integer, String> getAbilities() {
        return abilities;
    }

    public void setAbilities(Map<Integer, String> abilities) {
        this.abilities = abilities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;

        Manager manager = (Manager) o;

        return abilities != null ? abilities.equals(manager.abilities) : manager.abilities == null;

    }

    @Override
    public int hashCode() {
        return abilities != null ? abilities.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "abilities=" + abilities +
                '}';
    }



    @Override
    public void showAbilities() {
        managerUtil.showAbilities();
    }

    @Override
    public void executeAbility(int indexOfAbility) {
        managerUtil.executeAbility(indexOfAbility);
    }
}
