import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScanTest {// p625 예제
    public static void main(String[] args) throws IOException {
        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("input.txt")));

            while (s.hasNext()) {
                // 한 줄씩 읽어오다가 ,(콤마)를 만나면 한 줄로 인식한다!
                s.useDelimiter(",");

                System.out.println(s.next());
            }

        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}