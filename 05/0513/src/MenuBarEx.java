import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
//p467 예제 그림
public class MenuBarEx extends JFrame implements ActionListener {
    JMenuItem item1;

    public MenuBarEx() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);

        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("첫번째 메뉴");
        JMenu menu2 = new JMenu("두번째 메뉴");

        item1 = new JMenuItem("메뉴항목1");
        item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.ALT_MASK));
        item1.addActionListener(this);

        JMenuItem item2 = new JMenuItem("메뉴항목2", new ImageIcon("twitter.png"));

        menu.add(item1);
        menu.add(item2);
        menu.addSeparator();//구분선

        JRadioButtonMenuItem rbi = new JRadioButtonMenuItem("라디오 버튼 메뉴 1");
        JRadioButtonMenuItem rbi2 = new JRadioButtonMenuItem("라디오 버튼 메뉴 2");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbi);
        bg.add(rbi2);

        menu.add(rbi);
        menu.add(rbi2);
        menu.addSeparator();
        JCheckBoxMenuItem cbi = new JCheckBoxMenuItem("체크박스 메뉴 항목 1");
        JCheckBoxMenuItem cbi2 = new JCheckBoxMenuItem("체크박스 메뉴 항목 2");
        menu.add(cbi);
        menu.add(cbi2);
        menu.addSeparator();

        JMenu item3 = new JMenu("서브메뉴");
        //이 자체가 마지막이라면 item으로
        //서브 메뉴가 있다면 menu로
        menu.add(item3);

        JMenuItem item4 = new JMenuItem("서브 메뉴 항목 1");
        item4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        JMenuItem item5 = new JMenuItem("서브 메뉴 항목2");

        item3.add(item4);
        item3.add(item5);

        mb.add(menu);
        mb.add(menu2);

        this.setJMenuBar(mb);//MenuBar를 붙일 때는 add()를 쓰지 않는다!
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MenuBarEx();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==item1) {
            //showMessageDialog(부모창, 내용, 타이틀, 아이콘);
            //부모창에 null을 모니터를 기준으로 가운데 창이 뜸
            JOptionPane.showMessageDialog(this, "범위를 초과하였습니다.", "경고", JOptionPane.WARNING_MESSAGE);
            JOptionPane.showMessageDialog(this, "범위를 초과하였습니다.", "경고", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "범위를 초과하였습니다.", "경고", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(this, "범위를 초과하였습니다.", "경고", JOptionPane.QUESTION_MESSAGE);
        }
    }
}