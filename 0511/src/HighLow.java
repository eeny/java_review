import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//1. 랜덤만들기 - 한번만 실행 - 생성자에 작성
//2. 내가 입력한 글자 -> 입력한 모든 글자는 무조건 String입니다. -> 숫자로 변경
//3. 두 개 비교
//4. 비교 후 처리 - 크다 작다 내용을 쓰거나 색상 변경

public class HighLow extends JFrame implements ActionListener {
    int cpu;
    JTextField tf;
    JButton btn;
    JLabel lbl;

    public HighLow() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 200);

        //Math.random() * 100 범위는 0~0.99.999 -> int로 바꾸면 0~99
        cpu = (int)(Math.random()*100) + 1;//1번 완성. 프로그램이 시작되면 랜덤 생성.

        tf = new JTextField();
        btn = new JButton("확인");
        btn.addActionListener(this);//버튼을 클릭할 때마다 작동하게~
        lbl = new JLabel();
        lbl.setOpaque(true);//JLabel의 경우 이걸 해줘야 배경색이 바뀐다!

        this.add(tf, "North");
        this.add(lbl, "Center");
        this.add(btn, "South");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //랜덤, 입력한 값, 버튼 객체, 결과 출력 레이블
        int input = 0;//메서드 안에 있는 변수는 반드시 초기값을 줘야 한다. 아니면 에러 발생!

        if (tf.getText().equals("")) {
            lbl.setText("입력값이 없습니다.");
        } else {
            input = Integer.parseInt(tf.getText());

            if (input>cpu) {
                lbl.setText("더 작은 수를 입력하세요.");
                lbl.setBackground(Color.BLUE);
            } else if (input<cpu) {
                lbl.setText("더 큰 수를 입력하세요.");
                lbl.setBackground(Color.GREEN);
            } else {
                lbl.setText("빙고!!");
                lbl.setBackground(Color.RED);

                int go = JOptionPane.showConfirmDialog(this, "한번 더?");//int타입으로 반환됨
                //예, 아니오 창 => this는 어디에 띄울 것인가, null로 하면 화면 중앙에 뜬다.

                if (go==JOptionPane.YES_OPTION) {//예 를 눌렀을 때
                    makeRandom();//랜덤이 새로 실행됨
                    lbl.setText("새로 시작합니다.");
                    lbl.setBackground(Color.GRAY);
                } else if (go==JOptionPane.NO_OPTION) {
                    System.exit(0);//강제 종료
                }
            }
        }
    }

    void makeRandom() {
        cpu = (int)(Math.random()*100) + 1;
    }

    public static void main(String[] args) {
        new HighLow();
    }
}
