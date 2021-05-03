//주사위 굴리는 메서드 만들기
class Dice{
    int face = (int)(Math.random()*6)+1;

    void roll(){
        System.out.println("주사위를 굴립니다~~~");
        System.out.println("주사위 값: " + face);
    }
}

public class DiceTest {
    public static void main(String[] args){
        Dice d = new Dice();
        d.roll();
    }
}
