package utils;

import java.util.List;

public class ZooUtils {
    public static <T extends Mammal> void copy(List<? extends Mammal> source, List<? extends Mammal> destination) {
        for (T item : source) {
            destination.add(item);
        }
    }
}
