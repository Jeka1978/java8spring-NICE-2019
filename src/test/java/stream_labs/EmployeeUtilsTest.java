package stream_labs;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class EmployeeUtilsTest {

    @Test
    public void totalSalary() {
        List<Employee> employees = asList(
                Employee.builder().salary(10).build(),
                Employee.builder().salary(20).build(),
                Employee.builder().salary(30).build()
        );
        int totalSalary = EmployeeUtils.totalSalary(employees);
        Assert.assertEquals(60,totalSalary);
    }
}