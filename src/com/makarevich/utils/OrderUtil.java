package com.makarevich.utils;

import com.makarevich.beans.Menu;
import com.makarevich.beans.Order;
import com.makarevich.exceptions.EmptyOrderException;
import com.makarevich.interfaces.Entity;
import com.makarevich.enums.MenuItems;
import com.makarevich.tools.Initialisation;
import com.makarevich.tools.Operations;

import java.util.HashMap;
import java.util.Map;

public class OrderUtil implements Entity {
    private final Order order;
    private Order lastOrder;
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

    public void showOrder() throws  EmptyOrderException{
        if(order.getOrderList().isEmpty())  throw new EmptyOrderException("No order");

            for (MenuItems items: order.getOrderList()) {
                System.out.println(items.getName()+" "+items.getCost()+"$");
            }
            System.out.println();
    }

    public float showOrderCost() throws  EmptyOrderException{
        int cost = 0;
        if (order.getOrderList().isEmpty()) throw new EmptyOrderException("No order");

        for (MenuItems items : order.getOrderList()) {
            cost += items.getCost();

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
        MenuUtil menuUtil=new MenuUtil(Initialisation.restaurant().getMenu());
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
                if(indexOfDish<= Menu.getPositions().size()){
                    order.getOrderList().add((MenuItems.menuItems(Menu.getPositions().get(indexOfDish - 1).getName())));
                    continue back;
                }else {
                    System.out.println("Input less or equals to "+Menu.getPositions().size());
                    continue back;
                }
            }

            Initialisation.order=order;
            Initialisation.orders.add(order);
            }
        if (indexOfAbility == 3) {
            //show order
            try {
                showOrder();
            } catch (EmptyOrderException e) {
                System.out.println("No order");
                System.out.println();
            }

        }
        if (indexOfAbility == 4) {
            //cost
            try {
                System.out.println("Your order's cost is " + showOrderCost() + "$");
            } catch (EmptyOrderException e) {
                System.out.println("No order");
            }
            System.out.println();
        }
        if (indexOfAbility == 5) {
            //add to current
            if (order.getOrderList().isEmpty()) {
                System.out.println("You must create order");
                System.out.println();
            } else {
                try {
                    showOrder();
                } catch (EmptyOrderException e) {
                    System.out.println("No order");
                }
                menuUtil.viewMenu();
                back:
                while (true) {
                    int indexOfDish = Operations.inputNum();
                    if (indexOfDish == 0) {
                        break;
                    } else {
                        Initialisation.restaurant().getMenu();
                        order.getOrderList().add((MenuItems.menuItems(Menu.getPositions().get(indexOfDish - 1).getName())));
                        continue back;
                    }
                }
            }

        }
        if (indexOfAbility == 6) {
            int num = 1;
            if (order.getOrderList().isEmpty()) {
                System.out.println("You must create order");
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