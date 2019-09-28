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
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AbstractCalculator calculator = null;
        double[] numbers;
        int chosenCaluclator = 0;
        int chosenOperation = 0;
        Number result = null;

        while (true) {
            do {
                // Menue Taschenrechner auswaehlen
                Menu.chooseCalcMenu();

                // auswaehlen
                chosenCaluclator = input.nextInt();

                // pruefen 
            } while (!(chosenCaluclator > 0 && chosenCaluclator < 5));

            // erstellen
            calculator = createCalculator(chosenCaluclator);

            // Zahlenwerte einlesen
            numbers = Menu.fetchNumbers();

            // Operation auswaehlen        
            do {
                Menu.chooseOperationMenu();
                // auswaehlen            
                chosenOperation = input.nextInt();

                // Moeglichkeit Werte erneut einzugeben
                if (chosenOperation == 5) {
                    numbers = Menu.fetchNumbers();
                }

                // pruefen 
            } while (!(chosenOperation > 0 && chosenOperation < 6) || chosenOperation == 5);

            // Ergebnis anzeigen
            result = getResult(calculator, chosenOperation, numbers);
            System.out.println("Solution:");
            System.out.println("a = " + result.getA() + "\n" + "b = " + result.getB() + "\n");
        }
    }

    private static AbstractCalculator createCalculator(int choice) {

        AbstractCalculator calculator = null;

        switch (choice) {
            case 1:
                calculator = new RationalCalculator();
                break;

            case 2:
                calculator = new VectorCalculator();
                break;

            case 3:
                calculator = new ComplexCalculator();
                break;

            case 4:
                System.exit(0);
                break;
        }
        return calculator;
    }

    private static Number getResult(AbstractCalculator calculator, int operation, double[] numbers) {

        Number result = null;

        switch (operation) {
            case 1:
                result = calculator.add(new Number(numbers[0], numbers[1]), new Number(numbers[2], numbers[3]));
                break;
            case 2:
                result = calculator.subtract(new Number(numbers[0], numbers[1]), new Number(numbers[2], numbers[3]));
                break;
            case 3:
                result = calculator.multiply(new Number(numbers[0], numbers[1]), new Number(numbers[2], numbers[3]));
                break;
            case 4:
                result = calculator.divide(new Number(numbers[0], numbers[1]), new Number(numbers[2], numbers[3]));
                break;
        }
        return result;
    }
}
