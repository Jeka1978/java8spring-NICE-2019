package stream_labs;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class EmployeeUtils {
    public static int totalSalary(List<Employee> employees) {
        return employees.stream().mapToInt(Employee::getSalary).sum();
    }
}
