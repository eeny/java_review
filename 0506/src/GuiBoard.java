import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GuiBoard extends JFrame {
    public GuiBoard() {
        this.setSize(300, 300);
        this.setDefaultCloseOperation(3);

        JPanel pnl = new JPanel();
        pnl.add(new JButton("확인"));
        pnl.add(new JButton("취소"));

        this.add(new JLabel("게시판입니다."), "North");
        this.add(new JTextArea(), "Center");
        this.add(pnl, "South");

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GuiBoard();
    }
}
