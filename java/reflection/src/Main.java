import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    static void main() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Human human = new Human("Modi ji", 75);
        magic(human);
    }

    private static void magic(Object object) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class<?> aClass = object.getClass();
        Method method = aClass.getMethod("greet", String.class, int.class);
        method.invoke(object, "shabash", 1000);
    }
}
