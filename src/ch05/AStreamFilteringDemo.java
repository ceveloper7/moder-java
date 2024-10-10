package ch05;

import ch04.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/*
 * filter() -> toma como argumento un predicate (un predicate es una funcion que retorna tru or false). filter retorna un stream
 *             con todos los elementos que coinciden con el predicado.
 * distinct() -> retorna un stream con elementos unicos.
 */
public class AStreamFilteringDemo {

    // Filtrado de datos con un predicado. Creamos un menu con platos solo vegetarianos.
    public static void filteringVegetarianDishes(List<Dish> menu){
        List<Dish> vegetarianDishes =  menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
        System.out.println(vegetarianDishes);
    }

    // filtrando elementos pares de la lista y los duplicados se eliminan con distinct()
    public static void filteringUniqueElements(){
        List<Integer> numbers = Arrays.asList(1,2,1,3,2,4);
        numbers.stream()
                .filter(number -> number %2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
    public static void main(String[] args) {
        //filteringVegetarianDishes(Dish.menu);
        filteringUniqueElements();
    }
}
