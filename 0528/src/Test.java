public class Test {
    int myRan(int s, int e){// s 시작값, e 끝값
        int result = 0;
        // s와 e 사이의 랜덤을 만들어서 result에 담기
        // Math.random을 이용해서 코드 작성

        // 나는 풀지 못했다... (출처 - https://blog.metafor.kr/130)
        result = (int)(Math.random()*(e - s) + 1) + s;

        return result;
    }

    void printSum(int i, int j) {
        System.out.println(i + j);
    }

    int multi(int i, int j) {
        return i*j;
    }

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.myRan(1, 10));// 1~10 사이의 랜덤값
        System.out.println(t.myRan(2, 5));// 2~5 사이의 랜덤값
        System.out.println(t.myRan(10, 20));// 10~20 사이의 랜덤값

        // ===== 메서드 설명 =====
        // 메서드의 return 타입이 출력 가능한 타입이라면
        // System.out.print로 메서드 자체를 출력할 수 있다.
        // 메서드 자체를 출력한다는 말은 return의 값을 출력하는 것과 같다!

        // 두 수의 합과 곱을 구하는 메서드 2개 만들기 (각 매개변수 포함 만들기)
        t.printSum(10,20);//30
        t.printSum(2,5);//7
        System.out.println(t.multi(10,20));//200
        System.out.println(t.multi(2,5));//10
    }
}