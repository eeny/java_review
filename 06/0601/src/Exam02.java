import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exam02 {
    public static void main(String[] args) {
        String lyrics = "A-Ha! Listen boy" + "My first love story" + "My angel & My girls"
                + "My sunshine ah! ah! Let's go!" +

                "너무너무 멋져 눈이 눈이 부셔" + "숨을 못 쉬겠어 떨리는 Girl" + " Gee Gee Gee Gee Baby Baby Baby"
                + " Gee Gee Gee Gee Baby Baby Baby" + "Oh 너무 부끄러워 쳐다볼 수 없어" + "사랑에 빠졌어 수줍은 Girl"
                + " Gee Gee Gee Gee Baby Baby Baby" + " Gee Gee Gee Gee Be Be Be Be Be Be" +

                "(어떻게 하죠) 어떡 어떡하죠" + "(떨리는 나는) 떨리는 나는요" + "(두근 두근 두근 두근) 두근 두근거려" + "밤엔 잠도 못 이루죠" + "나는 나는 바본가 봐요"
                + "그대 그대밖에 모르는 바보" + "그래요 그댈 보는 난" +

                "너무 반짝반짝 눈이 부셔" + "No No No No No" + "너무 깜짝깜짝 놀란 나는" + "Oh Oh Oh Oh Oh" + "너무 짜릿짜릿 몸이 떨려"
                + " Gee Gee Gee Gee Gee " + "Oh 젖은 눈빛 Oh Yeah" + "Oh 좋은 향기 Oh Yeah Yeah Yeah" +

                "Oh 너무너무 예뻐 맘이 너무 예뻐 " + "첫눈에 반했어 꼭 찍은 Girl" + " Gee Gee Gee Gee Baby Baby Baby"
                + " Gee Gee Gee Gee Baby Baby Baby" + "너무나 뜨거워 만질 수가 없어" + "사랑에 타 버려 후끈한 Girl"
                + " Gee Gee Gee Gee Baby Baby Baby" + " Gee Gee Gee Gee Be Be Be Be Be Be" +

                "(어쩌면 좋아) 어쩌면 좋아요" + "(수줍은 나는) 수줍은 나는요" + "(몰라 몰라 몰라 몰라) 몰라 몰라 하며" + "매일 그대만 그리죠" + "친한 친구들은 말하죠"
                + "정말 너는 정말 못말려 바보" + "하지만 그댈 보는 난" +

                "너무 반짝반짝 눈이 부셔" + "No No No No No" + "너무 깜짝깜짝 놀란 나는" + "Oh Oh Oh Oh Oh" + "너무 짜릿짜릿 몸이 떨려"
                + " Gee Gee Gee Gee Gee " + "Oh 젖은 눈빛 Oh Yeah" + "Oh 좋은 향기 Oh Yeah Yeah Yeah" +

                "말도 못했는 걸 너무 부끄러워하는 난" + "용기가 없는 걸까 어떡해야 좋은 걸까" + "두근두근 맘 졸이며 바라보고 있는 난" +

                "너무 반짝반짝 눈이 부셔 (Oh)" + "No No No No No" + "너무 (Ha) 깜짝깜짝 놀란 나는 " + "Oh Oh Oh Oh Oh (Oh Woa Oh Yeah)"
                + "너무 짜릿짜릿 몸이 떨려 (떨려와)" + " Gee Gee Gee Gee Gee " + "Oh 젖은 눈빛 Oh Yeah" + "Oh 좋은 향기 Oh Yeah (Oh Yeah)" +

                "너무 반짝반짝 눈이 부셔 (눈이 부셔)" + "No No No No No (No No No)" + "너무 깜짝깜짝 놀란 나는 (깜짝깜짝 놀란 나는)"
                + "Oh Oh Oh Oh Oh (Oh Oh Oh)" + "너무 짜릿짜릿 몸이 떨려 (떨려와) " + "Gee Gee Gee Gee Gee " + "Oh 젖은 눈빛 Oh Yeah"
                + "Oh 좋은 향기 Oh Yeah Yeah Yeah";

        // 위의 가사에서 Gee는 몇 번 나오는가?
        String[] arr = lyrics.split(" ");
        List<String> list = Arrays.asList(arr);
        System.out.println("Gee의 개수는? " + Collections.frequency(list, "Gee"));
        // 정답 : 52
    }
}