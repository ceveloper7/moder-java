package ch03.exercise;


import ch03.Apple;
import ch03.Color;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<Apple>();
        inventory.add(new Apple("Golden Apple", 80, Color.RED));
        inventory.add(new Apple("Granny Smith Apple", 155, Color.GREEN));
        inventory.add(new Apple("Fuji Apple", 120, Color.YELLOW));
        inventory.add(new Apple("Red Delicious Apple", 85, Color.GREEN));
        inventory.add(new Apple("Royal Gala Apple", 75, Color.YELLOW));


        // pasando codigo: sorting by Apple Weight ascending
        inventory.sort(new AppleComparator());
        //System.out.println(inventory);

        // add new Apple
        inventory.add(new Apple("Manzana criolla", 89, Color.RED));

        // usamos clase anonima: sorting by apple weight ascending
        inventory.sort(new AppleComparator(){
            @Override
            public int compare(Apple a1, Apple a2){
                return a1.getWeight() - a2.getWeight();
            }
        });
        //System.out.println(inventory);

        // add new Apple
        inventory.add(new Apple("Manzana Celestial", 20, Color.YELLOW));

        // usamos lambda expresion con inferencia de tipos: sorting by apple weight ascending
        inventory.sort((a1, a2)-> a1.getWeight() - a2.getWeight());
        //System.out.println(inventory);

        // usamos method references
        // Este codigo es mas facil de leer. Ordenamos el inventario comprando las manzanas por su peso en ascendente
        inventory.sort(Comparator.comparing(Apple::getWeight));
        //System.out.println(inventory);

        // ordenamos las manzanas por el peso de mayor a menor (descendente)
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
        //System.out.println(inventory);

        // Encandenando comparaciones: Si dos manzanas tiene el mismo peso las ordenamos por el color
        inventory.add(new Apple("Golden Apple", 80, Color.GREEN));
        inventory.sort(
                Comparator.comparing(Apple::getWeight) // comparacion por peso, si dos manzanas tienen el mismo peso, la comparaciones por
                        .thenComparing(Apple::getColor) // comparacion por Color.
        );
        System.out.println(inventory);
    }
}
