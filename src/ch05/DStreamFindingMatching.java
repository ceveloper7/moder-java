package ch05;

import ch04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * Finding Matching: permite determinar si algun elemento en una estructura de datos coincide con una propiedad dada.
 *
 * anyMatch() permite reponder a la pregunta hay algun elemento en el stream que coincida con el predicado dado?
 * allMatch() comprueba si todos los elementos del stream coinciden con el predicado dado.
 * noneMatch: es lo opuesto a allMatch(). Garantiza que ningun elemento del stream coincida con el predicado dado.
 * findAny() retorna un elemento arbitrario del stream actual. Se puede combinar con otras operaciones. Por ejemplo
 *           para buscar un plato vegetariano podemos primero filtrar los platos vegetarianos del menu y luego
 *           aplcar findAny() para obtener el plato vegetariano arbitrariamente.
 *
 * findFirst() funciona similar a findAny(). Encuentra el primer elemento del stream que cumple con el predicado. findFirst()
 *             es mas costoso en paralelismo por lo que si no le interesa que elemento es devuelto, findAny() es una buena opcion
 *             es menos costoso.
 *
 * Las operaciones allMatch(), noneMatch(), findFirst(), findAny(), limit() no necesitan procesar el flujo completo para
 * producir un resultado. Tan pronto como encuentran un elemento, se puede producir un resultado. este tipo
 * de operaciones se llaman operaciones de corto circuito.
 */
public class DStreamFindingMatching {

    private static void isThereVegetarianMenu(List<Dish> menu){
        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is vegetarian friendly");
        }else{
            System.out.println("The menu is not vegetarian friendly");
        }
    }

    // todos los platos tienen menos de 300 calorias?
    private static void isTheMenuLowCalories(List<Dish> menu){
        boolean isHealty = menu.stream()
                .allMatch(dish -> dish.getCalories() < 300);
        if(isHealty){
            System.out.println("Our menu is healty");
        }else{
            System.out.println("Our menu is not healty");
        }
    }

    private static void findAnyVegetarianDish(List<Dish> menu){
        Optional<Dish> dish = menu.stream()
                .filter(dish1 -> dish1.isVegetarian())
                .findAny();

        // verificamos la presencia de un valor, si hay uno, imprimir el nombre del plato
        dish.ifPresent(dish1 -> System.out.println(dish1.getName()));
    }

    private static void findFirstSquareDivisibleByThree(){
        List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);
        Optional<Integer> firstDivisibleByThree = someNumbers.stream()
                .map(element -> element * element)
                .filter(n -> n % 3 == 0)
                .findFirst();

        firstDivisibleByThree.ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        findFirstSquareDivisibleByThree();
        findAnyVegetarianDish(Dish.menu);
        isTheMenuLowCalories(Dish.menu);
        isThereVegetarianMenu(Dish.menu);
    }
}
