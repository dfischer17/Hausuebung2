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
        return null;
    };
    
    static CalculationOperation subtractLambda = (n, k) -> {
        return null;
    };
    
    static CalculationOperation multiplyLambda = (n, k) -> {
        return null;
    };
    
    static CalculationOperation divideLambda = (n, k) -> {
       return null;
    };

    public ComplexCalculator() {
        super(addLambda, subtractLambda, multiplyLambda, divideLambda);
    }

    @Override
    public Number add(Number a, Number b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Number subtract(Number a, Number b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Number multiply(Number a, Number b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Number divide(Number a, Number b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
