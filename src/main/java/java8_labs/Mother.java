package java8_labs;

/**
 * @author Evgeny Borisov
 */
public interface Mother {
    default void talkToChildren(){
        System.out.println("COME TO ME!!!");
    }
}
