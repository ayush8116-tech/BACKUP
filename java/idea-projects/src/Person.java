public class Person {
    private final int age;
    private final String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    boolean isAdult() {
        return this.age >= 18;
    }
}
