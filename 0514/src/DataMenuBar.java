import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class DataMenuBar extends JFrame implements ActionListener {
    JTextArea ta;
    JScrollPane sp;
    JMenuItem item1, item2, item3, item4;

    public DataMenuBar() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 3
        this.setSize(500, 600);

        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("파일");

        item1 = new JMenuItem("새로 만들기");
        item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        item1.addActionListener(this);

        item2 = new JMenuItem("열기");
        item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        item2.addActionListener(this);

        item3 = new JMenuItem("저장");
        item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        item3.addActionListener(this);

        item4 = new JMenuItem("끝내기");
        item4.addActionListener(this);

        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.addSeparator();
        menu.add(item4);

        menubar.add(menu);
        this.setJMenuBar(menubar);

        ta = new JTextArea();
        sp = new JScrollPane(ta);
        this.add(sp);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new DataMenuBar();
    }

    public void fileLoad() {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);
        FileReader fr = null;
        BufferedReader br = null;
        if (result == JFileChooser.APPROVE_OPTION) {// 확인
            File f = chooser.getSelectedFile();// 선택한 파일 가져옴
            // f = new File("c:\\user\\바탕화면\\aaa.txt");
            // f = new File("c:/user/바탕화면/aaa.txt"); 같은 말이다
            // 파일을 가져왔으니 이게 바로 파일명.
            // 이후 읽어들여서 ta에 뿌리면 됨
            // 메서드로 만들어 두면 더 간단.
            try {
                fr = new FileReader(f);
                br = new BufferedReader(fr);

                // 이미 이전에 내용이 있다면 지우고 새로 불러온 파일의 내용을 줘야 하므로
                // 초기화 작업을 해준다.
                ta.setText("");// 초기화

                String l = null;
                while ((l = br.readLine()) != null) {
                    ta.append(l + "\n");// append는 이미 있는 내용에 추가로 내용을 붙이는 메서드
                    // 한줄씩 읽어와서 붙이는데 엔터 기능이 없으므로 \n(엔터)를 추가
                    // setText는 그냥 내용을 새로 쓰는것.

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 확인 버튼일때만 작동할 필요가 있고 취소일땐 아무것도 안해도 되니까. 취소는 안함.
    }

    public void fileSave() {
        // 저장은 ta의 내용가져와서 File에다가 쓰기.
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showSaveDialog(this);// 확인, 취소
        if (result == JFileChooser.APPROVE_OPTION) {// 확인 버튼을 눌렀을때
            File f = null;
            FileWriter fw = null;
            PrintWriter pw = null;
            try {
                f = chooser.getSelectedFile();// 경로를 입력한 파일명
                fw = new FileWriter(f);
                pw = new PrintWriter(fw);

                pw.println(ta.getText());

            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                if (pw != null) {
                    pw.close();// 이거 안하면 파일은 만들어지나 내용이 저장이 안됨.
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == item1) {
            System.out.println("새로만들기");
            ta.setText("");
        } else if (e.getSource() == item2) {
            System.out.println("열기");
            fileLoad();
        } else if (e.getSource() == item3) {
            System.out.println("저장");
            fileSave();
        } else if (e.getSource() == item4) {
            System.out.println("끝내기");
            System.exit(0);
        }
    }

}