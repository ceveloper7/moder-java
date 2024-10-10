package ch05;

import ch04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * Las operaciones de reduccion nos permiten combinar elementos de un flujo para expresar consultas mas complicadas.
 * como calcular las suma de todas las calorias del menu.
 * La operacion reduce combina todos los elementos del strean repetidamente para producir un unico valor, como un Integer.
 * estas consultas se pueden clasificar como operaciones de reduccion.
 *
 * reduce() utiliza dos parametros:
 *  un valor inicial
 *  una funcion lambda para combinar los elementos del stream y producir un nuevo valor.
 */
public class EReducingStream {

    private static void sumNumbersWithInitialValue(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.stream().
                // valor inicial 0
                // BinaryOperator<T> = (a,b) -> a+b
                reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }

    private static void sumNumbersWithoutInitialValue(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // usamos optional en el caso de que la lista no contenga elementos.
        Optional<Integer> sum = numbers.stream()
                .reduce((a, b) -> a + b);
        sum.ifPresent(System.out::println);

    }

    private static void multiplyNumbers(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int result = numbers.stream()
                .reduce(1, (a,b) -> a*b);
        System.out.println(result);
    }

    private static void getMaxValue(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> maxValue = numbers.stream()
                .reduce(Integer::max);
        maxValue.ifPresent(System.out::println);
    }

    private static void getMinValue(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // podriamos haber usado (x,y) -> x < y ? x : y
        Optional<Integer> minValue = numbers.stream()
                .reduce(Integer::min);
        minValue.ifPresent(System.out::println);
    }

    private static void countingDishes(List<Dish> menu){
        Long count = menu.stream().count();
        System.out.println(count);
    }

    public static void main(String[] args) {
        countingDishes(Dish.menu);
        getMinValue();
        getMaxValue();
        sumNumbersWithoutInitialValue();
        multiplyNumbers();
        sumNumbersWithInitialValue();
    }
}
