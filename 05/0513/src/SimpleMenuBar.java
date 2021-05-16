import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SimpleMenuBar extends JFrame {
    public SimpleMenuBar() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 300);

        JMenuBar mb = new JMenuBar();
        JMenu menu1 = new JMenu("파일(F)");
        JMenuItem item1 = new JMenuItem("새로 만들기(N)");
        JMenuItem item2 = new JMenuItem("새창(W)");
        JMenuItem item3 = new JMenuItem("열기(O)");
        JMenuItem item4 = new JMenuItem("저장(S)");
        JMenuItem item5 = new JMenuItem("다른 이름으로 저장(A)");
        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);
        menu1.add(item4);
        menu1.add(item5);

        JMenu menu2 = new JMenu("편집(E)");
        JMenuItem item11 = new JMenuItem("실행취소(U)");
        JMenuItem item22 = new JMenuItem("잘라내기(T)");
        JMenuItem item33 = new JMenuItem("복사(c)");
        JMenuItem item44 = new JMenuItem("붙여넣기(P)");
        JMenuItem item55 = new JMenuItem("삭제(L)");
        menu2.add(item11);
        menu2.addSeparator();
        menu2.add(item22);
        menu2.add(item33);
        menu2.add(item44);
        menu2.add(item55);

        mb.add(menu1);
        mb.add(menu2);

        this.setJMenuBar(mb);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleMenuBar();
    }
}