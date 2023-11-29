package ch02;

import model.Apple;

public class AppleSimpleFormate implements AppleFormatter{
    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
