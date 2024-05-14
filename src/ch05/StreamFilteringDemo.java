package ch05;

import ch04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamFilteringDemo {

    // filtramos los platos vegetarianos
    public static void filteringVegetarianDishes(List<Dish> menu){
        List<Dish> vegetarianDishes =  menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
        System.out.println(vegetarianDishes);
    }

    // filtrando elementos unicos
    public static void filteringUniqueElements(){
        List<Integer> numbers = Arrays.asList(1,2,1,3,2,4);
        numbers.stream()
                .filter(number -> number %2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
    public static void main(String[] args) {
        filteringVegetarianDishes(Dish.menu);
        filteringUniqueElements();
    }
}
