import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SimpleNotepad extends JFrame implements ActionListener {
    JMenuItem item1, item2, item3, item4;
    JTextArea ta;
    JScrollPane sp;

    public SimpleNotepad() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        this.setTitle("간단 메모장");

        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("파일");

        item1 = new JMenuItem("새로 만들기(N)");
        item2 = new JMenuItem("열기(O)");
        item3 = new JMenuItem("저장(S)");
        item4 = new JMenuItem("끝내기(X)");
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);

        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.addSeparator();
        menu.add(item4);

        mb.add(menu);

        ta = new JTextArea();
        sp = new JScrollPane(ta);

        this.setJMenuBar(mb);
        this.add(sp);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //읽을 때 쓰는 기능
        FileReader fr = null;
        BufferedReader br = null;
        //생성 후 쓰는 기능
        FileWriter fw = null;
        PrintWriter pw = null;

        if (e.getSource()==item1) {//새로 만들기
            ta.setText("");

        } else if (e.getSource()==item2) {//열기(파일 읽어오기)
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(this);//열기 버튼
            if (result==JFileChooser.APPROVE_OPTION) {
                File selFile = chooser.getSelectedFile();
                String title = selFile.getName();

                try {
                    fr = new FileReader(selFile);
                    br = new BufferedReader(fr);

                    String contents;
                    while ((contents = br.readLine()) != null) {
                        ta.append(contents + "\n");
                    }

                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();

                } catch (IOException e1) {
                    e1.printStackTrace();

                } finally {
                    try {
                        if (br != null) {
                            br.close();
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }

        } else if (e.getSource()==item3) {//저장(파일 저장)
            String contents = ta.getText();

            // FileDialog 열어서 저장 경로 및 파일명을 지정
            FileDialog dialog = new FileDialog(this, "저장", FileDialog.SAVE);
            dialog.setDirectory(".");// .은 지금 폴더
            dialog.setVisible(true);

            // FileDalog가 비정상 종료 될 때를 예방(취소를 누르면 저장이 안되게)
            if (dialog.getFile()==null) {
                return;
            }

            // 경로명 파일명 설정(확장자는 무조건 .txt로 설정)
            String newFile = dialog.getDirectory() + dialog.getFile() + ".txt";

            //파일 저장
            try {
                fw = new FileWriter(newFile);
                pw = new PrintWriter(fw);
                pw.println(contents);

            } catch (Exception e2) {
                e2.printStackTrace();
            } finally {
                if (pw != null) {
                    pw.close();
                }
            }


        } else if (e.getSource()==item4) {//끝내기
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new SimpleNotepad();
    }
}