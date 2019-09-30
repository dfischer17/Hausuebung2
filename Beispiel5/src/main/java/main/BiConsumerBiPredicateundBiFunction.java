/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 *
 * @author Daniel Fischer
 * @param <T>
 * @param <U>
 */
public class BiConsumerBiPredicateundBiFunction<T, U> {
    
    static Predicate<Integer> isTen = n -> n == 10;
    static Consumer<Integer> printInteger = n -> System.out.println("The printed number is " + n);
    static Function<Integer, Integer> absolute = n -> Math.abs(n);
    
    static BiPredicate<Integer, Integer> sameValue = (n, k) -> n.equals(k); // Wieso zeigt funktioniert dieses Interface nicht?
    static BiConsumer<Integer, Integer> printMultipleInteger = (n, k) -> System.out.println("The printed numbers are " + n + " and " +k);
    static BiFunction<Integer, Integer, Integer> divide = (n, k) -> n / k;
    
    static BinaryOperator<Integer> multiply = (n, k) -> n * k;
    
    static UnaryOperator<Integer> identityOperator = UnaryOperator.<Integer>identity();
        
    public static void main(String[] args) {
        System.out.println("vergleich");        
        System.out.println("10 gleich 10 " + vergleich(isTen, 10));
        System.out.println("8 gleich 10 " + vergleich(isTen, 8));
        
        System.out.print("\n");
        
        System.out.println("anzeige");
        anzeige(printInteger, 5);
        
        System.out.print("\n");
        
        System.out.println("biVergleich");
        System.out.println("9 == 9 " + biVergleich(sameValue, 9, 9));
        System.out.println("9 == 7 " + biVergleich(sameValue, 9, 7));
        
        System.out.print("\n");
        
        System.out.println("biAnzeige");
        biAnzeige(printMultipleInteger, 5, 6);
        
        System.out.print("\n");
        
        System.out.println("berechnung");
        System.out.println("Das Absolut von -25 ist = " + berechnung(absolute, -25));
        
        System.out.print("\n");
                
        System.out.println("biBerechnung");
        System.out.println("5 / 2 = " + biBerechnung(divide, 5, 2));
        
        System.out.print("\n");
        System.out.print("\n");
        
        System.out.println("BinaryOperator");
        System.out.println("5 * 3 = " + berechnungmitBinaryOperator(multiply, 5, 3));
        
        System.out.print("\n");
        
        System.out.println("IdentityOperator");
        Integer result11 = berechnung(identityOperator, 5);
        anzeige((i) -> System.out.println("Der Wert des " + "UnaryOperators mit dem Argument " + i + " ist " + result11), 5);
    }
    
    static boolean vergleich(Predicate<Integer> predicate, Integer i) {
        return predicate.test(i);
    }
    
    static void anzeige(Consumer<Integer> consumer, Integer i) {
        consumer.accept(i);
    }
    
    static boolean biVergleich(BiPredicate<Integer, Integer> biPredicate, Integer i1, Integer i2) {
        return biPredicate.test(i2, i2);        
    }

    static void biAnzeige(BiConsumer<Integer, Integer> biConsumer, Integer i1, Integer i2) {
        biConsumer.accept(i1, i2);
    }
    
    static Integer biBerechnung(BiFunction<Integer,Integer, Integer> biFunction, Integer i1, Integer i2) {
        return biFunction.apply(i1, i2);
    }
    
    static Integer berechnung(Function<Integer, Integer> function, Integer i) {
        return function.apply(i);
    }
    
    static Integer berechnungmitBinaryOperator(BinaryOperator<Integer> binaryOperator, Integer i1, Integer i2) {
        return binaryOperator.apply(i1, i2);
    }
}
