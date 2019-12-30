package java8_labs;

/**
 * @author Evgeny Borisov
 */
public class Son implements Father,Mother {

    @Override
    public void talkToChildren() {
        Father.super.talkToChildren();
        Mother.super.talkToChildren();
    }
}
