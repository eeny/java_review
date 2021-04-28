class Product2{
    String name;//제품명
    boolean isDan;//위험여부
    int price;//가격
    String producer;//생산자

    Product2(String name, int price){
        this.name = name;
        this.price = price;
        this.producer = "PP";
        this.isDan = false;
    }
    Product2(String name, int price, boolean isDan){
        this.name = name;
        this.price = price;
        this.producer = "PP";
        this.isDan = isDan;
    }
    Product2(String name, int price, String producer){
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.isDan = false;
    }
    Product2(String name, int price, boolean isDan, String producer){
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.isDan = isDan;
    }
}

class People2{
    String name;
    String id;
    int gender;//1: 남자 2: 여자
    int age;
    String addr;

    People2(String name, String id, int gender, int age, String addr){
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.addr = addr;
    }
}

class Order2{
    int orderNum;
    People2 people;
    Product2 product;

    Order2(int orderNum, String pName, int price, String name, String id, int gender, int age, String addr){
        product = new Product2(pName, price);
        people = new People2(name, id, gender, age, addr);

        this.orderNum = orderNum;
    }

    void printOrder(){
        System.out.println("주문번호: " + orderNum);
        System.out.println("주문자명: " + people.name);
        System.out.println("주문자 주소: " + people.addr);
        System.out.println("제품명: " + product.name);
        System.out.println("가격: " + product.price);
    }
}

public class OrderTest2 {
    public static void main(String[] args){
        Order2 or = new Order2(1, "냉장고", 50000, "최씨", "aaaa", 1, 18, "대연");
        or.printOrder();
    }

}
