package my_spring;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class IRobotTest {
    @Test
    public void cleanRoomTest() {
        IRobot iRobot = new IRobot();
        iRobot.cleanRoom();
    }
}