public class MyRandom {
    // public static으로 접근지정을 해줘야 패키지가 다른 클래스에서도
    // 객체 생성 없이 바로 사용할 수 있다!!!
    public static int hiRandom(int s, int e) {
        // 랜덤 코드
        // int result = (int)(Math.random() * e + s);// 0 ~ 9

        int result = s + ((int)(Math.random()*((e-s)+1)));

        // int로 형변환을 하면 소수점 이하가 잘린다!
        // 따라서 +1을 해주면 1 ~ 10 숫자가 나온다.
        // Math.random() => 0 ~ 0.99999...

        // 0 * 10 = 0
        // 0.1 * 10 = 1
        // 0.2 * 10 = 2
        // 0.3 * 10 = 3
        // 0.4 * 10 = 4

        // e 가 7일 때
        // 0 * 7 = 0
        // 0.1 * 7 = 0
        // 0.2 * 7 = 1
        // 0.3 * 7 = 2
        // 0.4 * 7 = 2

        return result;
    }

    public static void main(String[] args) {
        MyRandom mr = new MyRandom();
        // int ran = mr.hiRandom(1, 10);
        int ran = mr.hiRandom(5, 7);
        System.out.println(ran);
    }

}