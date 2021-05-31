import static java.lang.Math.*;

public class StaticPackage {
    public static void main(String[] args) {
        // double ran = Math.random();
        // 여기서 Math가 패키지명!
        // random은 static 메서드라서 random()을 포함하는 클래스를
        // new 하지않아도 사용할 수 있다.

        double ran = random();
        // 위에서 import를 해서 이렇게 바로 쓸 수도 있다!
        // 정적(static) import 하게 되면 바로 사용할 수 있는데,
        // 코드가 더 길어지므로 이런식으로 쓰지는 않는다!

    }
}