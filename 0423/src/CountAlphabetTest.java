import java.util.Scanner;

class CountAlphabet {
    int vowels;//모음
    int consonants;//자음

    void count(String str) {//모음 판단하는 메서드
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'a': vowels++; break;
                case 'e': vowels++; break;
                case 'i': vowels++; break;
                case 'o': vowels++; break;
                case 'u': vowels++; break;
                default: consonants++;
            }
        }

        System.out.println("모음은 " + vowels + "개입니다.");
        System.out.println("자음은 " + consonants + "개입니다.");
    }
}

public class CountAlphabetTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("영어를 입력하세요: ");
        String str = sc.next();

        CountAlphabet ca = new CountAlphabet();
        ca.count(str);
    }
}
