package ch05;

import ch04.Dish;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/*
 * Los metodos mas comunes que convierten un Stream<T> a un Stream especializado son mapToInt(), mapToDouble(), mapToLong()
 */
public class GNumericStream {
    /*
     * El codigo de abajo tiene un problema. detras de escena, cada elemento del stream es Integer y para retornar un int
     * el valor integer debe aplicarse un unboxing que es algo costoso. La solucion a esto es utilizar un Stream especializado
     */
    private static void getMenuCalories(List<Dish> menu){
        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("Calories in menu: " + calories);
    }

    /* Stream primitivos especializados */
    // Mapping to numeric Stream
    private static void getCaloriesInMenu(List<Dish> menu){
        // convertimos la lista de platos en un Strean<Dish>
        int calories = menu.stream()
                // retornamos in IntStream
                .mapToInt(Dish::getCalories)
                // call .sum() definido en la clase IntStream
                .sum();
        System.out.println("Total Calories in menu: " + calories);
    }

    // Valores por defecto: OptionalInt
    private static void getMaxCaloryDish(List<Dish> menu){
        OptionalInt maxCaloryDish = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();

        int max = maxCaloryDish.orElse(1);
        System.out.println("Max Calories in menu: " + max);
    }

    // Rangos numericos
    private static void getNumberFromRange(){
        // representamos el rango 1-100
        // si se emplea IntStream.range(1,100) retorna 49, porque range es excluyente.
        IntStream evenNums = IntStream.rangeClosed(1, 100)
                // stream de numero pares de 1 a 100
                .filter(n -> n % 2 == 0);
        // count() procesamos el stream even numbers
        System.out.println(evenNums.count()); // print 50, es la cantidad de numeros pares entre 1 - 100
    }


    public static void main(String[] args) {
        getNumberFromRange();
        //getMaxCaloryDish(Dish.menu);
        //getCaloriesInMenu(Dish.menu);
        //getMenuCalories(Dish.menu);
    }
}
