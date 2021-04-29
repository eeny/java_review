public class Car9 {
    int gear;
    String color;
    static int carNum;//클래스 자체 소속. 이 클래스를 생성하는 모든 객체는 이 static 공유
    //static은 변수/메서드에 붙일 수 있으며 생성을 안해도 사용 가능하다.

    Car9(int gear, String color){
        this.gear = gear;
        this.color = color;
        carNum++;
        //this.carNum++ <= this가 생략됨
    }

    void printCar(){
        System.out.println("기어 : " + gear + ", 색상: " + color + ", 번호: " + carNum);
    }

    public static void main(String[] args){
        Car9.carNum++;
        //소속(클래스명).변수 => static변수가 된다! 아래의 모든 생성에 영향을 미친다!

        Car9 c1 = new Car9(4, "파랑");
        c1.gear++;//이거는 c1의 변수만 바뀐다!
        c1.printCar();//번호: 2
        Car9 c2 = new Car9(6, "노랑");
        c2.printCar();//번호: 3
        Car9 c3 = new Car9(8, "빨강");
        c3.printCar();//번호: 4

        //c1.printCar();//번호: 3
        //c2.printCar();//번호: 3
        //c3.printCar();//번호: 3
        //맨 밑에 놔두면 carNum이 동일해진다
    }
}
