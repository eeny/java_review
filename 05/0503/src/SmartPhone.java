class Computer{
    private String brand;
    private String cpu;
    private String os;

    public Computer(String brand, String cpu, String os){
        this.brand = brand;
        this.cpu = cpu;
        this.os = os;
    }

    void turnOn(){
        System.out.println("전원이 켜집니다.");
    }

    void turnOff(){
        System.out.println("전원이 꺼집니다.");
    }

    String getBrand(){
        return brand;
    }

    String getCpu(){
        return cpu;
    }

    String getOs(){
        return os;
    }

    void setBrand(String brand){
        this.brand = brand;
    }

    void setCpu(String cpu){
        this.cpu = cpu;
    }

    void setOs(String os){
        this.os = os;
    }

    public String toString(){
        return brand + " / " + cpu + " / " + os;
    }
}

class laptop extends Computer{
    private int weight;

    public laptop(String brand, String cpu, String os, int weight){
        super(brand, cpu, os);
        this.weight = weight;
    }

    int getWeight(){
        return weight;
    }

    void setWeight(int weight){
        this.weight = weight;
    }

    @Override
    public String toString(){
        return super.toString() + " / " + weight;
    }
}

class desktop extends Computer{
    private String mouse;

    public desktop(String brand, String cpu, String os, String mouse){
        super(brand, cpu, os);
        this.mouse = mouse;
    }

    @Override
    public String toString(){
        return super.toString() + " / " + mouse;
    }
}

public class SmartPhone extends laptop{
    private  String color;

    SmartPhone(String brand, String cpu, String os, int weight, String color){
        super(brand, cpu, os, weight);
        this.color = color;
    }

    @Override
    public String toString(){
        return super.toString() + " / " + color;
    }

    public static void main(String[] args){
        SmartPhone sp1 = new SmartPhone("삼성", "스냅드래곤865+", "안드로이드", 192, "브론즈");
        System.out.println(sp1);
        SmartPhone sp2 = new SmartPhone("애플", "Apple Lightning 듀얼코어", "ios", 194, "화이트");
        System.out.println(sp2);
    }
}