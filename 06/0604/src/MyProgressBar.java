import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class MyProgressBar extends JFrame implements ActionListener, Runnable {
    JProgressBar bar;
    int min = 0;
    int max = 1000;
    int value = 0;
    JButton btnStart, btnPause, btnStop;
    boolean isStop = true;

    public MyProgressBar() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 400);

        JPanel pnl = new JPanel();
        pnl.setBorder(BorderFactory.createEmptyBorder(50, 0, 30, 0));

        bar = new JProgressBar(min, max);
        bar.setPreferredSize(new Dimension(400, 70));
        bar.setValue(value);
        bar.setStringPainted(true);
        pnl.add(bar);

        JPanel pnl2 = new JPanel();
        pnl2.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        btnStart = new JButton(new ImageIcon("start.png"));
        btnStart.addActionListener(this);
        btnPause = new JButton(new ImageIcon("pause.png"));
        btnPause.addActionListener(this);
        btnStop = new JButton(new ImageIcon("stop.png"));
        btnStop.addActionListener(this);
        pnl2.add(btnStart);
        pnl2.add(btnPause);
        pnl2.add(btnStop);

        this.add(pnl, "Center");
        this.add(pnl2, "South");

        this.setVisible(true);
    }

    @Override
    public void run() {
        for (int i = 0; i <= max; i++) {
            if (isStop == false) {
                bar.setValue(value);
                break;
            }

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            bar.setValue(value + i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Thread t = new Thread(this);

        if (e.getSource() == btnStart) {
            isStop = true;
            new Thread(this).start();

        } else if (e.getSource() == btnPause) {
            value = bar.getValue();
            isStop = false;

        } else if (e.getSource() == btnStop) {
            value = 0;
            isStop = false;
        }
    }

    public static void main(String[] args) {
        new MyProgressBar();
    }
}