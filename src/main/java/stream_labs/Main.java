package stream_labs;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Stream<String> lines = Files.lines(Paths.get("yest.txt"));
        long countWords = TextUtils.countWords(lines);
        System.out.println("countWords = " + countWords);
    }
}
