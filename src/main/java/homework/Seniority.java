package homework;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * @author Evgeny Borisov
 */
@RequiredArgsConstructor
public enum Seniority {

    JUNIOR(0, 10), MIDLLE(11, 20), SENIOUR(21, Integer.MAX_VALUE);

    private final int min;
    private final int max;

    public static Seniority findBySalary(int salary) {
        return Arrays.stream(values()).filter(seniority -> seniority.min <= salary)
                .filter(seniority -> seniority.max >= salary)
                .findAny().get();
    }


}
