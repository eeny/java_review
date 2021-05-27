import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel4 extends JPanel {

    JLabel lbl;

    public Panel4(McMain mmain) {
        lbl = new JLabel();
        String str = "<html>";
        String saveStr = "";// 파일로 저장할 때 쓸 변수(내 방식)

        for (int i = 0; i < mmain.tbl2.getRowCount(); i++) {
            int price = Integer.parseInt(mmain.tbl2.getValueAt(i, 1)+"");
            int cnt = Integer.parseInt(mmain.tbl2.getValueAt(i, 2)+"");

            str += mmain.tbl2.getValueAt(i, 0) + "/";
            str += (price * cnt) + "/";
            str += cnt + "<br>";
            // System.out.println(mmain.tbl2.getValueAt(i, 0)+"/"+
            // mmain.tbl2.getValueAt(i, 1)+"/"+
            // mmain.tbl2.getValueAt(i, 2)); 랑 같다!

            saveStr += mmain.tbl2.getValueAt(i, 0) + "/";
            saveStr += (Integer.parseInt(mmain.tbl2.getValueAt(i, 1)+"") * Integer.parseInt(mmain.tbl2.getValueAt(i, 2)+"")) + "/";
            saveStr += mmain.tbl2.getValueAt(i, 2) + "<br>";
        }
        for (int i = 0; i < mmain.tbl3.getRowCount(); i++) {
            int price = Integer.parseInt(mmain.tbl3.getValueAt(i, 1)+"");
            int cnt = Integer.parseInt(mmain.tbl3.getValueAt(i, 2)+"");

            str += mmain.tbl3.getValueAt(i, 0) + "/";
            str += (price * cnt) + "/";
            str += cnt + "<br>";

            saveStr += mmain.tbl3.getValueAt(i, 0) + "/";
            saveStr += (Integer.parseInt(mmain.tbl3.getValueAt(i, 1)+"") * Integer.parseInt(mmain.tbl3.getValueAt(i, 2)+"")) + "/";
            saveStr += mmain.tbl3.getValueAt(i, 2) + "<br>";
        }
        str += "</html>";
        lbl.setText(str);

        this.add(lbl);

        // 이미 이전 페이지에서 넘어온 값은 str에 담겨서 lbl에 출력되었다.

        // 파일 저장하기
        // 내 방식 - 맨 마지막에 <br>이 붙어있지만 화면에 출력되는 모양이랑 따로 저장할 수 있다...
        FileUtil.saveFile("order.txt", saveStr);
        // 샘 방식 - 마지막에 <br>까지 제거됨
        FileUtil.saveFile(str);

        // 여기 까지 오면 tbl2 와 tbl3의 모든 내용을 가지고 있다.
        // 이 내용을 파일에 출력하면 프로그램 끝.
    }
}