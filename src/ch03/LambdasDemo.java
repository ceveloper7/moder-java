package ch03;

import java.util.ArrayList;
import java.util.List;

public class LambdasDemo {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<Apple>();
        inventory.add(new Apple(80, Color.GREEN));
        inventory.add(new Apple(155, Color.GREEN));
        inventory.add(new Apple(120, Color.RED));

        List<Apple> greenApples = filter(inventory, (apple -> apple.getColor() == Color.GREEN));
        System.out.println(greenApples);

    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate predicate){
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory){
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
