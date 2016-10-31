package com.makarevich.tools;

import com.makarevich.beans.*;
import com.makarevich.beans.Manager;
import com.makarevich.enums.Rating;
import com.makarevich.interfaces.Entity;
import com.makarevich.utils.CustomerUtil;
import com.makarevich.utils.ManagerUtil;
import com.makarevich.utils.WaiterUtil;

import java.util.*;


public class Initialisation {
    public static List<Order> orders = new ArrayList<Order>();
    public static Order order;
    private static Entity currentEntity;

    private Initialisation(){

    }

    public static Restaurant restaurant(){
        Restaurant restaurant= new Restaurant("Restaurant", Rating.FOUR_STAR,Menu.getPositions());
        restaurant.addWaiters(new Waiter("Nana","Lana",new GregorianCalendar(1990,2,3),(float)2.4));
        return restaurant;

    }

    public static Waiter waiter =restaurant().getWaiters().iterator().next();

    public static void newtStep(Entity currentEntity){
        while(true){

            currentEntity.showAbilities();
            System.out.println("0. Back");
            int answer = Operations.inputNum();
            if(answer == 0){
                break;
            }else{
                currentEntity.executeAbility(answer );
            }
        }
    }

    public  static void menu(){
       orders= Operations.readObject("Orders");
        while (true) {
            System.out.println("1. Waiter");
            System.out.println("2. Customer");
            System.out.println("3. Manager");
            System.out.println("0. Exit");
            switch (Operations.inputNum()) {

                case 1:

                    newtStep(new WaiterUtil(waiter));
                    waiter.setOrders(orders);
                    break;
                case 2:
                    Customer customer =new Customer();
                    newtStep(new CustomerUtil(customer));
                    waiter.setOrders(orders);
                    break;
                case 3:
                    Manager manager= new Manager();
                    newtStep(new ManagerUtil(manager));
                    break;
                case 0:
                    Operations.writeObject(orders,"Orders");
                    System.out.println("Finished!");
                    System.exit(0);
                default:
                    System.out.println("Try again...");
            }

        }
    }
}
