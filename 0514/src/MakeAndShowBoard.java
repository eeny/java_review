import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

class MakeBoard extends JFrame implements ActionListener { // 글입력하는 클래스
    JTextField titleTf, writerTf, contentsTf;
    JButton saveBtn, cancelBtn;

    public MakeBoard() {
        this.setDefaultCloseOperation(3);
        this.setSize(400, 300);

        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(new GridLayout(0, 2));
        JLabel titleLb = new JLabel("제목");
        JLabel writerLb = new JLabel("글쓴이");
        JLabel contentsLb = new JLabel("내용");
        titleTf = new JTextField();
        writerTf = new JTextField();
        contentsTf = new JTextField();
        pnlCenter.add(titleLb);
        pnlCenter.add(titleTf);
        pnlCenter.add(writerLb);
        pnlCenter.add(writerTf);
        pnlCenter.add(contentsLb);
        pnlCenter.add(contentsTf);

        JPanel pnlSouth = new JPanel();
        saveBtn = new JButton("글입력");
        saveBtn.addActionListener(this);
        cancelBtn = new JButton("취소");
        cancelBtn.addActionListener(this);
        pnlSouth.add(saveBtn);
        pnlSouth.add(cancelBtn);

        this.add(pnlCenter);
        this.add(pnlSouth, "South");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==saveBtn) {// 글입력
            int idx = 1;// 글번호

            File f = new File("testBoard.txt");// 저장할 파일명

            FileReader fr = null;
            BufferedReader br = null;

            try {
                fr = new FileReader(f);
                br = new BufferedReader(fr);

                String l = null;
                // l안의 내용 =>		글번호/글제목/글쓴이/내용
                // split으로 자름      [0]  [1]  [2]   [3]

                while ((l = br.readLine()) != null) {// 저장된 파일이 있는 경우 인덱스 늘리기
                    idx = Integer.parseInt(l.split("/")[0]);// 가장 최신의 글번호를 갖고옴
                }
                idx++;// 만약에 파일이 없다면 실행 안됨

            } catch (FileNotFoundException e1) {
                System.out.println("첫 번째 게시글입니다!");

            } catch (IOException e2) {
                e2.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();

                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }

            // 저장된 파일이 있든 없든 실행되는 부분
            FileWriter fw = null;
            PrintWriter pw = null;

            try {
                fw = new FileWriter(f, true);// 저장할 때마다 내용이 추가된다!
                pw = new PrintWriter(fw);
                pw.println(idx + "/" + titleTf.getText() + "/" + writerTf.getText() + "/" + contentsTf.getText());
                JOptionPane.showMessageDialog(this, "글이 등록됐습니다!");

            } catch (IOException e4) {
                e4.printStackTrace();
            } finally {
                if (pw != null) {
                    pw.close();
                }
            }

        } else if (e.getSource()==cancelBtn) {// 취소
            titleTf.setText("");
            writerTf.setText("");
            contentsTf.setText("");
        }
    }
}

class ShowBoard extends JFrame {// 글 목록 보여주는 클래스
    JTextArea ta1, ta2, ta3;// JTextArea로 하는 이유는 append()를 써야하기 때문에!

    public ShowBoard() {
        this.setDefaultCloseOperation(3);
        this.setSize(400, 300);

        JPanel pnlNorth = new JPanel();
        JLabel lbl1 = new JLabel("글번호");
        lbl1.setPreferredSize(new Dimension(50, 20));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        JLabel lbl2 = new JLabel("글제목");
        lbl2.setPreferredSize(new Dimension(150, 20));
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        JLabel lbl3 = new JLabel("글쓴이");
        lbl3.setPreferredSize(new Dimension(100, 20));
        lbl3.setHorizontalAlignment(JLabel.CENTER);
        pnlNorth.add(lbl1);
        pnlNorth.add(lbl2);
        pnlNorth.add(lbl3);

        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(new GridLayout(0, 3));
        ta1 = new JTextArea();
        ta2 = new JTextArea();
        ta3 = new JTextArea();
        pnlCenter.add(ta1);
        pnlCenter.add(ta2);
        pnlCenter.add(ta3);

        File f = new File("testBoard.txt");// testBoard.txt 파일 내용을 출력

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String l = null;
            while ((l = br.readLine()) != null) {
                ta1.append("                    " + l.split("/")[0] + "\n");
                ta2.append("        " + l.split("/")[1] + "\n");
                ta3.append("       " + l.split("/")[2] + "\n");
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "파일이 없습니다!");

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        this.add(pnlNorth, "North");
        this.add(pnlCenter);
        this.setVisible(true);
    }
}

public class MakeAndShowBoard {
    public static void main(String[] args) {
        new MakeBoard();
        new ShowBoard();
    }
}
