import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileEx {
    void open() throws FileNotFoundException {
        // throws는 이 메소드를 사용하는 다른 메소드에서 대신 예외를 처리하라고 던진다!
        File file = new File("test.txt");
        FileReader fr = new FileReader(file);
    }

    void read() {
        try {// throws로 던져도 중간에 try-catch 해주면 이후로는 throws 안해도 예외가 잡힌다!
            open();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileEx fe = new FileEx();
        fe.read();
    }
}