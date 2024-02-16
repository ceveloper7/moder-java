package ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<Apple>();
        inventory.add(new Apple("Golden Apple", 80, Color.RED));
        inventory.add(new Apple("Granny Smith Apple", 155, Color.GREEN));
        inventory.add(new Apple("Fuji Apple", 120, Color.YELLOW));
        inventory.add(new Apple("Red Delicious Apple", 85, Color.GREEN));
        inventory.add(new Apple("Royal Gala Apple", 75, Color.YELLOW));

        System.out.println(predicateUsingOrAndNegate(inventory));
        //System.out.println(predicateUsingOr(inventory));
        //System.out.println(predicateUsingAnd(inventory));
        //System.out.println(complexFilter(inventory));
        //System.out.println(multipleFilters(inventory));
        //List<Apple> apples = filter(inventory, (apple -> apple.getColor() == Color.YELLOW));
        //List<Apple> apples = filter(inventory, (apple)-> apple.getName().startsWith("G"));
        //System.out.println(apples);

    }



    public static List<Apple> predicateUsingOrAndNegate(List<Apple> inventoy){
        Predicate<Apple> predicate1 = (apple -> apple.getColor()==Color.GREEN);
        Predicate<Apple> predicate2 = (apple -> apple.getWeight()> 100);
        return inventoy.stream()
                .filter(predicate1.or(predicate2.negate()))
                .collect(Collectors.toList());
    }

    public static List<Apple> predicateUsingOr(List<Apple> inventory){
        Predicate<Apple> appleRed = (apple -> apple.getColor() == Color.RED);
        Predicate<Apple> appleGreen = (apple -> apple.getColor() == Color.GREEN);
        return inventory.stream()
                .filter(appleRed.or(appleGreen))
                .collect(Collectors.toList());
    }
    public static List<Apple> predicateUsingAnd(List<Apple> inventory){
        Predicate<Apple> appleColor = (apple -> apple.getColor()==Color.GREEN);
        Predicate<Apple> appleWeight = (apple -> apple.getWeight() > 100);
        return inventory.stream()
                .filter(appleColor.and(appleWeight))
                .collect(Collectors.toList());
    }

    public static List<Apple> complexFilter(List<Apple> inventory){
        return inventory.stream()
                .filter(apple -> apple.getName().startsWith("G") && apple.getColor()==Color.GREEN)
                .collect(Collectors.toList());
    }

    public static List<Apple> multipleFilters(List<Apple> inventory){
        return inventory.stream()
                .filter(apple -> apple.getName().startsWith("R"))
                .filter(apple -> apple.getColor()==Color.YELLOW)
                .collect(Collectors.toList());
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
