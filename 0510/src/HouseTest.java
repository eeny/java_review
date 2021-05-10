abstract class House {
    int power;
    String country;

    abstract void consent();

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    void printHouse() {
        System.out.println(country + "/" + power);
    }
}

class UsHouse extends House {
    public UsHouse() {
        consent();
    }

    @Override
    void consent() {
        this.country = "US";
    }

}

class KrHouse extends House {
    public KrHouse() {
        consent();
    }

    @Override
    void consent() {
        this.country = "KR";
    }
}

public class HouseTest {
    public static void main(String[] args) {
        //추상 클래스는 추상 메서드를 1개 이상 가진다.
        //추상 메서드는 이 기능은 반드시 가지고 있어야 하지만
        //이 기능의 세부 내용은 이 클래스를 사용하는 사용자에게 맡긴다~는 뜻
        UsHouse h = new UsHouse();
        h.consent();
        h.setPower(110);
        h.printHouse();

        KrHouse k = new KrHouse();
        k.consent();
        k.setPower(110);
        k.printHouse();
    }
}
