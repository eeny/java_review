class Rectangle{
    int w, h;//w는 가로, h는 세로
    int area(int w, int h){//사각형의 넓이
        int result1 = w*h;
        return result1;
    }
    int perimeter(int w, int h){//사각형의 둘레
        int result2 = (w+h)*2;
        return result2;
    }
}

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle();
        System.out.println("사각형의 넓이는? " + rec.area(3, 5));
        System.out.println("사각형의 둘레는? " + rec.perimeter(3, 5));
    }
}
