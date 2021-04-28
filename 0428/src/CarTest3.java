class Engine{
    int inline;//기통
    String fuel;//연료

    Engine(int inline, String fuel){
        this.inline = inline;
        this.fuel = fuel;
    }
}

class Gear{
    String gear;//오토, 수동

    Gear(String gear){
        this.gear = gear;
    }
}

class Car{
    String color;
    Engine e;
    Gear g;

    Car(int inline, String fuel, String gear, String color){
        e = new Engine(inline, fuel);
        g = new Gear(gear);
        this.color = color;
    }

    void printCar(){
        System.out.println("===자동차 정보===");
        System.out.println("기통: " + e.inline + "\n연료: " + e.fuel);
        System.out.println("기어: " + g.gear);
        //만약에 gear변수가 boolean타입이었다면~
        //삼항연산자를 사용해서 "기어: " + (g.gear==true?"오토":"수동")
        //이렇게 적을 수 있다~!
        System.out.println("색상: " + color);
    }
}

public class CarTest3 {
    //자동차에 관한 클래스 만들기
    public static void main(String[] args){
        Car c1 = new Car(4, "휘발유", "오토", "빨강");
        c1.printCar();
        Car c2 = new Car(6, "경유", "수동", "검정");
        c2.printCar();
    }
}
