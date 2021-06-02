import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LottoEx extends JFrame implements ActionListener {
    JPanel pnlSouth, pnlCenter;
    JButton btn1, btn2;
    JLabel[] lbl;
    ArrayList<Integer> list;

    public LottoEx() {
        init();// UI 초기화 메서드

        list = new ArrayList<>();

        for (int i = 0; i < 45; i++) {
            list.add(i);
            // 리스트에서 배열의 번호를 뽑아내야하므로 랜덤의 범위는 0 ~ 44
        }

        makeRandom();
		
		/*list의 랜덤값은 0~44
		lbl의 배열도 0~44
		눈에 보이는 lbl에 표시되는 값은 +1을 해줬다.
		결과적으로 lbl[0]=1, lbl[1]=2, lbl[2]=3, ...
		이렇게 들어있다.
		이걸 이용해서 우리는 배열 번호를 랜덤하게 찾아서 색을 바꾸는 방식!*/

        this.setVisible(true);// init() 에서 이것만 따로 뺐다!
    }

    // UI 만드는 메서드
    void init() {
        this.setDefaultCloseOperation(3);
        this.setSize(400, 700);

        pnlSouth = new JPanel();// FlowLayout
        btn1 = new JButton("자동");
        btn2 = new JButton("취소");
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        pnlSouth.add(btn1);
        pnlSouth.add(btn2);

        pnlCenter = new JPanel(new GridLayout(0, 6));// 자동 행 증가, 6열
        lbl = new JLabel[45];
        for (int i = 0; i < 45; i++) {
            lbl[i] = new JLabel("[" + (i + 1) + "]");
            lbl[i].setOpaque(true);// 레이블의 배경색을 바꾸기 위해 필요한 설정
            lbl[i].setHorizontalAlignment(JLabel.CENTER);// 그리드레이아웃 안에서 레이블 중앙정렬
            pnlCenter.add(lbl[i]);
        }

        this.add(pnlCenter);
        this.add(pnlSouth, "South");
    }

    // 랜덤으로 숫자를 섞고 선택된 6개 숫자에 배경색 설정하는 메서드
    void makeRandom() {
        clearBackground();

        Collections.shuffle(list);

        for (int i = 0; i < 6; i++) {
            lbl[list.get(i)].setBackground(Color.RED);
        }
    }

    void clearBackground() {
        for (int i = 0; i < 45; i++) {
            lbl[i].setBackground(null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn1) {// 자동
            makeRandom();
        } else {// 취소
            clearBackground();
        }
    }

    public static void main(String[] args) {
        new LottoEx();
    }
}