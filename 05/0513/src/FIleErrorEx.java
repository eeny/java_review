import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FIleErrorEx {
    int list[];
    final int SIZE = 10;

    public FIleErrorEx() {
        list = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            list[i] = i;
        }//list[0]~[9] => 0 ~ 9
        writeList();
    }

    public void writeList() {
        PrintWriter pw = null;//메서드 안에 있으니까 초기값 필요!

        File f = new File("out.txt");
        FileWriter fw;
        try {
            fw = new FileWriter(f);
            pw = new PrintWriter(fw);//PrintWriter의 메서드 중에 println이 있다. 이게 제일 만만하다.

            for (int i = 0; i < SIZE; i++) {
                //System.out.println(list[i]);//콘솔창에 출력
                pw.println(list[i]);//out.txt 파일에 출력 - 파일에 쓴다는 뜻
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pw.close();//예외가 생기건 말건 일단 저장하고 종료하라는 뜻
            System.out.println("저장 완료!");
        }
    }

    public static void main(String[] args) {
        new FIleErrorEx();
    }
}