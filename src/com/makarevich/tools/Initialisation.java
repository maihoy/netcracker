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

    private User  currentUser;

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
    public  static void menu(){
        createRestaurant();

        createCustomer();
        while (true){

            System.out.println("1. Waiter");
            System.out.println("2. Customer");
            System.out.println("3. Manager");
            System.out.println("0. Exit");
            back:
            switch (Operations.inputNum()){
                case 1:

                    while (true){
                        User currentUser= createWaiter();
                        currentUser.showAbilities();
                        System.out.println("0. Back");

                        switch (Operations.inputNum()){
                            case 1:
                                currentUser.executeAbility(1);
                                break ;
                            case 2:
                                currentUser.executeAbility(2);
                                break ;
                            case 0:
                                break back;
                        }
                    }
                case 2:
                    while (true) {
                        User currentUser = createCustomer();
                        currentUser.showAbilities();
                        System.out.println("0. Back");

                        switch (Operations.inputNum()) {
                            case 1:
                                Menu.viewMenu();
                                break;
                            case 2:
                                System.out.println(42);
                                break;
                            case 0:
                                break back;
                        }
                    }

                case 3:
                    while (true) {
                        User currentUser = createManager();
                        currentUser.showAbilities();
                        System.out.println("0. Back");

                        switch (Operations.inputNum()){
                            case 1:
                                currentUser.executeAbility(1);
                                break ;
                            case 0:
                        }
                    }
                case 0:
                    System.out.println("Finished!");
                    System.exit(0);

                default:
                    System.out.println("Try again...");

            }
        }
    }
}
