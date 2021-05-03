class Employee{
    String name, tel;//이름, 전화번호
    int salary;//연봉

    void setName(String str){
        name = str;
    }
    String getName(){
        return name;
    }
    void setTel(String str){
        tel = str;
    }
    String getTel(){
        return tel;
    }
    void setSalary(int x){
        salary = x;
    }
    int getSalary(){
        return salary;
    }
}

public class EmployeeTest {
    public static void main(String[] args){
        Employee e = new Employee();
        e.setName("홍길동");
        e.setTel("010-1234-5678");
        e.setSalary(5000);
        System.out.println("이름: " + e.getName());
        System.out.println("전화번호: " + e.getTel());
        System.out.println("연봉: "+ e.getSalary() + "만원");
    }
}
