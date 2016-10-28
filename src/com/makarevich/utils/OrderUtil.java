package com.makarevich.utils;

import com.makarevich.beans.Menu;
import com.makarevich.beans.Order;
import com.makarevich.interfaces.User;
import com.makarevich.enums.MenuItems;
import com.makarevich.tools.Operations;

import java.util.HashMap;
import java.util.Map;

public class OrderUtil implements User {
    private final Order order;
    private Map<Integer,String> abilities = new HashMap<Integer,String>();

    public Map<Integer, String> getAbilities() {
        return abilities;
    }

    public void setAbilities(Map<Integer, String> abilities) {
        this.abilities = abilities;
    }

    public OrderUtil(Order order) {
        this.abilities.put(1,"Show menu");
        this.abilities.put(2,"Add dish to order");
        this.abilities.put(3,"Show your order");
        this.abilities.put(4,"How much is it?");
        this.abilities.put(5,"Add to current order");
        this.abilities.put(6,"Delete from current order");
        this.order = order;
    }

    public void showOrder(){
        if(order.getOrderList().isEmpty()){
            System.out.println("No order");
            System.out.println();
        }else {
            for (MenuItems items: order.getOrderList()) {
                System.out.println(items.getName()+" "+items.getCost()+"$");
            }
            System.out.println();
        }
    }

    public float showOrderCost(){
        int cost = 0;
        if (!order.getOrderList().isEmpty()) {
            for (MenuItems items : order.getOrderList()) {
                cost += items.getCost();
            }
        } else {
            System.out.println("No order");
            System.out.println();
        }
        return cost;
    }

    @Override
    public void showAbilities() {
        for (Map.Entry<Integer, String> entry : this.abilities.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }

    }

    @Override
    public void executeAbility(int indexOfAbility) {
        MenuUtil menuUtil=new MenuUtil(order.getMenu());
        if (indexOfAbility == 1) {
            //show menu

            menuUtil.viewMenu();
        }
        if (indexOfAbility == 2) {
            //add to order
            menuUtil.viewMenu();
            back:
            while (true) {
                int indexOfDish = Operations.inputNum();
                if (indexOfDish == 0) {
                    break;
                }
                if(indexOfDish<= Menu.getPositions().size())
                    order.getOrderList().add((MenuItems.menuItems(order.getMenu().getPositions().get(indexOfDish - 1).getName())));
                    continue back;
                }
            }
        if (indexOfAbility == 3) {
            //show order
            showOrder();

        }
        if (indexOfAbility == 4) {
            //cost
            System.out.println("Your order's cost is " + showOrderCost() + "$");
            System.out.println();
        }
        if (indexOfAbility == 5) {
            //add to current
            if (order.getOrderList().isEmpty()) {
                System.out.println("Yoy must create order");
                System.out.println();
            } else {
                showOrder();
                menuUtil.viewMenu();
                back:
                while (true) {
                    int indexOfDish = Operations.inputNum();
                    if (indexOfDish == 0) {
                        break;
                    } else {
                        order.getOrderList().add((MenuItems.menuItems(order.getMenu().getPositions().get(indexOfDish - 1).getName())));
                        continue back;
                    }
                }
            }

        }
        if (indexOfAbility == 6) {
            int num = 1;
            if (order.getOrderList().isEmpty()) {
                System.out.println("No order");
                System.out.println();
            } else {
                for (MenuItems items : order.getOrderList()) {
                    System.out.println(num + " " + items.getName() + " " + items.getCost() + "$");
                    num++;
                }
                System.out.println();
                int index = Operations.inputNum();
                if (index <= num && index > 0) {
                    order.getOrderList().remove(index - 1);
                } else {
                    System.out.println("Incorrect input");
                }

            }
        }
    }
}