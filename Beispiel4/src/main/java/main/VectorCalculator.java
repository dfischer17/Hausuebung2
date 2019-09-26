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
public class VectorCalculator extends AbstractCalculator {

    public VectorCalculator(CalculationOperation add, CalculationOperation subtract, CalculationOperation multiply, CalculationOperation divide) {
        super(add, subtract, multiply, divide);
    }
                
    public static void main(String[] args) {
        VectorCalculator v = new VectorCalculator(addLambda, subtractLambda, multiplyLambda, divideLambda);
        System.out.println(v.divide(new Number(5, 1), new Number(5, 6)).toString());
    }
    
    static CalculationOperation addLambda = (n, k) -> {
        double top = n.getA()  + k.getA();
        double bottom = n.getB() + k.getB();
        
        return new Number(top, bottom);
    };
    
    static CalculationOperation subtractLambda = (n, k) -> {
        double top = n.getA()  - k.getA();
        double bottom = n.getB() - k.getB();
        
        return new Number(top, bottom);
    };
    
    static CalculationOperation multiplyLambda = (n, k) -> {
        // Nur in 3D moeglich!
        System.err.println("Nur in 3D moeglich!");
        return null;
    };
    
    static CalculationOperation divideLambda = (n, k) -> {
       // Skalarprodukt
       double top = n.getA() / n.getB() * k.getA();
       double bottom = n.getA() / n.getB() * k.getB();
       
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
