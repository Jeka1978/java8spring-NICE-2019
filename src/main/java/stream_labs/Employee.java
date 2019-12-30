package stream_labs;

import lombok.Builder;
import lombok.Data;

/**
 * @author Evgeny Borisov
 */
@Data
@Builder
public class Employee {
    private String name;
    private int salary;
}
