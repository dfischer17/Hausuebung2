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
        n.testFile();
    }

    public void testFile() {

        int amountTestCases = 0;
        String[] temp;
        int operation;
        int value;

        // Funktionale Interfaces implementieren
        setOddEvenTester((n) -> (n % 2 == 0));
        setPrimeTester((n) -> {
            if (n < 2) {
                return false;
            } else {
                for (int i = 2; i < n; i++) {
                    if (n % i == 0) {
                        return false;
                    }
                }
            }
            return true;
        });

        setPalindromTester((n) -> {
            String intStr = String.valueOf(n); 
            return intStr.equals(new StringBuilder(intStr).reverse().toString());
        });

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
                operation = Integer.parseInt(temp[0]);
                value = Integer.parseInt(temp[1]);

                // Entsprechenden Befehl ausfuehren
                switch (operation) {
                    case 1:
                        // isEven
                        if (isEven.testNumber(value)) {
                            System.out.println("EVEN");
                        } else {
                            System.out.println("ODD");
                        }
                        break;

                    case 2:
                        // isPrime
                        if (isPrime.testNumber(value)) {
                            System.out.println("PRIME");
                        } else {
                            System.out.println("NO PRIME");
                        }
                        break;

                    case 3:
                        // isPalindrom
                        if (isPalindrom.testNumber(value)) {
                            System.out.println("PALINDROM");
                        } else {
                            System.out.println("NO PALINDROM");
                        }
                        break;

                    default:
                        System.err.println("Ungueltige Befehlnummer!");
                }
                amountTestCases--;
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Datei nicht gefunden!");
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
}
