public class Person {
    private final int age;
    private final String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void run() {
        System.out.println(this.age);
    }
}
