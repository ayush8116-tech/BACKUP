package utils;

public class Cage<T> {
    private T animal;

    public Object getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }
}