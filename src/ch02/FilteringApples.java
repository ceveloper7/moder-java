package ch02;

import model.Apple;
import model.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED),
                new Apple(180, Color.RED));

        List<Apple> greenApples = filterGreenApples(inventory);
        System.out.println(greenApples);

        List<Apple> redApples = filterApplesByColor(inventory, Color.RED);
        System.out.println(redApples);

        List<Apple> weightApples = filterApplesByWeight(inventory, 120);
        System.out.println(weightApples);

        List<Apple> greeApples =  filterApples(inventory, Color.GREEN, 0, true);
        System.out.println(greeApples);

        List<Apple> heavyApples = filterApples(inventory, null, 110, false);
        System.out.println(heavyApples);

        List<Apple> appleRedAndHeavy = filterApples(inventory, new AppleRedAndHeavy());
        System.out.println(appleRedAndHeavy);
    }

    // Primer intento de manejar los requisitos: filtrar las manzanas verdes
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory){
            if(apple.getColor() == Color.GREEN){
                result.add(apple);
            }
        }
        return result;
    }

    /*
     * Manejar los requisitos: filtrar las manzanas rojas
     * Segundo intento: parametrizar el color
     */
    public static List<Apple> filterApplesByColor (List<Apple> inventory, Color color){
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory){
            if(apple.getColor().equals(color)){
                result.add(apple);
            }
        }
        return result;
    }

    /*
     * Ahora queremos diferencias entre manzanas livianas y pesadas. Las manzanas
     * pesadas pueden pesar mas de 150g
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory){
            if(apple.getWeight() > weight){
                result.add(apple);
            }
        }
        return result;
    }

    /*
     * 3er intento: filtro con cada atributo que podemos pensar
     */
    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag){
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory){
            // una forma horrible de seleccionar color o peso
            if((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)){
                result.add(apple);
            }
        }
        return result;
    }

    /*
     * 4To Intento: Filtro por criterio abstracto
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}