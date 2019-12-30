package stream_labs;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author Evgeny Borisov
 */
public class TextUtils {
    public static long countWords(Stream<String> lines) {
        AtomicInteger counter = new AtomicInteger();
        long numberOfWords = lines.peek(line -> counter.getAndIncrement())
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .count();
        System.out.println("number of lines = " + counter);
        return numberOfWords;
    }

    public static String mostPopularWord(Stream<String> lines) {
        Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(" ")));
        Map<String, Long> map = words.collect(groupingBy(w -> w, counting()));
//        map.entrySet().stream().max((o1, o2) -> (int) (o2.getValue()-o1.getValue()))
        return null;

    }
}





