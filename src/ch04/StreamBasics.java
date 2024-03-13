package ch04;

import java.util.List;
import java.util.stream.Collectors;

public class StreamBasics {

    public static void main(String[] args) {
        getThreeHighCaloricDishNames(Dish.menu);
    }

    private static void getThreeHighCaloricDishNames(List<Dish> dishes){
        List<String> threeHighCaloricDishName = dishes
                .stream()
                // operaciones de procesamiento. todas excepto toList retornan un Stream
                .filter(dish -> dish.getCalories() > 300)// excluimos elementos del stream
                .map(Dish::getName)// extraemos el nombre de cada plato (dish -> dish.getName())
                .limit(3)// truncamos el stream para q no contenga mas de 3 elementos
                .toList(); // convertimos el stream en una coleccion List<String>
        System.out.println(threeHighCaloricDishName);
    }
}
