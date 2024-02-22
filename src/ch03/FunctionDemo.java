package ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<Apple>();
        inventory.add(new Apple("Golden Apple", 80, Color.RED));
        inventory.add(new Apple("Granny Smith Apple", 155, Color.GREEN));
        inventory.add(new Apple("Fuji Apple", 120, Color.YELLOW));
        inventory.add(new Apple("Red Delicious Apple", 85, Color.GREEN));
        inventory.add(new Apple("Royal Gala Apple", 75, Color.YELLOW));

        List<Integer> appleWeights = getAppleWeight(inventory, (apple -> apple.getWeight()));
        for(Integer i : appleWeights){
            System.out.println(i);
        }
        System.out.println("Apple total: " + countInventory(inventory));
    }

    public static long countInventory(List<Apple> inventory){
        long stock = 0;
       return stock = inventory.stream()
               .count();
    }

    public static List<Integer> getAppleWeight(List<Apple> inventory, Function<Apple, Integer> w){
        List<Integer> result = new ArrayList<>();
        for(Apple apple : inventory){
            result.add(w.apply(apple));
        }
        return result;
    }
}
