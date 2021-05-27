import javax.swing.JFrame;
import javax.swing.JTable;
// 패널만 붙어있는 메인 프레임 (방식1)
// 패널들끼리 연결하는 것은 비효율적이다.
// 중간에 연결하던 패널이 하나 사라지면 다른 패널들까지 영향을 미치기 때문에,
// 모든걸 관리하는 메인프레임에서 독립적인 패널들을 연결시키는 것이 효율적이다!
public class McMain extends JFrame {
    Panel1 pnl1;
    Panel2 pnl2;
    Panel3 pnl3;
    Panel4 pnl4;
    JTable tbl2, tbl3;

    public McMain() {
        this.setDefaultCloseOperation(3);
        this.setSize(700, 800);

        // this는 지금 클래스 - 메인 프레임 - 내 자신

        // this를 매개변수로 던지는 이유?
        // 어떤 패널에서든 메인프레임에 접근해서 명령(패널을 지워라! 추가해라!)을
        // 수행할 수 있게 하기 위해서
        pnl1 = new Panel1(this);
        // 패널만 가져다 붙일 거라서 패널의 내용을 전부 다른 클래스로 이동함
        this.add(pnl1);// 첫화면이니까 미리 만들어 붙인다!

        pnl2 = new Panel2(this);
        // 두번째 화면이니까 만들기만 하고
        // 첫번째 패널에서 명령을 받아서 메인을 붙이는 형태

        pnl3 = new Panel3(this);// pnl2와 같이 각 이전 패널에서 명령을 받아 실행됨

        // pnl4 = new Panel4(this);
        // 이렇게 미리 pnl4가 생성되어 버리면
        // 우리가 아직 pnl2, 3을 실행한 적이 없어서
        // tbl2, tbl3에 내용이 없는 상태로 4번이 만들어지는데
        // 없는 상태는 null 이므로 NullPointerException이 발생한다!
        // 그래서 pnl4는 pnl2, 3을 실행하고 나서 tbl2, tbl3에 데이터가 생긴 후에
        // 생성해주기 위해서 pnl4를 여기서 생성하지 않는다!

        this.setVisible(true);
    }

    void setPnl4(Panel4 pnl4) {
        this.pnl4 = pnl4;
    }

    void setTbl2(JTable tbl2) {
        this.tbl2 = tbl2;
    }

    void setTbl3(JTable tbl3) {
        this.tbl3 = tbl3;
    }

    public static void main(String[] args) {
        new McMain();
    }
}
