import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyLines {
    public static void main(String[] args) {//p622 예제
        //선생님 방식 코드

        //나중에 finally{}에서 close()하려고 전역으로 뺐다!
        //메서드 안의 변수라서 초기값을 줘야한다!
        File f = null;
        FileReader fr = null;
        BufferedReader br = null;

        File f2 = null;
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            f = new File("input.txt");//이 파일을 찾아서 읽어와라~
            fr = new FileReader(f);//한 개씩 읽어오는 클래스
            br = new BufferedReader(fr);//한 줄씩 읽어오는 클래스
            //파일 읽어오기 준비 끝

            //파일 쓰기
            f2 = new File("output.txt");//이 파일을 찾아서 가져와라~
            fw = new FileWriter(f2);//f2가 있다면 그 파일에 쓰고, 없다면 만들어서 쓴다! 한 개씩 쓰는 클래스
            pw = new PrintWriter(fw);//여러 줄 씩 쓰는 클래스

            String l;
            while((l = br.readLine()) != null) {//한 줄 읽어온 것을 변수 l에 담아서 출력을 해야한다.
                //한 줄씩 읽어 오다가 더이상 내용이 없을 때(null) 까지
                System.out.println(l);//l에는 한 줄의 내용이 담겨있고, 그것을 콘솔에 출력

                pw.println(l);//한 줄 읽어온 l의 내용을 파일(output.txt)에 출력
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();//발생하는 예외를 그냥 콘솔에 출력
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//생성한 역순으로 파일을 닫아줘야한다.
            try {
                if (br != null) {
                    br.close();
                }
                //어차피 마지막에 생성된 것만 닫으면 그 전에 생성된 것도 같이 닫힌다!
                //따라서 다른 건 적어도 되고 안적어도 되고
//				if (fr != null) {
//					fr.close();
//				}

                if (pw != null) {
                    pw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //책 코드 그대로 입력한 것

		/*BufferedReader inputStream = null;
		PrintWriter outputStream = null;

		try {
			inputStream = new BufferedReader(new FileReader("input.txt"));
			outputStream = new PrintWriter(new FileWriter("output.txt"));

			String l;

			while ((l = inputStream.readLine()) != null) {
				outputStream.println(l);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}

			if (outputStream != null) {
				outputStream.close();
			}
		}*/
    }
}
