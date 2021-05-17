import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableEx extends JFrame {
    public JTableEx() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);

        // JTable은 우리가 알고 있는 게시판 모양이다.
        // Header와 Contents를 만들어 두고 JTable에 추가한다.
        String header[] = {"이름", "국어", "영어", "수학"};
        String contents[][] = {
                {"김똘똘", "100", "100", "95"},
                {"박똘똘", "90", "100", "85"},
                {"최똘똘", "75", "60", "80"}
        };
        // header, contents 안에 들어가는 내용은 숫자라도 상관 없다! 문자열이 편하긴 하다!

        JTable table = new JTable(contents, header);// contents, header 순서가 거꾸로!
        JScrollPane sp = new JScrollPane(table);// 스크롤이 거의 필수!!!

        this.add(sp);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JTableEx();
    }
}
