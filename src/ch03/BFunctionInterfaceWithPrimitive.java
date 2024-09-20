package ch03;

import java.util.function.IntPredicate;

/*
 * Las interfaces especializadas se agregaron para evitar el autoboxing cuando las entradas o salidas son tipos
 * de datos primitivos.
 */
public class BFunctionInterfaceWithPrimitive {

    private static boolean evenNumber(int value, IntPredicate p){
        return p.test(value);
    }

    private static boolean oddNumber(int value, IntPredicate p){
        return p.test(value);
    }

    public static void main(String[] args) {
        boolean isEvenNumber = evenNumber(10, (n) -> n % 2 == 0);
        System.out.println("10 is even? " + isEvenNumber);

        boolean isOddNumber = oddNumber(8, (n) -> n % 2 == 1);
        System.out.println("8 is odd? " + isOddNumber);
    }
}
