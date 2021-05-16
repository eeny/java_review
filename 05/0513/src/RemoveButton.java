import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class RemoveButton extends JFrame implements ActionListener {
    JButton go;//시작 버튼 - 이걸 누르면 이 때 5개씩 생긴다
    //따라서 미리 변수를 정의해 놓을 수 없다!
    JPanel pnl;//BorderLayout 에서 go는 북쪽에 붙인다
    //센터에 버튼이 여러 개 붙을테니까 센터에 패널을 붙여서 사용해야 한다.
    //센터에서 랜덤위치니까 패널의 레이웃은 null로 잡을 것이다!
    Color[] color = { Color.RED, Color.BLUE, Color.GRAY, Color.PINK, Color.YELLOW };

    public RemoveButton() {
        this.setDefaultCloseOperation(3);
        this.setSize(700, 700);

        go = new JButton("시작");
        go.addActionListener(this);
        this.add(go, "North");

        pnl = new JPanel();
        pnl.setLayout(null);
        pnl.setBackground(Color.WHITE);
        this.add(pnl);//Border에서 위치를 안붙이면 센터

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new RemoveButton();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 시작 버튼을 누를 때 마다 버튼이 5개씩, 랜덤 위치에, 랜덤 컬러에, 계속 생긴다.
        // 컬러는 5 개 중에 한 개
        // 누를 때 마다 생기니까 총 몇 개가 생길지 알 수 없다!
        // => 미리 정의해 놓을 수 없다. 이벤트가 발생하는 시점마다 만들어야 한다! 그래야 계속 되니까!
        if (e.getSource() == go) {// e.getSource의 의미 = 내가 누른 버튼
            // == 내가 누른 버튼이 go버튼 이라면~
            for (int i = 0; i < 5; i++) {
                // 누를 때 마다 5개 생길거니까 for문으로 5번 실행시킨다!
                // 각 실행이 될 때마다 버튼 생성, 위치 지정, 크기 지정, 색깔 지정이 된다.
                // 이 버튼을 누르면 사라지니까 action도 추가
                int x = (int) (Math.random() * 630);
                int y = (int) (Math.random() * 600);
                int c = (int) (Math.random() * 5);
                // for문 안에 랜덤을 정의하면 실행될 때마다 랜덤값 바뀐다.

                JButton btn = new JButton("안녕");// 버튼 생성
                btn.setBackground(color[c]);// 색깔 지정
                btn.setBounds(x, y, 70, 70);// 위치, 크기 지정
                btn.addActionListener(this);// 액션 추가
                pnl.add(btn);// 붙이기
            }
        } else {
            JButton curBtn = (JButton) e.getSource();
            // 누를 때 마다 그 버튼을 변수 curBtn에 담는다!
            // 내가 누른 버튼이 e.getSource() <= 이게 오브젝트니까 형변환을 해줬다
            // 내가 누른 그 버튼이 go버튼이 아닌 것 중에 누른 그녀석을 curBtn에 담아준다.
            pnl.remove(curBtn);
            // 패널에서 내가 누른 그 버튼을 지워라
        }

        pnl.repaint();
        pnl.revalidate();
    }
}