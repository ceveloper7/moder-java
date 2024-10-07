package ch04;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamBasics {

    private static void getThreeHighCaloricDishNames(List<Dish> dishes){
        List<String> threeHighCaloricDishName = dishes
                // obtenemos un stream con un listado de platos
                .stream()

                /*
                 * operaciones de procesamiento o intermedias como filter, map, limit xq se pueden conectar . Se llaman intermedias xq devuelven
                 * Las operaciones intermedias no realizan ningun procesamiento hasta que se llame una operacion terminal.
                 * todas excepto toList retornan un Stream
                 */
                // filtramos los platos cuyas calorias sean mayores a 300
                .filter(dish -> {
                    System.out.println("filtering " + dish.getName());
                    return dish.getCalories() > 300;})

                // extraemos el nombre de cada plato (dish -> dish.getName())
                .map(dish -> {
                    System.out.println("mapping " + dish.getName());
                    return dish.getName();})

                .limit(3)// truncamos el stream para q no contenga mas de 3 elementos

                // collect es una operacion terminal porque cierra el flujo. NO RETORNA UN STREAM
                .collect(toList()); // convertimos el stream en una coleccion List<String>

        System.out.println(threeHighCaloricDishName);
    }

    private static void printDishes(List<Dish> dishes){
        Stream<Dish> dishStream = dishes.stream();
        dishStream.forEach(System.out::println);
    }

    private static void printDishesName(List<Dish> dishes){
        List<String> dishesName = dishes.stream().map(Dish::getName).collect(toList());
        System.out.println(dishesName);
    }

    public static void main(String[] args) {
        //printDishes(Dish.menu);
        printDishesName(Dish.menu);
        //getThreeHighCaloricDishNames(Dish.menu);
    }


}
