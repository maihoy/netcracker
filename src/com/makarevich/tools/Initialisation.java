package com.makarevich.tools;

import com.makarevich.beans.*;
import com.makarevich.enums.MenuItems;
import com.makarevich.enums.Rating;

import java.util.*;

/**
 * Created by j on 20.10.16.
 */
public class Initialisation {
    public static List<Order> orders;

    private Initialisation(){

    }

    private static User  currentUser;

    public  static Manager createManager(){
        Manager manager1 = new Manager("Imja","Familija",new GregorianCalendar(1976,3,12));
        return manager1;
    }
    public static Waiter createWaiter(){
        Waiter waiter1 = new Waiter("John","Smith",new GregorianCalendar(1992 ,Calendar.DECEMBER, 20), (float) 36.1);
        return waiter1;
    }
    public static Restaurant createRestaurant(){
        Restaurant myRest = new Restaurant("Owful restaurant", Rating.TWO_STAR, Menu.getPositions());
        myRest.addWaiters(createWaiter());
        return myRest ;
    }
    public static Customer createCustomer(){
        Customer customer1 = new Customer("Piter","Parker",new GregorianCalendar(1989,Calendar.MARCH,6),(float) 195.7);
        return customer1;
    }

    public static void newtStep(User currentUser){

        while(true){

            currentUser.showAbilities();
            System.out.println("0. Back");
            int answer = Operations.inputNum();
            if(answer == 0){
                break;
            }else{
                currentUser.executeAbility(answer );
            }
        }
    }

    public  static void menu(){

        System.out.println("1. Waiter");
        System.out.println("2. Customer");
        System.out.println("3. Manager");
        System.out.println("0. Exit");
        switch (Operations.inputNum()){

            case 1:
                newtStep(createWaiter());
                break;
            case 2:
                newtStep(createCustomer());
                break;
            case 3:
                newtStep(createManager());
                break;
            case 0:
                System.out.println("Finished!");
                System.exit(0);
            default:
                System.out.println("Try again...");
        }


    }
}
