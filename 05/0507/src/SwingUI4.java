import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class SwingUI4 extends JFrame  {
    public SwingUI4() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("SwingEx");
        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("src");
        DefaultMutableTreeNode child11 = new DefaultMutableTreeNode("(default package)");
        DefaultMutableTreeNode child111 = new DefaultMutableTreeNode("DefaultPack.java");
        DefaultMutableTreeNode child112 = new DefaultMutableTreeNode("PackageEx.java");
        DefaultMutableTreeNode child113 = new DefaultMutableTreeNode("SwingUI1.java");

        root.add(child1);
        child1.add(child11);
        child11.add(child111);
        child111.add(child112);
        child112.add(child113);

        JTree tree = new JTree(root);

        JScrollPane sp = new JScrollPane(tree);

        this.add(sp);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SwingUI4();
    }
}