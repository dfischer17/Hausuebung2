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
    private NumberTest isEven;
    private NumberTest isPrime;
    private NumberTest isPalindrom;

    public NumberTester(String fileName) {
        this.fileName = fileName;
    }

    public static void main(String[] args) {
        NumberTester n = new NumberTester("test.txt");
        n.run();

    }

    public void run() {

        int amountTestCases = 0;
        String[] temp;

        try (final BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Erste Zeile einlesen
            String line = br.readLine();

            // Wert in erster Zeile (Anzahl der Operationen) einlesen
            amountTestCases = Integer.parseInt(line);

            while (amountTestCases > 0) {
                // Befehl und Zahl einlesen
                line = br.readLine();

                // Befehl und Zahl trennen
                temp = line.split(" ");
                amountTestCases--;
                
                // temp
                this.setOddEvenTester((n) -> (n % 2 == 0));
                boolean here = isEven.testNumber(4);

                // Entsprechenden Befehl ausfuehren
                switch (Integer.valueOf(temp[0])) {
                    case 1:
                        /* isEven
                        if (this.isEven.testNumber(Integer.valueOf(temp[1]))) {

                        }
                        */
                        this.setOddEvenTester((n) -> (n % 2 == 0));
                        //boolean here = isEven.testNumber(4);
                        break;

                    case 2:
                        // isPrime
                        break;

                    case 3:
                        // isPalindrom
                        break;

                    default:
                        System.err.println("Ungültige Befehlnummer");
                }
            }

        } catch (FileNotFoundException ex) {
            System.err.println("File not found!");
        } catch (IOException ex) {
            System.out.println("IO Exception!");
        }
    }

    public void setOddEvenTester(NumberTest oddTester) {
        this.isEven = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.isPrime = primeTester;
    }

    public void setPalindromTester(NumberTest palindromTester) {
        this.isPalindrom = palindromTester;
    }

    public void testFile() {

    }
}
