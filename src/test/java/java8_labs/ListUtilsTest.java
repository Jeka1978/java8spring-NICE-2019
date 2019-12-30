package java8_labs;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class ListUtilsTest {

    @Test
    public void countDuplicates() {
        List<String> list = asList("java", "Java", "JAVA", "scala");
        int duplicates = ListUtils.countDuplicates("java", list,

                (String t1,  String t2) -> t1.equalsIgnoreCase(t2));
        Assert.assertEquals(3,duplicates);
    }
}