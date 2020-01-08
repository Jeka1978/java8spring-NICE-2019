package my_spring;

import lombok.Data;

import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Data
public class Elf {

    @InjectRandomInt(min=3,max=5)
    private int power;

    @InjectRandomInt(min=8,max=15)
    private int speed;

}
