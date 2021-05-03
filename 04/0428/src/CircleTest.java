class Point{
    private int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    void printPoint(){
        System.out.println(x + " : " + y);
    }
}

class Circle{
    private int radius = 0;

    /*
    String str; //문자열을 담아서 여러가지 형태로 조작할 수 있는 클래스
    String str = new Sring("aaa"); //원래 이렇게 써야하는데
    String str = "aaa"; //이렇게도 가능하다
    생성하는 방법이 다르지만 같은 의미다~
    따라서 다른 클래스도 이런 방식으로 사용이 가능하다!!!
    */
    private Point center;//좌표 x, y를 가지고 있는 Point클래스

    //Circle(String str, int r){}//모양을 잘 이해해보자
    public Circle(Point p, int r){
        center = p;
        radius = r;
    }

    void printCircle(){
        //System.out.println(center + " : " + radius);

        //메인에서 p.printPoint();를 따로 호출하지 않고 같이 출력하기 위해서 이렇게~~
        center.printPoint();
        System.out.println(radius);
    }
}

public class CircleTest {
    public static void main(String[] args){
        //Circle c = new Circle(포인트 타입, 정수 타입);
        Point p = new Point(1, 2);
        Circle c = new Circle(p, 10);
        //p.printPoint();
        c.printCircle();
    }

}
