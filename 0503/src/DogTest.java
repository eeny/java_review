class Animal{
    void sound(){
        System.out.println("안녕?");
    }
}

class Dog extends Animal{
    //super.sound();//강제로 부모의 메서드 호출

    //@Override (어노테이션, 애노테이션) - 내가 오버라이딩 한다는 것을 명시적으로 보여주는 역할!
    @Override//부모의 메서드를 수정해서 쓸 것이다! - 오버라이딩 할 것이다! 이름 형태 무조건 동일해야한다!!!
    void sound(){//오버라이딩 - 부모로부터 상속받은 메서드의 이름을 그대로 쓰면서 내용을 바꿈
        System.out.println("멍멍!!!");
    }

    void sound(int i){//이건 그냥 Dog클래스가 가진 메서드. 상속이랑 상관없다.
        int x; int y;
    }
}

public class DogTest{
    public static void main(String[] args){
        Dog d = new Dog();
        d.sound();//멍멍!!!
        //만약 Dog에 sound()라는 메서드가 없다면 부모클래스의 sound()가 실행된다!
    }
}