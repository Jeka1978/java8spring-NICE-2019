package real_spring.screen_saver;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class ColorFrameTest {

    @Test
    public void moveToRandomLocation() {
        new ColorFrame() {
            @Override
            protected Color getColorBean() {
                return Color.RED;
            }
        }
    }
}