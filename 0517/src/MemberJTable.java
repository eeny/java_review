import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MemberJTable extends JFrame {

    public MemberJTable() {
        this.setDefaultCloseOperation(3);
        this.setSize(700, 300);

        String[] header = {"번호", "아이디", "비밀번호", "이름", "메일", "성별"};
        String[][] contents = new String[5][6];// 5줄 6칸

        File f = new File("member.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String l = null;

            int i = 0;
            while ((l = br.readLine()) != null) {// while이 for문이라고 치자!
                String[] str = l.split("/");

                // contents에 값을 추가하는 코드 방법 1
				/*contents[i][0] = str[0];
				contents[i][1] = str[1];
				contents[i][2] = str[2];
				contents[i][3] = str[3];
				contents[i][4] = str[4];
				contents[i][5] = str[5];*/

                // contents에 값을 추가하는 코드 방법 2
				/*for (int j = 0; j < 6; j++) {
					contents[i][j] = str[j];
				}*/

                // contents에 값을 추가하는 코드 방법 3
                // contents[행][열]
                // contents[줄][칸]
                // str 자체가 한 줄 짜리 배열이기 때문에 2중 배열의 데이터로서 입력 가능
                contents[i] = str;

                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JTable tbl = new JTable(contents, header);
        JScrollPane sp = new JScrollPane(tbl);

        this.add(sp);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MemberJTable();
    }
}