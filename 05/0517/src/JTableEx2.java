import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableEx2 extends JFrame implements ActionListener {
    JTable table;

    public JTableEx2() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);

        String header[] = {"이름", "국어", "영어", "수학"};
        String contents[][] = {
                {"김똘똘", "100", "100", "95"},
                {"박똘똘", "90", "100", "85"},
                {"최똘똘", "75", "60", "80"}
        };

        table = new JTable(contents, header);
        JScrollPane sp = new JScrollPane(table);
        this.add(sp);

        JButton btn = new JButton("값 가져오기");
        btn.addActionListener(this);
        this.add(btn, "South");

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JTableEx2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 테이블의 값을 가져오는 부분
        // Object obj = table.getValueAt(0, 0);// 행, 열

        // String obj = (String)table.getValueAt(0, 0);// 행, 열

        // int obj = Integer.parseInt(table.getValueAt(0, 1) + "");// 행, 열
        // Integer.parseInt() 안에는 String이 들어가야하는데
        // table.getValueAt()은 Object타입을 반환한다!

        //System.out.println(obj);

        // 테이블의 값을 넣는 부분
        //table.setValueAt("김철수", 0, 0);// 넣을 값, 행, 열 순서로 값을 넣는다!

        // 테이블의 행과 열의 개수를 출력하는 부분
        System.out.println(table.getRowCount() + " : " + table.getColumnCount());

        // Header부분의 값(컬럼명)을 출력하는 부분
        System.out.println(table.getColumnName(0) + " : " + table.getColumnName(1));
    }
}