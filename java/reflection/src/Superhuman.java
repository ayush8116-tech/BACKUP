public class Superhuman extends Human{
    private final String superpower;

    public Superhuman(String name, int age, String superpower) {
        this.superpower = superpower;
        super(name, age);
    }
}
