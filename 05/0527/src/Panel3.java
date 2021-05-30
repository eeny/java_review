import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
// 메인프레임에 갖다붙여질 패널 (방식1)
public class Panel3 extends JPanel implements ActionListener, MouseListener {
    JLabel lbl;
    McMain mmain;
    JTable tbl;
    DefaultTableModel model;
    JButton btnPrev, btnNext;
    int row = -1;
    JPopupMenu popmenu;
    JMenuItem item1;

    public Panel3(McMain mmain) {
        this.mmain = mmain;

        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);

        lbl = new JLabel("사이드메뉴 선택");

        this.add(lbl, "North");

        JPanel pnl = new JPanel();

        // static 메서드는 생성없이 바로 사용 가능
        String[][] data = FileUtil.getFile("sidemenu.txt");

        for (int i = 0; i < data.length; i++) {
            JButton btn = new JButton(data[i][0] + " " + data[i][1]);
            btn.addActionListener(this);
            btn.setPreferredSize(new Dimension(200, 50));
            pnl.add(btn);
        }

        this.add(pnl, "Center");

        String[] header = {"품목", "가격", "수량"};
        String[][] contents = {};
        model = new DefaultTableModel(contents, header);
        tbl = new JTable(model);

        tbl.addMouseListener(this);

        popmenu = new JPopupMenu();
        item1 = new JMenuItem("삭제");
        item1.addActionListener(this);
        popmenu.add(item1);

        //tbl.setComponentPopupMenu(popmenu);// 이 부분 없어도 되네!

        JScrollPane sp = new JScrollPane(tbl);

        JPanel pnlSouth = new JPanel(new BorderLayout());
        pnlSouth.add(sp, "Center");

        btnPrev = new JButton("이전");
        btnNext = new JButton("다음");
        btnPrev.addActionListener(this);
        btnNext.addActionListener(this);
        JPanel btnPnl = new JPanel();
        btnPnl.add(btnPrev);
        btnPnl.add(btnNext);
        pnlSouth.add(btnPnl, "South");

        this.add(pnlSouth, "South");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnPrev) {
            mmain.add(mmain.pnl2);
            // 메인을 내가(Panel3)가 들고있으니까 메인에게 명령을 할 수 있다.
            mmain.remove(this);
            // 메인이 모든 패널을 갖고 있으니까 메인이 갖고 있는 패널 중에서
            mmain.repaint();
            // 출력할 패널을 적어주기만 하면 따로 값을 넘길 필요가 없다!
            mmain.revalidate();
        } else if (e.getSource()==btnNext) {
            mmain.setTbl3(tbl);

            // 여기서 Panel4를 생성하는 이유는 McMain 파일에 적어놨음!
            Panel4 pnl4 = new Panel4(mmain);
            mmain.setPnl4(pnl4);

            mmain.add(mmain.pnl4);
            mmain.remove(this);
            mmain.repaint();
            mmain.revalidate();
        } else if (e.getSource()==item1) {
            System.out.println("삭제");
            model.removeRow(row);// 미리 선택된 줄 번호를 이용해서 삭제!
        } else {
            JButton btn = (JButton)e.getSource();
            // 내가 누른 버튼을 btn 변수에 담는다.
            //System.out.println(btn.getText());

            boolean isExist = false;
            int findRow = 0;// 발견한 줄
            for (int i = 0; i < tbl.getRowCount(); i++) {
                if (btn.getText().split(" ")[0].equals(tbl.getValueAt(i, 0))) {
                    // 버튼의 햄버거 이름이랑 테이블의 내용 중에 첫번째 컬럼(품목명)이랑 같으면
                    findRow = i;// 만약에 발견된 게 있다면 그 줄 번호를 findRow에 넣고
                    isExist = true;// 존재 여부의 변수를 true로 바꿔준다.
                    break;// 이미 찾았으므로 더이상 찾을 필요가 없기 때문에 break로 for문 탈출!
                }
            }

            if (isExist==false) {
                // 테이블에 없을 때 추가될 내용
                //String[] str = btn.getText().split(" "); // 이렇게는 수량이 없다!
                String[] str = new String[3];
                str[0] = btn.getText().split(" ")[0];
                str[1] = btn.getText().split(" ")[1];
                str[2] = "1";
                model.addRow(str);

            } else {
                // 테이블에 있을 때 추가될 내용
                int cnt = Integer.parseInt(tbl.getValueAt(findRow, 2) + "");// 수량
                // 현재 수량을 가져오는 부분
                cnt++;// 현재 수량에서 +1

                tbl.setValueAt(cnt+"", findRow, 2);// 테이블 수량 부분에 걊을 증가된 값으로 바꿔준다!
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // JTable을 클릭하면 실행됨
        // popmenu.show(invoker, x, y);
        // 어디에 뜨는지, x좌표, y좌표
        popmenu.show(this, e.getX()+10, e.getY()+320);// 내가 마우스 클릭한 곳 근처에 떠라!
        // 여기는 순수하게 팝업창을 띄우는 것 까지!
        row = tbl.getSelectedRow();// 내가 선택한 줄 번호를 전역변수 row에 담는다.
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
}
