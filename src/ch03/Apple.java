package ch03;

public class Apple {
    private String name;
    private int weight = 0;
    private Color color;

    public Apple(String name){
        this.name = name;
    }

    public Apple(String name, int weight, Color color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return String.format("Apple{name=%s, color=%s, weight=%d}", name, color, weight);
    }

}