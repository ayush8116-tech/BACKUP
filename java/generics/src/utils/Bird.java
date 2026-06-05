package utils;

public class Bird extends Animal {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return this.name;
    }
}