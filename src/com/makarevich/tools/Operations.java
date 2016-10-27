package com.makarevich.tools;

import com.makarevich.beans.Customer;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by j on 20.10.16.
 */
public class Operations {
    public static  Scanner input= new Scanner(System.in);

    public  static Customer createCustomer(){
        Customer customer = new Customer();
        System.out.print("First name: ");
        customer.setFirstName(Operations.inputString());
        System.out.print("Last name: ");
        customer.setLastName(Operations.inputString());
        customer.setBirthDate(Operations.inputBirthDate());
        System.out.print("Money: ");
        customer.setMoney(Operations.inputFloat());
        System.out.println();
        return customer;
    }

    public  static int inputNum(){
        int num = -1;
        while (num<0) {
            try {
                input = new Scanner(System.in);
                num = input.nextInt();
                if (num >= 0) {
                    return num;
                } else {
                    System.out.println("Must be non-negative");
                    continue;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Must be a number");
                continue;
            }
        }
        return 0;
    }

    public static String inputString(){
        input = new Scanner(System.in);
        return input.next();
    }

    public static boolean isLeapYear(int year){
        if(year % 4 == 0){
            if((year % 100 != 0) || (year % 400 == 0)){
                return true;
            }
            else{
                return true;
            }
        }
        return false;
    }

    public static GregorianCalendar inputBirthDate(){
        GregorianCalendar date = new GregorianCalendar();

        System.out.print("Year: ");
        int year = inputNum();
        while((year < 1910) || (year > date.get(Calendar.YEAR))){
            System.out.println("Incorrect input");
            System.out.print("Year: ");
            year = inputNum();
        }
        System.out.print("Month: ");
        int month = inputNum();
        while((month < 1) || (month > 12)){
            System.out.println("Incorrect input");
            System.out.print("Month: ");
            month = inputNum();
        }

        int dayUpLimit = 0;
        switch(month-1){
            case Calendar.JANUARY:
            case Calendar.MARCH:
            case Calendar.MAY:
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.OCTOBER:
            case Calendar.DECEMBER:
                dayUpLimit = 31;
                break;

            case Calendar.APRIL:
            case Calendar.JUNE:
            case Calendar.SEPTEMBER:
            case Calendar.NOVEMBER:
                dayUpLimit = 30;
                break;

            case Calendar.FEBRUARY:
                if (isLeapYear(year)) {
                    dayUpLimit = 28;
                } else {
                    dayUpLimit = 29;
                }
        }

        System.out.print("Day: ");
        int day = inputNum();
        while((day < 1) || (day > dayUpLimit)){
            System.out.println("Incorrect input");
            System.out.print("Day: ");
            day = inputNum();
        }

        date.set(year, month-1, day-1);
        return date;
    }

    public  static float inputFloat(){
        float num = -1;
        while (num<0) {
            try {
                input = new Scanner(System.in);
                num = input.nextFloat();
                if (num >= 0) {
                    return num;
                } else {
                    System.out.println("Must be non-negative");
                    continue;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Must be a number. Try use ,");
                continue;
            }
        }
        return 0;
    }

}
