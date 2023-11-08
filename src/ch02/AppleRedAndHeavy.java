package ch02;

import model.Apple;
import model.Color;

public class AppleRedAndHeavy implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return Color.RED.equals(apple.getColor()) && apple.getWeight() > 150;
    }
}
