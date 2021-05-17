import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FileDataEx1 extends JFrame implements ActionListener {
    JButton btn;
    JTextField tf;
    JTextArea ta;
    JScrollPane sp;

    public FileDataEx1() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 400);

        tf = new JTextField();
        this.add(tf, "North");

        ta = new JTextArea();
        sp = new JScrollPane(ta);
        this.add(sp);

        btn = new JButton("저장");
        btn.addActionListener(this);
        this.add(btn, "South");

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //버튼이 1개 뿐이니까 굳이 if(e.getSource()==btn) 이렇게 할 필요가 없다!
        //action 달린 게 1개 뿐이니까


        String filename = tf.getText();
        String contents = ta.getText();

//		System.out.println(filename);
//		System.out.println(contents);

        File f = new File(filename);
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(f);
            pw = new PrintWriter(fw);
            pw.println(contents);
            JOptionPane.showMessageDialog(this, "저장되었습니다.");

        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    public static void main(String[] args) {
        new FileDataEx1();
    }
}