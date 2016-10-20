package com.makarevich;

/**
 * Created by j on 20.10.16.
 */
public class Initialization {
    public static StringBuffer inputFolder = new StringBuffer();
    public static StringBuffer outputFolder = new StringBuffer();


    public  static void menu(){
        while (true){
            System.out.println("1. Waiter");
            System.out.println("2. Customer");
            System.out.println("0. Exit");

            switch (Operations.inputNum()){
                case 1:
                    while (true){
                        System.out.println("1. Take order");
                        System.out.println("2. Create restaurant bill");
                        System.out.println("0. Back");

                        switch (Operations.inputNum()){
                            case 1:
                                System.out.println();
                        }
                    }
                case 2:
                    System.out.println("1. Create order");
                    System.out.println("2. Pay");
                    System.out.println("0. Back");

                    switch (Operations.inputNum()){
                        case 1:
                           //System.out
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
