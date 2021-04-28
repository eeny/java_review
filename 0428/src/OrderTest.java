class Product{
    String name;//제품명
    boolean isDan;//위험여부
    int price;//가격
    String producer;//생산자

    Product(String name, int price){
        this.name = name;
        this.price = price;
        this.producer = "PP";
        this.isDan = false;
    }
    Product(String name, int price, boolean isDan){
        this.name = name;
        this.price = price;
        this.producer = "PP";
        this.isDan = isDan;
    }
    Product(String name, int price, String producer){
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.isDan = false;
    }
    Product(String name, int price, boolean isDan, String producer){
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.isDan = isDan;
    }
}

class People{
    String name;
    String id;
    int gender;//1: 남자 2: 여자
    int age;
    String addr;

    People(String name, String id, int gender, int age, String addr){
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.addr = addr;
    }
}

class Order{
    int orderNum;
    People people;
    Product product;

    Order(int orderNum, People people, Product product){
        this.orderNum = orderNum;
        this.people = people;
        this.product = product;
    }

    void printOrder(){
        System.out.println("주문번호: " + orderNum);
        System.out.println("주문자명: " + people.name);
        System.out.println("주문자 주소: " + people.addr);
        System.out.println("제품명: " + product.name);
        System.out.println("가격: " + product.price);
        System.out.println();
    }
}

public class OrderTest {
    public static void main(String[] args){
        Product pr1 = new Product("갤럭시 버즈", 100000, "삼성");
        People pe1 = new People("홍길동", "aaaa1", 1, 25, "부산시 해운대구");

        Product pr2 = new Product("엘지 그램", 1500000, true);
        People pe2 = new People("김철수", "bbbb2", 1, 30, "부산시 수영구");

        Product pr3 = new Product("하리보 젤리", 3000);
        People pe3 = new People("김영희", "cccc3", 2, 15, "부산시 진구");

        Order or1 = new Order(1, pe1, pr1);
        or1.printOrder();

        Order or2 = new Order(1, pe2, pr2);
        or2.printOrder();

        Order or3 = new Order(1, pe3, pr3);
        or3.printOrder();
    }
}
