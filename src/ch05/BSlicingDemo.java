package ch05;

import ch04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/*
 * Segmentacion Stream. Una segmentacion consiste en seleccionar y omitir elementos de un stream de distintas maneras.
 *
 * takeWhile() te permite cortar cualquier stream (incluso uno infinito)
 * usano un predicado. se detiene una vez que ha encontrado un elemento que no coincide, es decir,
 * recorre los elementos de un stream hasta que la condicion especificada deje de ser verdadera y luego detiene el procesamiento.
 *
 * dropWhile() es el complemento de takeWhile(). dropWhile() va iterando sobre los elementos
 * y eliminando los que cumplan la condicion hasta que encuentre uno que no la cumple. A partir de dicho elemento, el resto se mantiene
 * en el stream.
 *
 * limit(n) retorna un stream que no es mayor al numero dado o especificado.
 * skip(n) retorna una stream que descarta los primeros n elementos. Si el stream tiene menos de n elementos, retorna un stream vacio
 */
public class BSlicingDemo {

    // lista de platos ordenados por sus calorias
    public static final List<Dish> menu = Arrays.asList(
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("rice", true, 310, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("prawns", false, 400, Dish.Type.FISH),
            new Dish("salmon", false, 250, Dish.Type.FISH),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("pork", false, 800, Dish.Type.MEAT)
    );

    // seleccionamos platos que tengan menos de 320 calorias
    private static void slicingWithPredicate(List<Dish> menu){
        List<Dish> slicingMenu = menu.stream()
                // con filer iteramos por el stream aplicando el predicate, se aplica el predicado a cada elemento
                .filter(dish -> dish.getCalories() < 320)
                .collect(toList());
        System.out.println(slicingMenu);
    }

    private static void stopOnceItHasNotFound(List<Dish> menu){
        List<Dish> newMenu = menu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
        System.out.println(newMenu);
    }

    private static void getDishesHaveGreatestCalories(List<Dish> menu){
        List<Dish> myMenu = menu
                .stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
        System.out.println(myMenu);
    }

    // obtenemos los primeros 3 platos cuya calorias superan los 320
    private static void limitStream(List<Dish> menu){
        List<Dish> myMenu = menu
                .stream()
                .filter(dish -> dish.getCalories() > 320)
                .limit(3)
                .collect(toList());
        System.out.println(myMenu);
    }

    // filtramos los platos cuyo tipo es Other y del resultado saltamos los dos primeros platos
    private static void skipElements(List<Dish> menu){
        List<Dish> myMenu = menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.OTHER)
                .skip(2)
                .collect(toList());
        System.out.println(myMenu);
    }

    public static void main(String[] args) {
        //slicingWithPredicate(Dish.menu);
        //stopOnceItHasNotFound(menu);
        //getDishesHaveGreatestCalories(menu);
        //limitStream(menu);
        skipElements(Dish.menu); // rice, pizza
    }
}
