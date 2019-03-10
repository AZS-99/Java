package game;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class GUI extends JFrame {
    public GUI (Board board) {
        super("Chess Board: Knight's Tour");
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 8));
        setBackground(Color.WHITE);


        JPanel panel;
        JLabel label;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                panel = new JPanel();
                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                if ((i + j) % 2 == 1)
                    panel.setBackground(new Color(153, 102, 0));
                if (i + 2 == board.getPositionY() && j + 2 == board.getPositionX()) {
                    label = new JLabel("1");
                    label.setFont(new Font(label.getName(), Font.PLAIN, 40));
                    panel.add(label);
                }
                add(panel);
            }
        }

        setVisible(true);

        try {
            TimeUnit.SECONDS.sleep(5);

        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        setVisible(false);
        GUI2 g2 = new GUI2(board);
    }

}
