package ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class AFunctionInterfaceSample {

    /*
     * Ejemplo de Interfaces funcionales Genericas: Predicate, Consumer, Function. Estas interfaces genericas solo admiten tipo por referencia
     * como: String, Integer, Object, List, etc.
     * Interface funcional Predicate
     * Define un metodo abstracto test() que recibe un tipo generico y retorna un boolean
     */

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate){
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    /*
     * Interface funcional Consumer
     * Define un metodo abstracto accept() que recibe un objeto tipo generico y no retorna ningun resultado es void.
     * Se puede emplear en casos donde se necesita acceder a un objeto tipo T y realizar una operacion
     * En nuestro ejemplo tomamos una lista de Apples y los imprimimos
     */
    private static <T> void printForEachAppleConsumer(List<T> list, Consumer<T> consumer){
        for (T t : list) {
            consumer.accept(t);
        }
    }

    /*
     * Interface funcional Function<T,R>
     * Define un metodo abstracto apply() que recibe un objeto generico tipo T como entrada y retorna un objeto tipo
     * generico R
     * Se puede emplear esta interface en casos donde necesita definir una lambda que asigne informacion de un objeto de
     * entrada a una salida. Por ejemplo, extraer el dato de un objeto u obtener la longitud de un String
     * Funcion map() - Recibe una lista de objetos (Apple), por cada Apple recibimos la longitud de la propiedad name (Integer)
     */
    private static <Apple,Integer> List<Integer> getAppleNameLenght(List<Apple> list, Function<Apple,Integer> f){
        List<Integer> result = new ArrayList<>();
        for(Apple a : list){
            result.add(f.apply(a));
        }
        return result;
    }

    // la misma lambda pero diferente interface funcional(ToIntBiFunction, BiFunction)
    private static int sumAppleWeightToIntBiFunction(Apple a1, Apple a2, ToIntBiFunction<Apple, Apple> apples){
        return apples.applyAsInt(a1, a2);
    }

    private static int sumAppleWieghtBiFunction(Apple a1, Apple a2, BiFunction<Apple, Apple, Integer> apples){
        return apples.apply(a1, a2);
    }


    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<Apple>();
        inventory.add(new Apple("Golden Apple", 80, Color.RED));
        inventory.add(new Apple("Granny Smith Apple", 80, Color.GREEN));
        inventory.add(new Apple("Fuji Apple", 120, Color.YELLOW));
        inventory.add(new Apple("Red Delicious Apple", 80, Color.GREEN));
        inventory.add(new Apple("Royal Gala Apple", 75, Color.YELLOW));

        // Trabajando con Predicate
        System.out.println("Working with Predicate");
        Predicate<Apple> predicateGreenApples = (Apple a) -> a.getColor() == Color.GREEN;
        List<Apple> greenApples = filter(inventory, predicateGreenApples);
        System.out.println(greenApples);

        // Trabajando con Consumer
        System.out.println("Working with Consumer");
        printForEachAppleConsumer(inventory, (Apple a) -> System.out.println(a.getName() + " - " + a.getWeight()));

        // Trabajando con Function
        System.out.println("Working with Function");
        List<Integer> appleNamesLenght = getAppleNameLenght(inventory, (Apple a) -> a.getName().length());
        System.out.println(appleNamesLenght);

        System.out.println("Working with same lambda but diffrent functional interface");
        int weight = sumAppleWeightToIntBiFunction(inventory.get(0), inventory.get(1), (Apple a1, Apple a2)-> a1.getWeight() + a2.getWeight());
        System.out.println("Total weight is " + weight);

        System.out.println(sumAppleWieghtBiFunction(inventory.get(2), inventory.get(3), (Apple a1, Apple a2)-> a1.getWeight() + a2.getWeight()));
    }
}
