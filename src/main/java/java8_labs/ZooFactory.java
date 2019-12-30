package java8_labs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @author Evgeny Borisov
 */
public class ZooFactory {

    private List<Supplier<? extends Animal>> animals = new ArrayList<>();


    {
        animals.add(Cat::new);
        animals.add(Dog::new);
    }

//    public Animal createRandomAnimal() {
//        Random random = new Random();
//        int i = random.nextInt(2);
//
//    }
}




