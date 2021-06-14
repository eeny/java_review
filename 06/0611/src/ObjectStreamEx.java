import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ObjectStreamEx extends JFrame implements ActionListener {
    File file = new File("student4.dat");// 파일 미리 만들기
    JTextField tfNum, tfName, tfMajor;
    JButton btnIn;
    JPanel southPnl;
    ObjectOutputStream out;// 액션에서 쓰려고 미리 전역으로 빼뒀다!
    HashMap<String, Student4> stdMap;// 학생이 담길 맵
    HashMap<String, Student4> res;// 처음에 읽어올 파일이 담길 맵

    // ===== 따로 만든 변수 =====
    ObjectInputStream in;
    JLabel centerLbl;
    JTextField tfFind;
    JButton btnOut;
    // ===== 따로 만든 변수 =====

    public ObjectStreamEx() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);

        stdMap = new HashMap<>();

        southPnl = new JPanel();
        tfNum = new JTextField(7);
        tfName = new JTextField(7);
        tfMajor = new JTextField(7);
        btnIn = new JButton("입력");
        btnIn.addActionListener(this);
        southPnl.add(tfNum);
        southPnl.add(tfName);
        southPnl.add(tfMajor);
        southPnl.add(btnIn);

        // ===== 따로 만든 코드 =====
        tfFind = new JTextField(7);
        btnOut = new JButton("찾기");
        btnOut.addActionListener(this);
        southPnl.add(tfFind);
        southPnl.add(btnOut);

        centerLbl = new JLabel();
        this.add(centerLbl);
        // ===== 따로 만든 코드 =====

        // 생성자에서 이전에 있는 파일을 읽어와서 미리 만들어진 맵에 다시 값 채워넣기
        if (file.exists()) {// 파일이 있다면 실행하라~
            getObjData(0);
        }

        this.add(southPnl, "South");
        this.setVisible(true);
    }

    void setObjData() {
        try {
            out = new ObjectOutputStream(new FileOutputStream(file));// 파일 쓰기 준비

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Student4 std = new Student4(tfNum.getText(), tfName.getText(), tfMajor.getText());
        // 학번(KEY)으로 학번/이름/학과 정보(VALUE)를 다 들고 올거다!
        stdMap.put(tfNum.getText(), std);

        try {
            out.writeObject(stdMap);// 파일에 쓰기(맵을 통째로 집어넣었다!)
            out.flush();// 버퍼에 남아있는 내용을 전부 다 꺼내서 출력한다.

        } catch (IOException e1) {
            e1.printStackTrace();

        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    // 찾기 버튼을 눌렀을 때
    // 매개 변수 x는 검색할 때 사용할 건지 처음 생성자에서 실행할건지 구분하는 용도!
    void getObjData(int x) {
        try {
            in = new ObjectInputStream(new FileInputStream(file));// 파일 읽기 준비
            // 위에서 맵을 넣었으니까 맵으로 가져와야 한다!
            // read로 파일의 객체를 읽어옴
            res = (HashMap<String, Student4>) in.readObject();

            if (x == 1) {// 이 부분은 필요할 수도 있고 아닐 수도 있으므로
                Student4 s = res.get(tfFind.getText());

                centerLbl.setText(s.toString());
                // s + "" 으로 출력해도 된다!
                // 1111:김똘똘:경영학과 (VALUE만 출력)

                //centerLbl.setText(res+"");
                // {1111=1111:김똘똘:경영학과} (KEY, VALUE 같이 출력)
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIn) {
            setObjData();
        } else if (e.getSource() == btnOut) {
            getObjData(1);
        }
    }

    public static void main(String[] args) {
        new ObjectStreamEx();
    }

}

class Student4 implements Serializable {// 동기화 - 네트워크 때 설명
    String num;
    String name;
    String major;

    public Student4(String num, String name, String major) {
        this.num = num;
        this.name = name;
        this.major = major;
    }

    @Override
    public String toString() {
        return num + ":" + name + ":" + major;
    }
}