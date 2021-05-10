import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class SwingUI3 extends JFrame implements ActionListener {
    JLabel lbl;
    JButton btn1;
    JButton btn2;

    public SwingUI3() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 300);
        this.setLayout(new FlowLayout());

        lbl = new JLabel("오늘은 금요일입니다. 피곤합니다.");

        btn1 = new JButton("ColorChooser");
        btn1.addActionListener(this);
        btn2 = new JButton("FileChooser");
        btn2.addActionListener(this);

        this.add(lbl);
        this.add(btn1);
        this.add(btn2);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn1) {//버튼1을 누르면
            JColorChooser chooser = new JColorChooser();
            Color selCol = chooser.showDialog(null, "색상선택", Color.RED);
            //showDialog 하면 색상선택창(JColorChooser)이 뜬다!!!
            //showDialog(어디를 기준으로 할지, 타이틀, 첫번째 색상)
            //확인을 누르면 결과가 위의 변수 selCol에 담긴다.
            System.out.println(selCol);
            if (selCol != null) {
                lbl.setForeground(selCol);//글씨색 골라 바꾸기!
            }
        } else if (e.getSource()==btn2) {//버튼2를 누르면
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(this);//열기 버튼
            //int result = chooser.showSaveDialog(this);//저장 버튼
            //int result = chooser.showDialog(this, "하이");//하이 버튼
            if (result==JFileChooser.APPROVE_OPTION) {//확인 눌렀을 때
                File selFile = chooser.getSelectedFile();//산택한 파일 경로를 갖고온다.
                System.out.println(selFile);//C:\Users\Administrator\Desktop\dogs\cat.jpg
            }
        }
    }

    public static void main(String[] args) {
        new SwingUI3();
    }
}