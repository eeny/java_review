class OuterClass {//p289예제
    private String secret = "Time is money";

    public OuterClass() {
        InnerClass obj = new InnerClass();
        obj.print();
    }

    private class InnerClass {
        public InnerClass() {
            System.out.println("내부 클래스 생성자입니다.");
        }

        public void print() {
            System.out.println(secret);//위에 private인데 자기 변수처럼 쓸 수 있다!
        }
    }
}

public class OuterClassTest {
    public static void main(String[] args) {
        new OuterClass();
    }
}