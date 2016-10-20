package com.makarevich;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by j on 20.10.16.
 */
public class Operations {
    public static  Scanner input= new Scanner(System.in);
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
}
