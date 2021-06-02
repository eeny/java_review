import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class BookGUI {
    String title;
    String author;
    int price;

    public BookGUI(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    // 다른 클래스에서 접근할 수 있는 것은 전역 변수밖에 없다!
}

public class BookManagerGUI extends JFrame implements ActionListener {
    JButton btn1, btn2, btn3, btn4, btn5, btn6;
    JTextField tf, tf1, tf2, tf3;
    JPanel pnl;
    JTable tbl;
    DefaultTableModel model;
    ArrayList<BookGUI> list;

    public BookManagerGUI() {
        this.setDefaultCloseOperation(3);
        this.setSize(900, 400);
        this.setTitle("책 관리자");

        list = new ArrayList<>();

        pnl = new JPanel();
        tf1 = new JTextField("제목", 10);
        tf2 = new JTextField("저자", 10);
        tf3 = new JTextField("가격", 10);
        btn1 = new JButton("추가");
        btn2 = new JButton("삭제");
        btn3 = new JButton("수정");
        btn4 = new JButton("목록");
        tf = new JTextField(5);
        btn5 = new JButton("검색");
        btn6 = new JButton("종료");

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);

        pnl.add(tf1);
        pnl.add(tf2);
        pnl.add(tf3);
        pnl.add(btn1);
        pnl.add(btn2);
        pnl.add(btn3);
        pnl.add(btn4);
        pnl.add(tf);
        pnl.add(btn5);
        pnl.add(btn6);

        String[] header = {"제목", "저자", "가격"};
        String[][] contents = {};// 추가 누를 때마다 list를 통해서 추가될 예정
        model = new DefaultTableModel(contents, header);
        tbl = new JTable(model);
        JScrollPane sp = new JScrollPane(tbl);

        this.add(sp, "Center");
        this.add(pnl, "South");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn1) {
            insertBook();

        } else if (e.getSource()==btn2) {
            removeBook();

        } else if (e.getSource()==btn3) {
            updateBook();

        } else if (e.getSource()==btn4) {
            listBook();

        } else if (e.getSource()==btn5) {
            getBook();

        } else if (e.getSource()==btn6) {
            System.exit(0);
        }
    }

    void insertBook() {
        String title = tf1.getText();
        String author = tf2.getText();
        int price = Integer.parseInt(tf3.getText());
        BookGUI b = new BookGUI(title, author, price);

        list.add(b);
        model.addRow(new Object[]{b.title, b.author, b.price});
        // Object를 사용한 이유? 타입이 다른 값들을 한 개로 넣기 위해서!

        tf1.setText("제목");
        tf2.setText("저자");
        tf3.setText("0");

        // Vector 써도 된다!
		/*Vector<String> v = new Vector<>();
		v.add(title);
		v.add(author);
		v.add(price+"");
		model.addRow(v);*/
    }

    void removeBook() {
        // 테이블에서 선택한 행을 테이블에서도 리스트에서도 삭제해야 한다!
        int selectedRow = tbl.getSelectedRow();
        model.removeRow(selectedRow);// 제일 처음이 0
        list.remove(selectedRow);// 제일 처음이 0
    }

    void updateBook() {
        int selectedRow = tbl.getSelectedRow();
        BookGUI b = list.get(selectedRow);
        b.title = tf1.getText();
        b.author = tf2.getText();
        b.price = Integer.parseInt(tf3.getText());
        // 여기까지가 list의 내용 바꾸기 - 하지만 실제로 보여지는 화면의 내용은 안바뀐 상태
        listBook();// 화면 갱신
    }

    void listBook() {
        // 실제로는 list의 값을 다 읽어와서 table에 추가해야 한다!
        model.setNumRows(0);// 테이블 내용 전체 삭제

        for (int i = 0; i < list.size(); i++) {
            BookGUI b = list.get(i);
            model.addRow(new Object[]{b.title, b.author, b.price});
        }

        // list 안에 잘 들어갔는지 테스트용 코드
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).title + " ");
            System.out.print(list.get(i).author + " ");
            System.out.println(list.get(i).price);
        }
    }

    void getBook() {
        // 테이블의 내용을 지우고(리스트에 데이터는 그대로 남아있음)
        // idx에 맞는 list 객체만 들고와서 출력해야 한다!
        int idx = Integer.parseInt(tf.getText());

        model.setNumRows(0);// 테이블 내용 전체 삭제

        BookGUI b = list.get(idx);
        model.addRow(new Object[]{b.title, b.author, b.price});

        // list 안에 잘 들어갔는지 테스트용 코드
        System.out.print(list.get(idx).title + " ");
        System.out.print(list.get(idx).author + " ");
        System.out.println(list.get(idx).price);
    }

    public static void main(String[] args) {
        new BookManagerGUI();
    }
}