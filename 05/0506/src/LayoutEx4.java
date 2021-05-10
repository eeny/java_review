import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LayoutEx4 extends JFrame {
    public LayoutEx4() {
        this.setSize(500, 500);
        this.setDefaultCloseOperation(3);
        //this는 JFrame을 의미하고 기본이 무조건 BorderLayout이다!
        JLabel lbl = new JLabel("게시판");
        JTextArea ta = new JTextArea(5, 20);//줄, 칸

        this.add(lbl, "North");
        this.add(ta, "Center");

        JButton btn1 = new JButton("확인");
        JButton btn2 = new JButton("취소");

//		this.add(btn1, "South");
//		this.add(btn2, "South");
        //Border 자체가 같은 곳에 붙이면 무조건 겹친다.

        JPanel pnl = new JPanel();//무조건 FlowLayout 알아서 가로로 붙는
        pnl.add(btn1);
        pnl.add(btn2);

        this.add(pnl, "South");

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutEx4();
    }
}
