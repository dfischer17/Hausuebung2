/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author Daniel Fischer
 */
public class Menu {
    private static Scanner input = new Scanner(System.in);
    
    public static void chooseCalcMenu() {
        System.out.println("Choose calculator:");
        System.out.println("1 - Relational calculator");
        System.out.println("2 - Vector calculator");
        System.out.println("3 - Complex calculator");
        System.out.println("4 - Exit program");        
    }
    
    public static double[] fetchNumbers() {
        double[] numberValues = new double[4];
        
        System.out.println("Enter number x a>");
        numberValues[0] = input.nextDouble();
        
        System.out.println("Enter number x b>");
        numberValues[1] = input.nextDouble();
        
        System.out.println("Enter number y a>");
        numberValues[2] = input.nextDouble();
        
        System.out.println("Enter number y b>");
        numberValues[3] = input.nextDouble();
        
        return numberValues;
    }
    
    public static void chooseOperationMenu() {
        System.out.println("Choose operation:");
        System.out.println("1 - add");
        System.out.println("2 - subtract");
        System.out.println("3 - multiply");
        System.out.println("4 - divide");
        System.out.println("5 - enter numbers again");        
    }
}

