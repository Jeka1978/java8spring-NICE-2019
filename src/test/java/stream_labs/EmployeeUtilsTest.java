package stream_labs;

import homework.EmpUtil;
import homework.Seniority;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static homework.Seniority.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class EmployeeUtilsTest {


    private static List<Employee> employees;

    @Before
    public void setUp() throws Exception {
        employees = asList(
                Employee.builder().name("Barak").salary(10).build(),
                Employee.builder().name("Eshu").salary(18).build(),
                Employee.builder().name("Eshu").salary(18).build(),
                Employee.builder().name("Moran").salary(30).build()
        );
    }

    @Test
    public void testSeniority() {
        Map<Seniority, List<Employee>> map = EmpUtil.groupBySeniority(employees);
        Assert.assertEquals(1,map.get(JUNIOR).size());
        Assert.assertEquals(2,map.get(MIDLLE).size());
        Assert.assertEquals(1,map.get(SENIOUR).size());
    }

    @Test
    public void totalSalary() {

        int totalSalary = EmployeeUtils.totalSalary(employees);
        Assert.assertEquals(60,totalSalary);
    }
}