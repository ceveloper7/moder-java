package ch05;

import ch04.Dish;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

/*
 * Map: Stream soporta el metodo map() el cual aplica una funcion a cada elemeto del stream
 * flatMap() permite reemplazar cada valor de un stream y luego concatenar los stream generados en un solo stream
 */
public class CStreamMapping {

    private static void getDishesNames(List<Dish> dishes){
        List<String> myMenu = dishes.stream()
                .map(dish -> dish.getName())
                .collect(toList());
        System.out.println(myMenu.toString());
    }

    private static void getStringLength(){
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> lengths = words.stream()
                .map(word -> word.length())
                .collect(toList());
        System.out.println(lengths.toString());
    }

    private static void getUniqueCharactersFromString(){
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<String> uniqueCharacters = words.stream()
                // convertirmos cada palabra en un array
                .map(word -> word.split(""))
                // aplanamos cada stream generado en un solo flujo.
                .flatMap(item -> Arrays.stream(item))
                .distinct()
                .collect(toList());
        System.out.println(uniqueCharacters.toString());
    }

    // return a list of square numbers
    private static void getSquareNumbers(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> n = numbers.stream()
                .map(number -> number * number)
                .collect(toList());
        System.out.println(n);
    }

    // de dos listas de numeros obtenemos pares [1,3],[1,4],[2,3],[2,4],[3,3],[3,4]
    private static void getAllPairsNumbers(){
        List<Integer> firstList = Arrays.asList(1, 2, 3);
        List<Integer> secondList = Arrays.asList(3,4);

        List<int[]> pairs = firstList.stream()
                .flatMap(i -> secondList.stream()
                            .map(j -> new int[]{i, j}))
                .collect(toList());

        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }
    }

    //obtenemos pares cuya suma sea divisible por 3
    private static void getAllPairsByThree(){
        List<Integer> firstList = Arrays.asList(1, 2, 3);
        List<Integer> secondList = Arrays.asList(3,4);

        List<int[]> pairs = firstList.stream()
                .flatMap(i -> secondList.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(toList());

        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }
    }

    public static void main(String[] args) {
        getAllPairsByThree();
        //getAllPairsNumbers();
        //getSquareNumbers();
        //getDishesNames(Dish.menu);
        //getStringLength();
        //getUniqueCharactersFromString();
    }
}
