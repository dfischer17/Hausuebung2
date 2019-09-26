/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Daniel Fischer
 */
public class Main {

    public static void main(String[] args) {
        AbstractCalculator calculator = null;
        double[] numbers;
        Number result = null;

        // Gewuenschten Taschenrechner auswaehlen
        switch (Menu.chooseCalcMenu()) {
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

            default:
                System.err.println("Ungültige Eingabe!");
                break;
        }

        // Zahlenwerte einlesen
        numbers = Menu.fetchNumbers();

        // Operation auswaehlen
        switch (Menu.chooseOperationMenu()) {
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
            
            default: 
                System.err.println("Noch nicht implementiert!");
                break;
        }
        
        System.out.println("Solution:");
        System.out.println(result);
    }
}
