package ch02;

import model.Apple;

public class AppleFancyFormatter implements AppleFormatter{
    @Override
    public String accept(Apple apple) {
        String feature = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + feature + " " + apple.getColor() + " apple";
    }
}
