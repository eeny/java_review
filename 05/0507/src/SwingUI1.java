import java.awt.*;
import javax.swing.*;

public class SwingUI1 extends JFrame {
    public SwingUI1() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 400);
        this.setLayout(new FlowLayout());

        String[] comStr = {"피자", "파스타", "리조또", "햄버거", "샌드위치"};
        JComboBox combo = new JComboBox(comStr);

        //===============콤보박스 끝 리스트 시작=============================

        String listStr[] = {"짜장면", "짬뽕", "탕수육", "라조기", "깐풍기", "짬뽕", "탕수육", "라조기", "깐풍기", "짬뽕", "탕수육", "라조기", "깐풍기"};
        JList list = new JList(listStr);
        //list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //이 메서드를 사용하면 list도 단일 선택만 가능해진다!
        JScrollPane sp = new JScrollPane(list);

        this.add(combo);
        this.add(sp);//list를 붙이는 게 아니라 list에 붙은 스크롤을 붙여야한다!!!
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SwingUI1();
    }
}