import utils.*;

import java.util.ArrayList;
import java.util.List;

public class App {
    static void main() {
        List<Dog> dogs = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();

        ZooUtils.copy(dogs, cats);
    }
}
