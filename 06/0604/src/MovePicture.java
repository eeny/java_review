import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MovePicture extends JFrame implements Runnable {
    String[] imgName = {"car1.gif", "car2.gif", "car3.gif"};// 이미지 파일 배열
    ImageIcon[] imgs;// 이미지아이콘 배열
    JLabel[] lbls;// 이미지아이콘을 붙일 라벨 배열

    public MovePicture() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        this.setLayout(null);// 오른쪽에서 사진이 슉~~와야한다

        imgs = new ImageIcon[imgName.length];
        lbls = new JLabel[imgName.length];
        makeImgLbls();

        this.setVisible(true);
    }

    void makeImgLbls() {
		/*for (int i = 0; i < imgName.length; i++) {
			imgs[i] = new ImageIcon(imgName[i]);
		}
		for (int i = 0; i < imgName.length; i++) {
			lbls[i] = new JLabel(imgs[i]);
			this.add(lbls[i]);
		}*/
    }

    @Override
    public void run() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MovePicture();
    }
}