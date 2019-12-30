package collectors_examples;

import stream_labs.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        Stream<Employee> employeeStream = Stream.of(
                Employee.builder().name("Barak").salary(40).build(),
                Employee.builder().name("Jeka").salary(40).build(),
                Employee.builder().name("Ariel").salary(35).build(),
                Employee.builder().name("Ronen").salary(35).build(),
                Employee.builder().name("Sheni").salary(35).build()

        );
//        Map<String, Integer> map = employeeStream
//                .collect(toMap(Employee::getName, Employee::getSalary, Integer::max));
//        System.out.println("map = " + map);

        Map<Integer, List<Employee>> listMap = employeeStream.collect(groupingBy(Employee::getSalary));
        System.out.println("listMap = " + listMap);

    }
}
