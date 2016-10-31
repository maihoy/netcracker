package com.makarevich.utils;

import com.makarevich.beans.Manager;
import com.makarevich.beans.Order;
import com.makarevich.interfaces.Entity;
import com.makarevich.tools.Initialisation;
import com.makarevich.tools.Operations;

import java.io.File;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class ManagerUtil implements Entity {
    private final Manager manager;
    private Map<Integer,String> abilities = new HashMap<Integer,String>();

    public ManagerUtil(Manager manager) {
        this.abilities.put(1,"Show all orders");
        this.abilities.put(2,"Show bill");
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
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
        if (indexOfAbility==1) {
            try {
                ListIterator<Order> iterator = Initialisation.orders.listIterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            } catch (NullPointerException e) {
                System.out.println("No orders");
            }
        }
        if (indexOfAbility==2){
            File file= new File(Operations.OUT_PATH);
            Operations.processFilesFromFolder(file);
        }
    }
}