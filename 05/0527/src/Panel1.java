import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
// 메인프레임에 갖다붙여질 패널 (방식1)
public class Panel1 extends JPanel implements ActionListener {
    JButton btnHere, btnTogo;
    McMain mmain;// 밑에서 삭제 작업을 하기 위해 전역으로 뺌

    // 메인프레임에 접근해서 명령(패널을 지워라!)을 수행하기 위해서
    // 생성자에서 매개변수로 메인 프레임을 받아온다!
    public Panel1(McMain mmain) {
        this.mmain = mmain;
        this.setBackground(Color.GREEN);

        btnHere = new JButton("매장");
        btnTogo = new JButton("포장");
        btnHere.addActionListener(this);
        btnTogo.addActionListener(this);

        this.add(btnHere);
        this.add(btnTogo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnHere) {
            mmain.add(mmain.pnl2);// 메인프레임 안에 있는 패널2를 붙이고

            // 기존의 방식처럼 이렇게 만들어도 결과는 똑같다!
            // 하지만 나중에 패널들이 많아지면 일이 커진다!
//			Panel2 pnl2 = new Panel2();
//			mmain.add(pnl2);

            mmain.remove(this);// 여기서 this는 내 자신인 Panel1
            // 메인프레임에게 패널1인 나를 지워라!
            mmain.repaint();
            mmain.revalidate();
        } else if (e.getSource()==btnTogo) {

        }
    }

    // McMain에서 부터 실행하지 않고 현재 패널의 모습만 보고싶을 때 테스트용으로 실행하는 방법
    // 기능은 쓸 수 없지만 UI확인은 가능하다!
	/*public static void main(String[] args) {
		// 메인은 프로그램이 시작될 때
		// 생성자 보다 먼저 실행됨
		Panel1 p = new Panel1(null);

		JFrame f = new JFrame();
		f.setDefaultCloseOperation(3);
		f.setSize(500, 500);
		f.add(p);
		f.setVisible(true);
	}*/
}
