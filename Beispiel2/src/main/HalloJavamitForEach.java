/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dfischer17
 */
public class HalloJavamitForEach {

    /**
     * @param args the command line arguments
     */
    private static List<String> myList = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println("for-each List Interface");
        myList.add("Apfel");
        myList.add("Birne");
        myList.add("Banane");                     
        myList.forEach((str) -> System.out.println(str));
        
        System.out.println("for-each vereinfachte for-Schleife");
        for(String string: myList) {
            System.out.println(string);
        }
        
        System.out.println("for-each zwei Doppelpunkte");
        myList.forEach(System.out::println);
    }
    
}
