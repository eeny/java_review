class Human2{
    //객체에서 상태의 정보를 가지고 있는 것 = 필드 = 전역 변수 = 클래스 변수
    private String name;
    private int age;

    public Human2(String name, int age){
        this.name = name;
        this.age = age;
    }

    //toString() : 눈에 안보이지만 모든 클래스가 무조건 갖고 있는 메서드
    //				클래스를 생성한 변수를 출력할 때 자동으로 호출됨! - 주소값이 출력됨!

    @Override//오타 방지용!
    public String toString(){//모든 클래스는 Object로부터 상속!
        return name + "/" + age;//원래는 Object에서 객체의 주소값을 출력하는 메서드인데 재정의했다!
        //이 메서드는 객체의 현재 상태를 반환한다!
    }

    String getName(){
        return name;
    }

    int getAge(){
        return age;
    }

    void setName(String name){
        this.name = name;
    }

    void setAge(int age){
        this.age = age;
    }

    public static void main(String[] age){
        Human2 h1 = new Human2("춘향", 18);
        Human2 h2 = new Human2("몽룡", 21);
        Human2 h3 = new Human2("사또", 50);
        System.out.println(h1.toString());
        System.out.println(h1);//h2.toString()이랑 같다!
        System.out.println(h2.toString());
        System.out.println(h2);
        System.out.println(h3.toString());
        System.out.println(h3);
    }
}