package autotradingsim.Interface;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by billfeng on 15-11-13.
 *
 */
public class AutomatdTradingSimulator {
    private JList experiments;
    private JButton add;
    private JButton open;
    private JButton delete;
    private JButton exit;

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
