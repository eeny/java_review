class Human{
    //객체에서 상태의 정보를 가지고 있는 것 = 필드 = 전역 변수 = 클래스 변수
    private String name;
    private int age;
    private String profession;

    public Human(String name, int age){
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

    public String getProfession(){
        return profession;
    }

    void setName(String name){
        this.name = name;
    }

    void setAge(int age){
        this.age = age;
    }
}

public class Student extends Human{
    private String major;

    Student(String name, int age, String major){
        //강제로 Human(){} <= 이 빈생성자를 찾아서 생성하려고 하지만 없다! 따라서 에러 발생!
        //그래서 수동으로 부모 생성자를 호출해야 한다!
        super(name, age);
        this.major = major;
    }

    void setMajor(String major){
        this.major = major;
    }

    String getMajor(){
        return major;
    }

    @Override
    public String getProfession(){//오버라이드 할 때는 접근지정자까지 전부 똑같게 해야한다!
        return super.getProfession();
    }

    @Override
    public String toString(){
        //return super.getName() + "/" + super.getAge() + "/" + major;
        return super.toString() + "/" + major;

        //그냥 name이랑 age를 가져오려고 하면 private이라서 에러 발생!
        //super도 그냥 super만 쓸 수 없다! super.toString이나 super.name 처럼 다른 거랑 같이 써야한다!
    }

    public static void main(String[] args){
        Student std = new Student("춘향", 18, "학생");
        Student std2 = new Student("명진", 21, "컴퓨터");
        Student std3 = new Student("춘배", 25, "왕자님");
        System.out.println(std);//std.toString() 이랑 똑같다!
        System.out.println(std2);
        System.out.println(std3);
    }
}