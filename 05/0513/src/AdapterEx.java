import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
//어댑터 클래스 방식
public class AdapterEx extends JFrame {
    JLabel lbl;
    String[] str = {"Don't cry before you are hurt", "다치기도 전에 울지 마..."};
    public AdapterEx() {
        this.setDefaultCloseOperation(3);
        this.setSize(800, 300);

        lbl = new JLabel(str[0]);
        lbl.setFont(new Font(Font.SERIF, Font.ITALIC, 60));

        //this.addMouseListener(this);
        //(this)안에 들어가야하는 것은? MouseListener를 구현한 객체!
        //implements 해서 내용은 없지만 메서드는 다 만들어 준 것!
        this.addMouseListener(new MouseAdapter() {
            //어댑터 클래스는 미리 implement해서 구현해 놓은 클래스
            //그래서 필요한 것만 오버라이딩해서 사용할 수 있다!
            @Override
            public void mouseEntered(MouseEvent e) {
                lbl.setText(str[1]);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbl.setText(str[0]);
            }
        });

        this.add(lbl);

        //setVisible()을 항상 마지막에 해야 한다!
        //왜? 화면 갱신 기능을 갖고 있으므로, setVisible()을 먼저 하고 UI에 컴포넌트를 붙이면
        //깜빡거리거나 화면에 이벤트를 줘야만 나타나는 경우가 있기 때문에.
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new AdapterEx();
    }
}

//원래 우리가 만들던 방식
/*public class AdapterEx extends JFrame implements MouseListener {
	JLabel lbl;
	String[] str = {"Don't cry before you are hurt", "다치기도 전에 울지 마..."};
	public AdapterEx() {
		this.setDefaultCloseOperation(3);
		this.setSize(800, 300);
		
		lbl = new JLabel(str[0]);
		lbl.setFont(new Font(Font.SERIF, Font.ITALIC, 60));
		
		this.addMouseListener(this);
		this.add(lbl);
		
		this.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		lbl.setText(str[1]);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		lbl.setText(str[0]);
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
	public static void main(String[] args) {
		new AdapterEx();
	}
}*/