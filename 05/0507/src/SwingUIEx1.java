import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class SwingUIEx1 extends JFrame {//p467 트리 모양 따라 만들기
    public SwingUIEx1() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("나의문서함");
        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("편지");
        DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("음악");
        DefaultMutableTreeNode child21 = new DefaultMutableTreeNode("한국");
        DefaultMutableTreeNode child211 = new DefaultMutableTreeNode("그림");
        DefaultMutableTreeNode child22 = new DefaultMutableTreeNode("외국");
        DefaultMutableTreeNode child3 = new DefaultMutableTreeNode("소설");
        DefaultMutableTreeNode child31 = new DefaultMutableTreeNode("추리");

        root.add(child1);
        root.add(child2);
        child2.add(child21);
        child21.add(child211);
        child2.add(child22);
        root.add(child3);
        child3.add(child31);

        JTree tree = new JTree(root);
        JScrollPane sp = new JScrollPane(tree);

        this.add(sp);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SwingUIEx1();
    }
}