import javax.swing.*;// *를 마지막에 쓰면 swing안에 모든 클래스를 import한다는 뜻!

public class Rectang {
    // package0528.Circle c = new package0528.Circle();
    // Circle c = new Circle(); 이라고 하면 같은 폴더에 없으므로 에러!
    // 하지만 패키지명을 써주면 가능하다!

    javax.swing.JButton btn = new javax.swing.JButton();
    // 이렇게 쓰면 import가 없어도 가능하다!
    // 이클립스 또는 인텔리J 같은 통합개발툴(IDE) 사용시 자동으로 import해주므로 의미 없다.

    JFrame f;
    JMenuItem item;
    JTextField tf;

    // 패키지명에 특별히 반드시 지켜야 할 룰은 없다.
    // 하지만 암묵적으로 어디 회사에서 만들었는가를 쓰도록 하고 있다.
    // company.com - graphic 가 있다고 하자.
    // 이 때 패키지 명은 com.company.graphic 이 된다.
    // => 회사 웹 주소를 거꾸로 쓰고 + 의미있는 폴더명으로 작성된다.
    // 만약 yahoo.co.kr에서 만든 util의 묶음이라면
    // kr.co.yahoo.util이라고 쓰면 된다.
    // => kr > co > yahoo > util > 여기 안에 클래스가 있다!
}