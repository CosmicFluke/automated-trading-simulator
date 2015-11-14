package autotradingsim.Interface;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by billfeng on 15-11-13.
 *
 */
public class AutomatdTradingSimulator {
    private JButton exit;
    private JList list1;
    private JPanel panel1;
    private JList list2;
    private JList list3;
    private JButton button1;
    private JButton button2;

    public AutomatdTradingSimulator() {
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });
    }
}
