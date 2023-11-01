package ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED));

        List<Apple> greenApples = filterGreenApples(inventory);
        System.out.println(greenApples);

        List<Apple> redApples = filterApplesByColor(inventory, Color.RED);
        System.out.println(redApples);

        List<Apple> weightApples = filterApplesByWeight(inventory, 120);
        System.out.println(weightApples);
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

    enum Color {
        RED,
        GREEN
    }

    public static class Apple {

        private int weight = 0;
        private Color color;

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color='%s', weight=%d}", color, weight);
        }

    }
}
