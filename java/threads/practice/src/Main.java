import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.Date;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardWatchEventKinds.*;

public class Main {
    static void main() throws IOException, InterruptedException {
        Path srcPath = Paths.get("src");

        WatchService watchService = FileSystems.getDefault().newWatchService();
        srcPath.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

        while (true) {
            WatchKey key = watchService.take();

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                String fileName = event.context().toString();

                if (kind == ENTRY_CREATE) {
                    System.out.println("file created " + fileName + kind.name());
                }

                if (kind == ENTRY_DELETE) {
                    System.out.println("file deleted " + fileName);
                }

                if (kind == ENTRY_MODIFY && fileName.matches("score.txt")) {
                    FileReader fileReader = new FileReader("src/score.txt");
                    Scanner scanner = new Scanner(fileReader);

                    int calculatedSum = calculateSum(scanner);

                    Path path = Paths.get("src", "scores.txt");
                    String header = "Update Time:" + new Date();
                    String data = header + "\n" + calculatedSum + "\n\n";

                    Files.writeString(path, data, APPEND);
                    System.out.println("file modify " + fileName + " " + kind.name());
                }
            }

            key.reset();
        }
    }

    private static int calculateSum(Scanner scanner) throws FileNotFoundException {
        int sumOfScore = 0;

        while (scanner.hasNext()) {
            sumOfScore += Integer.parseInt(scanner.next());
        }

        return sumOfScore;
    }

    private static void explode(String msg) {
        throw new RuntimeException(msg);
    }

    private static void threadMessage(String msg) {
        System.out.println(msg);
    }
}


//        try (BufferedReader fileReader = new BufferedReader(new FileReader("slip.txt"))) {
//        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("output.txt"))) {
//int read;
//HashMap<String, Integer> bill = new HashMap<>();
//
//                while ((read = fileReader.read()) != -1) {
//        System.out.println(read);
//                    fileWriter.write(read);
//                }
//                        }
//                        } catch (IOException e) {
//        throw new RuntimeException(e);
//        }