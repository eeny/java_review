import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Student3 implements Serializable {
    int id;// 학번
    String name;// 이름
    String major;// 전공

    public Student3(int id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    public String toString(){
        return id + ":" + name + ":" +major;
    }
}

public class StudentDatEx extends JFrame implements ActionListener {
    JTextField tfId, tfName, tfMajor;
    JButton btn;

    public StudentDatEx() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 100);

        JPanel pnl = new JPanel();
        tfId = new JTextField(5);
        tfName = new JTextField(5);
        tfMajor = new JTextField(5);
        btn = new JButton("입력");
        btn.addActionListener(this);
        pnl.add(tfId);
        pnl.add(tfName);
        pnl.add(tfMajor);
        pnl.add(btn);

        this.add(pnl, "South");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int id = Integer.parseInt(tfId.getText());
        String name = tfName.getText();
        String major = tfMajor.getText();

        ObjectInputStream in = null;
        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream("student.dat"));
            out.writeObject(new Student3(id, name, major));

            out.flush();

            in = new ObjectInputStream(new FileInputStream("student.dat"));
            Student3 st = (Student3) in.readObject();
            System.out.println(st);

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } finally {

            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new StudentDatEx();
    }
}
