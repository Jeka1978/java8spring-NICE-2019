package java8_labs;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static java.util.Arrays.asList;

/**
 * @author Evgeny Borisov
 */
public class ListUtils {

    public static void main(String[] args) {


        List<Integer> list = asList(1, 2, 3);
        forEachWithDelay(list,500, x -> System.out.println(x));
    }

    @SneakyThrows
    public static <T> void forEachWithDelay(List<T> list, int delay, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
            Thread.sleep(delay);
        }
    }


    public static <T> int countDuplicates(T t, List<T> list, Equalator<T> equalator) {
        int counter=0;
        for (T t1 : list) {
            if (equalator.myEquals(t,t1)) {
                counter++;
            }
        }
        return counter;
    }
}
