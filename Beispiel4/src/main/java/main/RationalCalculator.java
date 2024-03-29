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

    public RationalCalculator() {
        super(addLambda, subtractLambda, multiplyLambda, divideLambda);
    }
                            
    static CalculationOperation addLambda = (a, b) -> {
        return new Number(a.getA() * b.getB() + b.getA() *a.getB(), a.getB() * b.getB());
    };
    
    static CalculationOperation subtractLambda = (a, b) -> {
       return new Number(a.getA() * b.getB() - b.getA() * a.getB(), a.getB() * b.getB());
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
