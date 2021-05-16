import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

class MakeBoard extends JFrame implements ActionListener {
    public MakeBoard() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}

class ShowBoard extends JFrame {
    public ShowBoard() {

    }
}

public class MakeAndShowBoard {
    public static void main(String[] args) {
        new MakeBoard();
        //new ShowBoard();
    }
}