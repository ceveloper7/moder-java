package ch05;

import ch04.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class SlicingDemo {

    // seleccionamos platos que tengan menos de 320 calorias
    private static void slicingWithPredicate(List<Dish> menu){
        List<Dish> slicingMenu = menu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());
        System.out.println(slicingMenu);
    }

    private static void stopOnceItHasFound(List<Dish> menu){
        List<Dish> newMenu = menu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());
        System.out.println(newMenu);
    }
    public static void main(String[] args) {
        slicingWithPredicate(Dish.menu);
        stopOnceItHasFound(Dish.menu);
    }
}
