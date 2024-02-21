package ch03;

import java.util.ArrayList;
import java.util.List;

public class ConsumerDemo {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<Apple>();
        inventory.add(new Apple("Golden Apple", 80, Color.RED));
        inventory.add(new Apple("Granny Smith Apple", 155, Color.GREEN));
        inventory.add(new Apple("Fuji Apple", 120, Color.YELLOW));
        inventory.add(new Apple("Red Delicious Apple", 85, Color.GREEN));
        inventory.add(new Apple("Royal Gala Apple", 75, Color.YELLOW));

        printApplesUsingForEach(inventory);
    }

    public static void printApplesUsingForEach(List<Apple> inventory){
        inventory.forEach((System.out::println));
    }
}
