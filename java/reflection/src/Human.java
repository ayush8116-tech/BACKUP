public class Human {
    public  String name;
    private final int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void greet(String msg) {
        System.out.printf("%s is saying %s", this.name, msg);
    }

    public void greet(String msg, int times) {
        System.out.printf("%s is saying %s %d times", this.name, msg, times);
    }
}
