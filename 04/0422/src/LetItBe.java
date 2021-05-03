import java.util.Scanner;

public class LetItBe {
    public static void main(String[] args) {
        //비틀즈 let it be 노래가사 중에서 입력받은 글자가 총 몇 개인지 출력
        //int lib = lyrics.length(); <= 전체 글자 개수 가져오기
        Scanner sc = new Scanner(System.in);

        String lyrics = "When I find myself in times of trouble Mother Mary comes to me Speaking words of wisdom let it be And in my hour of darkness She is standing right in front of me Speaking words of wisdom let it be Let it be let it be Let it be let it be Whisper words of wisdom let it be And when the broken-hearted people Living in the world agree There will be an answer let it be For though they may be parted There is still a chance that they will see There will be an answer let it be Let it be let it be Let it be let it be Yeah there will be an answer let it be Let it be let it be Let it be let it be Whisper words of wisdom let it be Let it be let it be Ah let it be yeah let it be Whisper words of wisdom let it be And when the night is cloudy There is still a light that shines on me Shine on until tomorrow let it be I wake up to the sound of music Mother Mary comes to me Speaking words of wisdom let it be Let it be let it be Let it be yeah let it be Oh there will be an answer let it be Let it be let it be Let it be yeah let it be Whisper words of wisdom let it be";
        int lib = lyrics.length();//270개
        int count = 0;//찾는 글자 총개수

        System.out.print("찾을 글자를 입력하세요: ");
        char str = sc.next().charAt(0);

        for(int i=0; i<lib; i++){//270번 반복
            if(lyrics.charAt(i)==str){
                count++;
            }
        }
        System.out.println("총 가사 글자수는 " + lib);
        System.out.print(str + " 은/는 총 " + count + "개 입니다.");
    }
}
