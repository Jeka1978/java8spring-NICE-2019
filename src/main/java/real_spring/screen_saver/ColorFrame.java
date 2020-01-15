package real_spring.screen_saver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */

@Component
public abstract class ColorFrame extends JFrame {

    private Random random = new Random();

    @Autowired
    private Color color;


    @PostConstruct
    public void init() {
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public void moveToRandomLocation() {
        color = getColorBean();
        setLocation(random.nextInt(1200), random.nextInt(900));
        getContentPane().setBackground(color);
        repaint();
    }

    @Lookup("color")
    protected abstract Color getColorBean() ;


}
