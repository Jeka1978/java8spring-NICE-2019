package homework;

import stream_labs.Employee;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author Evgeny Borisov
 */
public class EmpUtil {

    public static Map<Seniority, List<Employee>> groupBySeniority(List<Employee> employees) {
        return employees.stream()
                .collect(groupingBy(employee -> Seniority.findBySalary(employee.getSalary())));
    }
}
