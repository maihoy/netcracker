package com.makarevich.tools;

import com.makarevich.beans.*;
import com.makarevich.enums.Rating;

import java.util.*;


public class Initialisation {
    public static List<Order> orders;

    private Initialisation(){

    }

    private static User  currentUser;

    public static Manager createManager(){
        return  new Manager("Imja","Familija",new GregorianCalendar(1976,3,12));
    }
    public static Waiter createWaiter(){
        return new Waiter("John","Smith",new GregorianCalendar(1992 ,Calendar.DECEMBER, 20), (float) 36.1);
    }
    public Restaurant createRestaurant(){
        Restaurant myRest = new Restaurant("Owful restaurant", Rating.TWO_STAR, Menu.getPositions());
        myRest.addWaiters(createWaiter());
        return myRest ;
    }
    public static Customer createCustomer(){
        return new Customer("Piter","Parker",new GregorianCalendar(1989,Calendar.MARCH,6),(float) 195.7);
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
        while (true) {
            System.out.println("1. Waiter");
            System.out.println("2. Customer");
            System.out.println("3. Manager");
            System.out.println("0. Exit");
            switch (Operations.inputNum()) {

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
}
