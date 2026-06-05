import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    static void main(String[] args) {
        Square square = new Square();

        Stream<String> stream = Arrays.stream("hello i am ayush".split(" "));
        Stream<String> stringStream = stream.map((a) -> {
            return a.toUpperCase();
        });

        System.out.println(stringStream);

        ArrayList<Integer> squares = square.findSquares();

        System.out.println(squares);
    }

    private static void MyRunnable(Person runnable) {
        runnable.run();
    }
}
