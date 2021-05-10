import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ActionBtnTest extends JFrame {
    public ActionBtnTest() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 300);
		/*
		Action a = new Action();//내부 클래스 방법
		
		JButton[] btns = new JButton[5];
		String[] str = {"North", "South", "West", "East", "Center"};
		for (int i = 0; i < str.length; i++) {
			btns[i] = new JButton("버튼" + i);		
			btns[i].addActionListener(a);
			this.add(btns[i], str[i]);
		}
		*/

        //무명 클래스 방법
        JButton btn1 = new JButton("버튼1");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(111);
            }
        });
        JButton btn2 = new JButton("버튼2");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(222);
            }
        });
        JButton btn3 = new JButton("버튼3");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(333);
            }
        });
        JButton btn4 = new JButton("버튼4");
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(444);
            }
        });
        JButton btn5 = new JButton("버튼5");
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(555);
            }
        });

        this.add(btn1, "North");
        this.add(btn2, "South");
        this.add(btn3, "West");
        this.add(btn4, "East");
        this.add(btn5, "Center");
        this.setVisible(true);
    }
    /*
    class Action implements ActionListener {//내부 클래스 방법
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(555);
        }
    }
    */
    public static void main(String[] args) {
        new ActionBtnTest();
    }
}