class Shape3 {
    int x, y;

    void draw() {
        System.out.println("Shape3 드로우");
    }
}

class Rectangle3 extends Shape3 {
    int w, h;

    void draw() {
        System.out.println("Rectangle3 드로우");
    }
}

class Triagle3 extends Shape3 {
    int base;

    void draw() {
        System.out.println("Triagle3 드로우");
    }
}

class Circle3 extends Shape3 {
    int radius;

    void draw() {
        System.out.println("Circle3 드로우");
    }
}

public class ShapeTest3 {
    Shape3[] shape;

    public ShapeTest3() {
        shape = new Shape3[3];
        shape[0] = new Rectangle3();
        shape[1] = new Triagle3();
        shape[2] = new Circle3();

        for (int i = 0; i < shape.length; i++) {
            shape[i].draw();
            //부모와 내가 같은 메서드를 갖고 있다면
            //비록 부모타입의 변수에 담았더라도 내가 오버라이드한 메서드를 실행시킨다!
        }
    }

    public static void main(String[] args) {
        new ShapeTest3();
    }

}