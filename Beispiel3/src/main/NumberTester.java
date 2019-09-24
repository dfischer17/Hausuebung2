/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dfischer17
 */
public class NumberTester {
    private static String fileName;
    
    public interface NumberTest {
        boolean testNumber(int number);
    }
    
    public NumberTester(String fileName) {
        this.fileName = fileName;
    }
    
    public static void main(String[] args) {
        NumberTester n = new NumberTester("test.txt");
        n.run();
        
    }
        
    public void run() {
        try(final BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                line = br.readLine();
                System.out.println(line);
            }
            
        } catch (FileNotFoundException ex) {
            System.err.println("File not found!");
        } catch (IOException ex) {
            System.out.println("IO Exception!");
        }
    }
    
    public void setOddEvenTester(NumberTest oddTester) {
        
    }
    
    public void setPrimeTester(NumberTest primeTester) {
        
    }
    
    public void setPalindromTester(NumberTest palindromTester) {
      
    }
    
    public void testFile() {
        
    }
}
