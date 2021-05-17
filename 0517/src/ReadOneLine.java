import java.io.*;

public class ReadOneLine {
    public static void main(String[] args) {
        File f = new File("member.txt");// 메모리 상의 파일을 담는 공간
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(f);// 한 글자 씩
            br = new BufferedReader(fr);// 한 줄 씩

            String l = null;// 읽어온 한 줄을 담을 변수

//			while ((l = br.readLine()) != null) {// 한 줄 읽어오고
//				br.readLine();// 다음 줄을 읽어버린다!
//			}

            while ((l = br.readLine()) != null) {
                // 한 줄 읽은 것을 l에 담고 null과 비교한다~
                System.out.println(l);
            }

        } catch (FileNotFoundException e) {// 파일이 없다! 는 예외
            e.printStackTrace();
        } catch (IOException e) {// input, output에 관여하는 예외
            e.printStackTrace();
        } finally {
            try {
                if(br != null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}