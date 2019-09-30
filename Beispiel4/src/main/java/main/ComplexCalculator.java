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
public class ComplexCalculator extends AbstractCalculator {

    static CalculationOperation addLambda = (n, k) -> {
        double real = n.getA() + k.getA();
        double imaginary = n.getB() + k.getB();
        return new Number(real, imaginary);
    };

    static CalculationOperation subtractLambda = (n, k) -> {
        double real = n.getA() - k.getA();
        double imaginary = n.getB() - k.getB();
        return new Number(real, imaginary);
    };

    static CalculationOperation multiplyLambda = (n, k) -> {
        double real = (n.getA() * k.getA()) - (n.getB() * k.getB());
        double imaginary = (n.getA() * k.getB()) + (n.getB() * k.getA());
        return new Number(real, imaginary);
    };

    static CalculationOperation divideLambda = (n, k) -> {
        double real = (((n.getA() * k.getA() + (n.getB() * k.getB())) / (Math.pow(k.getA(), 2) + Math.pow(k.getB(), 2))));
        double imaginary = (((n.getA() * k.getB()) - (n.getB() * k.getA())) / (Math.pow(k.getA(), 2) + Math.pow(k.getB(), 2)));
        return new Number(real, imaginary);
    };

    public ComplexCalculator() {
        super(addLambda, subtractLambda, multiplyLambda, divideLambda);
    }

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
