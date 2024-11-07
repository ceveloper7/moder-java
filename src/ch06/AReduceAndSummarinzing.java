package ch06;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

/**
 * Clase Collectors: usamos la clase Collectors para realizar distintas operaciones con un stream como, contar elementos, encontrar
 * el maximo y minimo valor de una propiedad numerica y calcular la suma y el promedio.
 * Por medio de Collectors podemos reducir un stream en un solo valor.
 *
 *
 
 *
 * */
public class AReduceAndSummarinzing {

    private static void countDishes(List<Dish> menu){
        long dishesCount = menu.stream().count();
        System.out.println("Dishes count: " + dishesCount);
    }

    /*
     * Calcular el valor maximo y minimo en un Stream con Collectors.maxBy | Collectors.minBy que son operaciones de reduccion.
     */

    private static void getHighestCalorieDishes(List<Dish> menu){
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        // optional puede o no puede contener un dish como respuesta
        Optional<Dish> mostCalorieDish = menu.stream()
                .collect(maxBy(dishCaloriesComparator));
        System.out.println(mostCalorieDish);
    }

    /*
     * Summarization: Collectors.summingInt(), summingLong(), summingDouble() retornar un valor int, long y double respectivamente.
     * 1. Cada plato del menu es mapeado en su numero de calorias.
     * 2. Las calorias se agregan a un acumulador que inicia en 0
     */
    private static void getTotalCaloriesInMenu(List<Dish> menu){
        int totalCalories = menu.stream()
                .collect(summingInt(Dish::getCalories));
        System.out.println("Total calories in menu: " + totalCalories);
    }

    private static void getAverageCaloriesInMenu(List<Dish> menu){
        double avgCalories = menu.stream()
                .collect(averagingInt(Dish::getCalories));
        System.out.println("Average calories in menu: " + avgCalories);
    }

    /*
     * Obtener en un operacion informacion estadistica como: contar, sumar, valor minimo, promedio, valor maximo
     */
    private static void getStatisticsInfo(List<Dish> menu){
        IntSummaryStatistics statistics = menu.stream()
                .collect(summarizingInt(Dish::getCalories));
        System.out.println(statistics);
    }

    /*
     * Uniendo Strings
     */
    private static void getAllDishesName(List<Dish> menu){
        String shortMenu = menu.stream()
                .map(Dish::getName)
                .collect(joining(", "));
        System.out.println(shortMenu);
    }

    public static void main(String[] args) {
        getAllDishesName(Dish.menu);
        //getStatisticsInfo(Dish.menu);
        //getAverageCaloriesInMenu(Dish.menu);
        //getTotalCaloriesInMenu(Dish.menu);
        //getHighestCalorieDishes(Dish.menu);
        //countDishes(Dish.menu);
    }
}
