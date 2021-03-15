package problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class InOutPractice {
    public static void readInMemory(String filePath) throws IOException {
        final List<String> strings = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        System.out.println(strings);
    }

    public static void readByScanner(String filePath) {
        try(FileInputStream fileInputStream = new FileInputStream(filePath);
            Scanner scanner = new Scanner(fileInputStream, String.valueOf(StandardCharsets.UTF_8))
        ) {
            while (scanner.hasNextLine()) {
                final String s = scanner.nextLine();
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readByStream(String filePath) {
        try(Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void readByBufferReader(String filePath) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filePath))) {
            for (String line; (line = bufferedReader.readLine()) != null;)
                System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        //readInMemory("C:\\__Workspaces__\\temp\\sample.txt");
        //readByScanner("C:\\__Workspaces__\\temp\\sample.txt");
        readByStream("C:\\__Workspaces__\\temp\\sample_bk.txt");
        //readByBufferReader("C:\\__Workspaces__\\temp\\sample.txt");
    }
}
