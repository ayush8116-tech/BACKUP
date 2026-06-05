import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.Executors.newScheduledThreadPool;

public class Main {
    static void main() throws IOException {

        Path path = Paths.get("src", "logs.txt");
        RandomAccessFile file = new RandomAccessFile(path.toFile(), "r");
        file.seek(14);
        byte[] buff = new byte[1024];
        System.out.println(file.read(buff, 10, 20));


        ScheduledExecutorService executor = newScheduledThreadPool(3);

    }
}
