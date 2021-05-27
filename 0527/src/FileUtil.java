import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JLabel;
import javax.swing.JTable;

// 기능만 가진 클래스
public class FileUtil {
    // 행 개수 구하는 메서드
    static int getRowCount(String filename) {
        int cnt = 0;
        File f = new File(filename);// 파일 읽어오기
        FileReader fr = null;// 한 글자씩
        BufferedReader br = null;// 한 줄씩

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            // === 읽기 위한 세팅 끝 ====

            // === 코드가 실제로 읽어오는 부분 ===
            while (br.readLine() != null) {
                cnt++;// 한 줄 읽으면 +1
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return cnt;
    }
    // 열 개수 구하는 메서드 (웬만하면 고정값이므로 안 쓰는 게 효율적이다. 리소스 잡아먹으니까...)
	/*static int getColumnCount(String filename) {
		int cnt = 0;
		File f = new File(filename);// 파일 읽어오기
		FileReader fr = null;// 한 글자씩
		BufferedReader br = null;// 한 줄씩

		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			// === 읽기 위한 세팅 끝 ====

			// === 코드가 실제로 읽어오는 부분 ===
			// 한 줄 읽어와서 잘라서 그 개수 = 컬럼 개수
			cnt = br.readLine().split("/").length;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return cnt;
	}*/

    static String[][] getFile(String filename) {
        // 미리 getRowCount를 실행해서 파일의 총 몇 줄인지 알아오고
        // 그 줄 수에 맞게 배열을 만든다.
        String[][] data = new String[getRowCount(filename)][2];

        File f = new File(filename);// 파일 읽어오기
        FileReader fr = null;// 한 글자씩
        BufferedReader br = null;// 한 줄씩

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            // === 읽기 위한 세팅 끝 ====

            // === 코드가 실제로 읽어오는 부분 ===
            String l = null;
            int i = 0;
            while ((l = br.readLine()) != null) {
                data[i][0] = l.split("/")[0];
                data[i][1] = l.split("/")[1];
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    // 파일 저장하는 메소드
    // 내 방식
    static void saveFile(String filename, String saveStr) {
        File f = new File(filename);
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(f, true);
            pw = new PrintWriter(fw);
            pw.println(saveStr);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    // 샘 방식
    static void saveFile(String str) {
        File f = new File("savemenu.txt");
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(f, true);// 새로운 내용이 들어올 때마다 연결해서 써진다!
            pw = new PrintWriter(fw);
            // 쓰기 세팅 끝

            // str 양 옆의 html 부분 떼는 방법
            str = str.replace("<html>", "");
            str = str.replace("</html>", "");

            // 마지막에 붙은 <br> 떼는 방법
            // 처음부터 시작해서 마지막 <br> 앞까지 자르기
            str = str.substring(0, str.lastIndexOf("<br>"));

            pw.println(str);// 딱 이거 한 줄!

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}
