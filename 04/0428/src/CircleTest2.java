class Point2{
    private int x, y;

    public Point2(int x, int y){
        this.x = x;
        this.y = y;
    }

    void printPoint(){
        System.out.println(x + " : " + y);
    }
}

class Circle2{
    private int radius = 0;

    private Point2 center;

    public Circle2(int x, int y, int r){
        center = new Point2(x, y);//값을 넘겨받은 Point클래스를 여기서 바로 생성한다!
        radius = r;
    }

    void printCircle(){
        center.printPoint();
        System.out.println(radius);
    }
}

public class CircleTest2 {
    public static void main(String[] args){
        Circle2 c = new Circle2(1, 2, 10);
        //Circle클래스를 생성하면서 Point클래스 생성값도 같이 넘긴다!
        //따로 메인에서 Point클래스를 생성하지 않아도 된다!
        c.printCircle();
    }

}
