import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CardTest extends JFrame implements ActionListener {//p340 예제
    JPanel panel;
    Cards cards;

    public CardTest() {
        setTitle("CardLayoutTest");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridLayout(0, 5, 10, 0));
        addButton("<<", panel);
        addButton("<", panel);
        addButton(">", panel);
        addButton(">>", panel);
        addButton("종료", panel);
        add(panel, "North");
        cards = new Cards();
        add(cards, "Center");

        setVisible(true);
    }

    void addButton(String str, Container target) {
        JButton button = new JButton(str);
        button.addActionListener(this);
        target.add(button);
    }

    private class Cards extends JPanel {
        CardLayout layout;

        public Cards() {
            layout = new CardLayout();
            setLayout(layout);
            for (int i = 0; i <= 10; i++) {
                add(new JButton("현재 카드의 번호는 " + i + "입니다."), "Center");
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("종료")) {
            System.exit(0);
        } else if (e.getActionCommand().equals("<<")) {
            cards.layout.first(cards);
        } else if (e.getActionCommand().equals("<")) {
            cards.layout.previous(cards);
        } else if (e.getActionCommand().equals(">")) {
            cards.layout.next(cards);
        } else if (e.getActionCommand().equals(">>")) {
            cards.layout.last(cards);
        }
    }

    public static void main(String[] args) {
        new CardTest();
    }
}