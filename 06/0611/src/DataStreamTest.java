import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest {// 633 예제
    public static void main(String[] args) throws IOException {
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            int c;

            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.bin")));
            out.writeDouble(3.14);
            out.writeInt(100);
            out.writeUTF("자신의 생각을 바꾸지 못하는 사람은 결코 현실을 바꿀 수 없다.");

            out.flush();
            in = new DataInputStream(new BufferedInputStream(new FileInputStream("data.bin")));

            System.out.println(in.readDouble());
            System.out.println(in.readInt());
            System.out.println(in.readUTF());
            // 넣은 순서대로 double, int, utf 순서가 아니면 에러가 발생한다!
            // 넣은 순서 그대로 read를 해야 제대로 출력이 된다!

        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}