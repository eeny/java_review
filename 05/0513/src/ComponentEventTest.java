import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
//p421 예제
public class ComponentEventTest extends JFrame implements ComponentListener, FocusListener {
    JTextArea display;

    public ComponentEventTest() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 200);
        this.setTitle("Window Event Test");

        this.addComponentListener(this);
        this.addFocusListener(this);

        this.setVisible(true);
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        display("componentHidden() 메소드 호출");
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        display("componentMoved() 메소드 호출");
    }

    @Override
    public void componentResized(ComponentEvent e) {
        display("componentResized() 메소드 호출");
    }

    @Override
    public void componentShown(ComponentEvent e) {
        display("componentShown() 메소드 호출");
    }

    @Override
    public void focusGained(FocusEvent e) {
        display("focusGained() 메소드 호출");
    }

    @Override
    public void focusLost(FocusEvent e) {
        display("focusLost() 메소드 호출");
    }

    private void display(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        new ComponentEventTest();
    }
}