package ch04;

import java.util.List;
import java.util.stream.Collectors;

public class StreamBasics {

    public static void main(String[] args) {
        getThreeHighCaloricDishNames(Dish.menu);
    }

    private static void getThreeHighCaloricDishNames(List<Dish> dishes){
        List<String> threeHighCaloricDishName = dishes
                // obtenemos un stream con un listado de platos
                .stream()
                // operaciones de procesamiento. todas excepto toList retornan un Stream
                // filtramos los platos cuyas calorias sean mayores a 300
                .filter(dish -> {
                    System.out.println("filtering " + dish.getName());
                    return dish.getCalories() > 300;
                })
                // extraemos el nombre de cada plato (dish -> dish.getName())
                .map(dish -> {
                    System.out.println("mapping " + dish.getName());
                    return dish.getName();
                })
                .limit(3)// truncamos el stream para q no contenga mas de 3 elementos
                .toList(); // convertimos el stream en una coleccion List<String>
        System.out.println(threeHighCaloricDishName);
    }
}
