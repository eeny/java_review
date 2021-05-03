public class Point {
    int x, y;//2차원 좌표

    void setXY(int a, int b){
        x = a;
        y = b;
    }
    void print(){
        System.out.println("x좌표는 " + x + ", y좌표는 " + y);
    }

    public static void main(String[] args){
        Point p = new Point();
        p.setXY(3, 5);
        p.print();
    }
}
