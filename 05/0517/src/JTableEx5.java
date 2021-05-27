import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableEx5 extends JFrame implements ActionListener {
    JTable tbl;
    DefaultTableModel model;
    JButton btn1, btn2;

    public JTableEx5() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);

        JPanel pnl = new JPanel();
        btn1 = new JButton("불러오기");
        btn1.addActionListener(this);
        btn2 = new JButton("저장하기");
        btn2.addActionListener(this);
        pnl.add(btn1);
        pnl.add(btn2);
        this.add(pnl, "South");

        String[] header = {"번호", "아이디", "비밀번호", "이름", "이메일", "성별"};
        String[][] contents = {};// 어차피 파일로 읽어와서 넣을거라서 굳이 값을 신경 쓸 필요가 없다!
        model = new DefaultTableModel(contents, header);
        tbl = new JTable(model);
        JScrollPane sp = new JScrollPane(tbl);
        this.add(sp);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn1) {// 불러오기
            File f = new File("member.txt");
            FileReader fr = null;
            BufferedReader br = null;

            try {
                fr = new FileReader(f);
                br = new BufferedReader(fr);// 읽어오기 준비 끝

                String l = null;
                while ((l = br.readLine()) != null) {
                    // l은 한 줄 1/asdf/1234/홍길동...
                    String[] str = l.split("/");// 6개짜리 배열
                    //우리가 필요한 데이터도 6개짜리 배열 = 보니까 같네? = 바로 넣자!
//					str[0] = l.split("/")[0];
//					str[1] = l.split("/")[1];
//					str[2] = l.split("/")[2];
//					str[3] = l.split("/")[3];
//					str[4] = l.split("/")[4];
//					str[5] = l.split("/")[5];
                    // 이렇게 할 필요가 없네!
                    model.addRow(str);
                }

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                try {
                    if(br != null){
                        br.close();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }

        } else if (e.getSource()==btn2) {// 저장하기
            File f = new File("member.txt");
            FileWriter fw = null;
            PrintWriter pw = null;
            try {
                fw = new FileWriter(f);
                pw = new PrintWriter(fw);

                for (int i = 0; i < tbl.getRowCount(); i++) {// 모든 줄 읽어오기 - 한 줄 읽어와서 한 칸씩 다시 읽어오기
                    for (int j = 0; j < tbl.getColumnCount(); j++) {
                        pw.print(tbl.getValueAt(i, j));
                        if (j < (tbl.getColumnCount() - 1)) {
                            pw.print("/");
                        }
                    }
                    pw.println();
                }

            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                if (pw != null) {
                    pw.close();
                }
            }
        }
    }

    public static void main(String[] args) {
        new JTableEx5();
    }
}