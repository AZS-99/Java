package game;

import javax.swing.*;
import java.awt.*;

public class GUI2 extends JFrame {
    public GUI2(Board board) {
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
                label = new JLabel(String.valueOf(board.board[i + 2][j + 2]));
                label.setFont(new Font(label.getName(), Font.PLAIN, 40));
                panel.add(label);
                add(panel);
            }
        }
        setVisible(true);
    }

}
