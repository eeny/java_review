//p281 예제
class Shape2 {
    int x, y;
}

class Rectangle2 extends Shape2 {
    int width, height;

}

public class ShapeTest2 {
    public static void main(String[] args) {
        Shape2 s;

        Rectangle2 r = new Rectangle2();
        s = r;//부모 클래스 타입의 자식 클래스를 생성해서 넣는 것은 가능!
        //s가 결과!!!!

        s.x = 0;//x는 원래 부모꺼니까 가능
        s.y = 0;

//		s.width = 100; //에러! width는 자식꺼니까 불가능
//		s.height = 100;

        Rectangle2 rr = (Rectangle2)s;
        //s가 결과지만 내부적으로는 Rectangle2를 가지고 있다.
        //그냥은 못쓰지만 형변환을 하게 되면 원래 형태로 돌아온다.
        rr.width = 100; //그래서 이게 가능하다!

        //Rectangle2 rrr = new Shape2(); //이렇게 그냥 쓸 수는 없다!!!
        //Rectangle2는 반드시 Shape부터 만들어지고 나서 만들어지기 때문에
        //부모를 만들어서 자식에 집어넣을 수가 없다!!!
        //자식은 부모가 있어야지만 존재할 수 있다.
        //자식은 부모의 유전자를 가지고 있지만, 자식이 부모보다 먼저 만들어 질 수 없다.
        Rectangle2 rrr = (Rectangle2) new Shape2();
        //Rectangle2 rrr = new Rectangle2(); 이랑 같은 의미!!!
        //자식의 유형을 가지고 미리 세팅해 놓고 부모를 만들기 때문에 가능하다.
        //부모가 만들어지면서 자식도 같이 만들어지는 형태!
    }
}