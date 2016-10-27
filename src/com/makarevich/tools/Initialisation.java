package com.makarevich.tools;

import com.makarevich.beans.*;
import com.makarevich.enums.Rating;

import java.util.*;


public class Initialisation {
    public static List<Order> orders;
    private static User  currentUser;

    private Initialisation(){

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
                    Waiter waiter =new Waiter();
                    newtStep(waiter);
                    break;
                case 2:
                    Customer customer =new Customer();
                    newtStep(customer);
                    break;
                case 3:
                    Manager manager= new Manager();
                    newtStep(manager);
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
