package ch02;

import model.Apple;

public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
       return "GREEN".equals(apple.getColor());
    }
}
