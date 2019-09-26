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
public class RationalCalculator extends AbstractCalculator {

    public RationalCalculator(CalculationOperation add, CalculationOperation subtract, CalculationOperation multiply, CalculationOperation divide) {
        super(add, subtract, multiply, divide);
    }
                
    public static void main(String[] args) {
        // multiply, divide
        
        RationalCalculator rCalculator = new RationalCalculator(addLambda, subtractLambda, multiplyLambda, divideLambda);
        Number number1 = new Number(21, 18);
        Number number2 = new Number(3, 5);
        
        System.out.println(rCalculator.divide(number1, number2).toString());
        
    }
    // multiplizieren und dividieren funktioniert!
    
    static CalculationOperation addLambda = (n, k) -> {
        return null;
    };
    
    static CalculationOperation subtractLambda = (n, k) -> {
       double kleinsterTeiler = n.getB() * k.getB();
       
       double zaehlerN = (kleinsterTeiler / n.getB()) * n.getA();
       double zaehlerK = (kleinsterTeiler / n.getB()) * n.getA();
       
       return new Number(zaehlerN - zaehlerK, kleinsterTeiler);
    };
    
    static CalculationOperation multiplyLambda = (n, k) -> {
       double top = n.getA() * k.getA();
       double bottom = n.getB() * k.getB();
       
       return new Number(top, bottom);
    };
    
    static CalculationOperation divideLambda = (n, k) -> {
       double top = n.getA() / k.getA();
       double bottom = n.getB() / k.getB();
       
       return new Number(top, bottom);
    };

    @Override
    public Number add(Number a, Number b) {
        return addLambda.calc(a, b);
    }

    @Override
    public Number subtract(Number a, Number b) {
        return subtractLambda.calc(a, b);
    }

    @Override
    public Number multiply(Number a, Number b) {
        return multiplyLambda.calc(a, b);
    }

    @Override
    public Number divide(Number a, Number b) {
        return divideLambda.calc(a, b);
    }
}
