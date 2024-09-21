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

    private static List<String> sortingList(List<String> list){
        List<String> sortedList = new ArrayList<>(list);
        // reference method al metodo de instancia compareToIgnoreCase
        sortedList.sort(String::compareToIgnoreCase);
        return sortedList;
    }

    // method reference to constructor
    private static Apple createAppleV1(String name, Function<String, Apple> f){
        return f.apply(name);
    }
    
    private static List<Apple> mapCreateApple(List<String> appleNames, Function<String, Apple> f){
        List<Apple> apples = new ArrayList<>();
        for(String name : appleNames){
            apples.add(f.apply(name));
        }
        return apples;
    }

    private static Apple createAppleV2(String name, int weight, BiFunction<String, Integer, Apple> f){
        return f.apply(name, weight);
    }

    private static Apple createAppleV3(String name, int weight, Color color, TriFunction<String, Integer, Color, Apple> f){
        return f.apply(name, weight, color);
    }


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
        System.out.println(sortingList(str));;

        Apple apple = createAppleV1("apple", Apple::new);
        System.out.println(apple);

        List<String> names = Arrays.asList("apple1", "apple2", "apple3");
        List<Apple> apples = mapCreateApple(names, Apple::new);
        System.out.println(apples);

        Apple apple2 = createAppleV2("Manzana del campo", 55, Apple::new);
        apple2.setColor(Color.RED);
        System.out.println(apple2);

        Apple apple3 = createAppleV3("Manzana del rio", 85, Color.GREEN, Apple::new);
        System.out.println(apple3);
    }
}
