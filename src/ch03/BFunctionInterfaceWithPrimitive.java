package ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/*
 * Las interfaces especializadas se agregaron para evitar el autoboxing cuando las entradas o salidas son tipos
 * de datos primitivos.
 */
public class BFunctionInterfaceWithPrimitive {

    /*
     * Aplicando el lambda type checking
     * 1. la funcion evenNumber recibe un objeto IntPredicate<int> a esto se le conoce como target type por lo que el contexto de la funcion
     *    evenNumber es IntPredicate
     * 2. la funcion IntPredicate<int> define un solo metodo abstracto test(int)
     * 3. el metodo test(int) tiene un function descriptor que acepta un int y retorna un boolean
     * 4. Cualquier requerimiento a la funcion evenNumber() debe cumplir estos requerimientos
     */
    private static boolean evenNumber(int value, IntPredicate p){
        return p.test(value);
    }

    private static boolean oddNumber(int value, IntPredicate p){
        return p.test(value);
    }

    // lambda con variables locales
    private static void printValue(int value, IntConsumer consumer){
        consumer.accept(value);
    }

    private static List<String> comparing(List<String> list, ){}


    public static void main(String[] args) {
        // el compilador hace una inferencia del tipo para el parametro n, su tipo es int
        boolean isEven = evenNumber(10, (n) -> n % 2 == 0);
        System.out.println("10 is even? " + isEven);

        boolean isOdd = oddNumber(8, (n) -> n % 2 == 1);
        System.out.println("8 is odd? " + isOdd);

        int valueToPrint = 1000;
        printValue(valueToPrint, (value) -> System.out.println(value));

        valueToPrint = 500;
        // usando method reference
        printValue(valueToPrint, System.out::println);

        List<String> str = Arrays.asList("a","b","A","B");
        str.sort(String::compareToIgnoreCase);
        System.out.println(str);
    }
}
