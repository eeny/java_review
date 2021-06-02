import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardMatchingGame extends JFrame implements ActionListener {
    List<JButton> btnList;

    public CardMatchingGame() {
        this.setDefaultCloseOperation(3);
        this.setSize(400, 300);

        JPanel pnlNorth = new JPanel();
        JLabel title = new JLabel("그림짝 맞추기");
        title.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        pnlNorth.add(title);

        JPanel pnlCenter = new JPanel();
        JLabel quest = new JLabel("맞춰볼 두 카드를 클릭하세요           ");
        quest.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        pnlCenter.add(quest);

        String[] str = {"짝1", "짝1","짝2", "짝2","짝3", "짝3","짝4", "짝4","짝5", "짝5"};
        JButton[] btns = new JButton[10];
        for (int i = 0; i < btns.length; i++) {
            btns[i] = new JButton(str[i]);
            btns[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            btns[i].setPreferredSize(new Dimension(70, 70));
            btns[i].addActionListener(this);
        }
        btnList = Arrays.asList(btns);
        Collections.shuffle(btnList);
        for (JButton b : btnList) {
            pnlCenter.add(b);
        }

        this.add(pnlNorth, "North");
        this.add(pnlCenter, "Center");
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CardMatchingGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton fstBtn = null;// 첫번째 버튼
        JButton scdBtn = null;// 두번째 버튼
        boolean isFirst = false;// 첫번째 버튼을 선택했는지 여부

        if(!isFirst) {// 첫번째 버튼을 선택한 경우
            JButton b = (JButton) e.getSource();// 내가 선택한 버튼
            fstBtn = b;
            isFirst = true;
            System.out.println("첫번재 버튼 : " + fstBtn.getText());

            if (fstBtn != null) {
                JButton b2 = (JButton) e.getSource();// 내가 선택한 버튼
                scdBtn = b2;
                isFirst = false;
                System.out.println("두번째 버튼 : " + scdBtn.getText());

                // 두 개 비교

            }

        } else {// 첫번째 버튼을 선택하지 않은 경우
            System.out.println("선택한 버튼 없음!");
        }
    }
}