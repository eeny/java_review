import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThisMonthCalendar extends JFrame {
    public ThisMonthCalendar() {
        this.setDefaultCloseOperation(3);
        this.setSize(400, 400);

        // North
        JPanel pnlNorth = new JPanel();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 dd일 EEE요일");
        String today = sdf.format(new Date());
        JLabel lbl = new JLabel(today);
        pnlNorth.add(lbl);

        // Center
        JPanel pnlCenter = new JPanel(new GridLayout(0, 7));
        String[] dayOfTheWeek = {"일", "월", "화", "수", "목", "금", "토"};
        for (int i = 0; i < dayOfTheWeek.length; i++) {
            JLabel dowLbl = new JLabel(dayOfTheWeek[i]);
            dowLbl.setHorizontalAlignment(JLabel.CENTER);
            pnlCenter.add(dowLbl);
        }

        JLabel[] lbls = new JLabel[42];
        for (int i = 0; i < lbls.length; i++) {
            String str = "" + i;
            if (i < 6 || i > 36) {
                str = "";
            } else {
                str = "" + (i-5);
            }
            lbls[i] = new JLabel(str);
            lbls[i].setHorizontalAlignment(JLabel.CENTER);
            pnlCenter.add(lbls[i]);
        }

        this.add(pnlNorth, "North");
        this.add(pnlCenter, "Center");
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ThisMonthCalendar();
    }
}