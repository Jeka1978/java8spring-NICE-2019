package homework;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author Evgeny Borisov
 */
public class BlackFridayUtils {
    public static void printBlackFridays(int startYear, int endYear) {
        LocalDate startDate = LocalDate.of(startYear, 1, 13);
        LocalDate endDate = LocalDate.of(endYear, 12, 14);
        Map<Integer, Long> map = Stream.iterate(startDate, localDate -> localDate.plusMonths(1))
                .limit(ChronoUnit.MONTHS.between(startDate, endDate))
                .filter(localDate -> localDate.getDayOfWeek() == DayOfWeek.FRIDAY)
                .collect(groupingBy(LocalDate::getYear, counting()));



        map.entrySet()
                .stream()
                .sorted((o1, o2) -> (int) (o2.getValue()-o1.getValue()))
                .forEach(System.out::println);


//        IntStream.iterate(startYear,)

        //input will look like (1900,1920)
        // out should look like

        //1902 - 3
        //1907 - 3
        //1907 - 3
        //1910 - 2
        // 1912 - 2
        // 1916 - 1
    }

    public static void main(String[] args) {
        printBlackFridays(2015,2018);
    }
}
