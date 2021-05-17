import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MakeRealFile {
    public static void main(String[] args) {
        File f = new File("pw.txt");
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(f);// 실제 파일로 생성한다
            pw = new PrintWriter(f);// 파일을 읽어들인다

            pw.println("파일이 만들어지고 있습니다.");
            pw.println("만들어질 파일명은 pw.txt");
            pw.println("쓰기가 끝나면 반드시 해줘야 하는 작업이 있다.");
            pw.println("close() 안하면 파일에 내용이 저장되지 않는다.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}