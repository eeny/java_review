public class Circle {
    double r;//반지름
    int cx;//중심 x좌표
    int cy;//중심 y좌표

    //접근자 설정자 메서드
    void setR(double x){
        r = x;
    }
    double getR(){
        return r;
    }
    void setCx(int x){
        cx = x;
    }
    int getCx(){
        return cx;
    }
    void setCy(int x){
        cy = x;
    }
    int getCy(){
        return cy;
    }

    double area(){//원의 넓이를 구하는 메서드
        return r*r*3.14;
    }

    public static void main(String[] args){
        Circle c = new Circle();
        c.setR(5);//반지름이 5라고 가정했다
        System.out.println("반지름이 " + c.getR() + "일 때 원의 넓이는 " + c.area());
    }
}
