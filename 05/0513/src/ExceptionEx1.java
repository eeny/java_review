import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ExceptionEx1 {
    public static void main(String[] args) throws IOException {
        File f = new File("twitter.png");
        Image img = ImageIO.read(f);
        //throws IOException <= 가상머신 예외처리
        //ImageIO.read(f);를 사용한다면 반드시 예외처리를 해야한다!
        //예외처리를 안하면 아예 사용을 할 수 없다!
        //컴파일 후 실행을 담당하는 가상머신에게 예외처리를 떠넘긴다.
        //특별한 상황에 개발자가 처리할 필요는 없지만 반드시 예외처리를 해야할 때 사용한다!
		
		/*try {//try-catch는 개발자가 직접 처리하는 예외
			Image img = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }
}