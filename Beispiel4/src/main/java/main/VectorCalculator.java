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

    public VectorCalculator() {
        super(addLambda, subtractLambda, multiplyLambda, divideLambda);
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
        // Nur in 3D moeglich! Hier alternative mit Anahme dass die dritte Dimension Null betraegt
        double scalar = n.getA() * k.getB() - n.getB() * k.getA();
        
        return new Number(scalar, 1);
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
