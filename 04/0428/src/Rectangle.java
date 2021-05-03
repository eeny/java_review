public class Rectangle {
    int w, h;//가로 세로

    Rectangle(){
        w = 50;
        h = 50;
        result();
    }
    Rectangle(int x){//정사각형
        w = x;
        h = x;
        result();
    }
    Rectangle(int w, int h){//직사각형
        this.w = w;
        this.h = h;
        result();
    }
    void result(){
        System.out.println("넓이는: " + (w*h));
        System.out.println("가로는: " + w + "  세로는: " + h);
    }

    public static void main(String[] args){
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(30);
        Rectangle r3 = new Rectangle(40, 70);
    }
}
