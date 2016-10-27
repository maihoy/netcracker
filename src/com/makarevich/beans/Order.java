package com.makarevich.beans;

import com.makarevich.enums.MenuItems;
import com.makarevich.tools.Operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by j on 19.10.16.
 */
public class Order implements User{
    private Map<Integer,String> abilities = new HashMap<Integer,String>();
    public List<MenuItems> orderList = new ArrayList<MenuItems>();
    public static int orderCount;
    private int orderNum;
    private Customer customer;

    private Menu menu=new Menu();

    public List<MenuItems> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<MenuItems> orderList) {
        this.orderList = orderList;
    }



    public Order(Customer customer) {

        this.abilities.put(1,"Show menu");
        this.abilities.put(2,"Add dish to order");
        this.abilities.put(3,"Show your order");
        this.abilities.put(4,"How much is it?");
        this.abilities.put(5,"Add to current order");
        this.abilities.put(6,"Delete from current order");
        orderCount++;
        orderNum=orderCount;
        this.customer= customer;
    }

    public void showOrder(){
        if(orderList.isEmpty()){
            System.out.println("No order");
            System.out.println();
        }else {
            for (MenuItems items: orderList) {
                System.out.println(items.getName()+" "+items.getCost()+"$");
            }
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return orderList != null ? orderList.equals(order.orderList) : order.orderList == null;


    }

    @Override
    public int hashCode() {
        return orderList != null ? orderList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Order:" +getOrderList();
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
            //show menu
            menu.viewMenu();
        }
        if (indexOfAbility==2) {
            //add to order
            menu.viewMenu();
            back:
            while (true) {
                int indexOfDish = Operations.inputNum();
                if (indexOfDish == 0) {
                    break;
                } else {
                    orderList.add((MenuItems.menuItems(menu.getPositions().get(indexOfDish-1).getName())));
                    continue back;
                }
            }
        }
        if (indexOfAbility==3){
            //show order
            showOrder();

        }
        if (indexOfAbility==4){
            //cost
            int cost = 0;
            if(orderList.isEmpty()){
                System.out.println("No order");
                System.out.println();
            }else {
                for (MenuItems items: orderList) {
                    cost+=items.getCost();
                }
                System.out.println("Your order's cost is "+cost+"$");
                System.out.println();
            }
        }
        if (indexOfAbility==5){
            //add to current
            if(orderList.isEmpty()){
                System.out.println("Yoy must create order");
                System.out.println();
            }else {
            showOrder();
            menu.viewMenu();
            back:
            while (true) {
                int indexOfDish = Operations.inputNum();
                if (indexOfDish == 0) {
                    break;
                }
                else {
                    orderList.add((MenuItems.menuItems(menu.getPositions().get(indexOfDish-1).getName())));
                    continue back;
                }
            }
        }

        }
        if (indexOfAbility==6){
            int num=1;
            if(orderList.isEmpty()){
                System.out.println("No order");
                System.out.println();
            }else {
                for (MenuItems items: orderList) {
                    System.out.println(num+" "+items.getName()+" "+items.getCost()+"$");
                    num++;
                }
                System.out.println();
                int index=Operations.inputNum();
                if (index<=num && index>0){
                    orderList.remove(index-1);
                }else {
                    System.out.println("Incorrect input");
                }

            }
        }
    }
}
