import javax.swing.*;

public class LayoutEx17 extends JFrame {
    public LayoutEx17() {
        this.setDefaultCloseOperation(3);
        this.setSize(400, 300);
        JTextField tf = new JTextField();
        JTextArea ta = new JTextArea();

        //JScrollPane sp = new JScrollPane(ta);//디폴트가 needed
        JScrollPane sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        this.add(tf, "North");
        this.add(sp, "Center");

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutEx17();
    }
}