package utils;

public class Mammal extends Animal {
    private final String name;

    public Mammal(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return "";
    }
}