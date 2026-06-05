import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Square {
    public ArrayList<Integer> findSquares() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3);

        ArrayList<Integer> list = integerStream.collect((Supplier<ArrayList<Integer>>) ArrayList::new,
                (ArrayList<Integer> integers, Integer integer) -> {
                    integers.add(integer * integer);
                }, (integers, integers2) -> {
                    integers2.addAll(integers);
                });

        return list;
    }
}
