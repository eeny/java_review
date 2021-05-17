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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LoadAndSaveTable extends JFrame implements ActionListener {
    JTable tbl;
    JButton btnLoad, btnSave;
    String fileName = "member.txt";
    DefaultTableModel model;

    String[][] contents = {};

    public LoadAndSaveTable() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 300);

        // 1/asdf/1111/홍길동/asdf@asd.com/남
        String[] head = {"글번호", "아이디", "비밀번호", "이름", "이메일", "성별"};
        //String[][] contents = {};

        model = new DefaultTableModel(contents, head);
        tbl = new JTable(model);
        JScrollPane sp = new JScrollPane(tbl);

        JPanel pnlSouth = new JPanel();
        btnLoad = new JButton("불러오기");
        btnLoad.addActionListener(this);
        btnSave = new JButton("저장하기");
        btnSave.addActionListener(this);
        pnlSouth.add(btnLoad);
        pnlSouth.add(btnSave);

        this.add(sp);
        this.add(pnlSouth, "South");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File f = new File(fileName);
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        PrintWriter pw = null;

        if (e.getSource()==btnLoad) {// 불러오기
            try {
                fr = new FileReader(f);
                br = new BufferedReader(fr);

                String l = null;
                while ((l = br.readLine()) != null) {
                    String[] str = new String[6];
                    str[0] = l.split("/")[0];
                    str[1] = l.split("/")[1];
                    str[2] = l.split("/")[2];
                    str[3] = l.split("/")[3];
                    str[4] = l.split("/")[4];
                    str[5] = l.split("/")[5];
                    model.addRow(str);
                }

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } else if (e.getSource()==btnSave) {// 저장하기
            try {
                fw = new FileWriter(f);
                pw = new PrintWriter(fw);

                for (int i = 0; i < tbl.getRowCount(); i++) {// 행 개수 만큼 돌기
                    pw.println(tbl.getValueAt(i, 0) + "/"
                            + tbl.getValueAt(i, 1) + "/"
                            + tbl.getValueAt(i, 2) + "/"
                            + tbl.getValueAt(i, 3) + "/"
                            + tbl.getValueAt(i, 4) + "/"
                            + tbl.getValueAt(i, 5)
                    );
                }
                JOptionPane.showMessageDialog(this, "저장되었습니다.");

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
        new LoadAndSaveTable();
    }
}