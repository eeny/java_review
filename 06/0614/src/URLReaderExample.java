import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLReaderExample {// p657예제
    public static void main(String[] args) throws Exception {
        try {
            // URL 주소니까 주소 입력한 객체
            URL oracle = new URL("https://www.oracle.com/java/technologies/");

            BufferedReader in = new BufferedReader(// 한 줄 씩 읽기
                    new InputStreamReader(// 읽어들이기
                            oracle.openStream()));// file, System.in, 주소를 열어라

            String inLine;

            while ((inLine = in.readLine()) != null) {
                System.out.println(inLine);
            }

            in.close();

        } catch (MalformedURLException e) {
            System.out.println(e);
        }
    }
}