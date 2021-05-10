import java.awt.*;
import javax.swing.*;

public class SwingUI2 extends JFrame {
    public SwingUI2() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 300);
        this.setLayout(new FlowLayout());

        //JSlider slider = new JSlider();//그냥 만들기

        //JSlider slider = new JSlider(JSlider.VERTICAL);//세로로 만들기

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 20);
        //						슬라이더 방향, 최소값, 최대값, 생성될 시 포인터의 위치
        slider.setMajorTickSpacing(10);//큰 눈금
        slider.setMinorTickSpacing(5);//작은 눈금
        slider.setPaintTicks(true);//눈금을 보여라~!
        slider.setPaintLabels(true);//큰 눈금에 숫자도 보여라~!
        //눈금이 꼭 필수인 건 아니다!

        //=====================슬라이더 끝 스피너 시작=============================

        String[] books = {"오만과편견", "달과6펜스", "데미안", "앵무새죽이기"};
        SpinnerListModel lmodel = new SpinnerListModel(books);
        //스피너 만들 때 무슨 타입의 스피너인지 정의하기 위해서 필수다!
        //여기서 만든 건 문자열 타입!
        JSpinner spinner = new JSpinner(lmodel);

        SpinnerDateModel dmodel = new SpinnerDateModel();
        //이거는 날짜 타입
        JSpinner spinner2 = new JSpinner(dmodel);

        SpinnerNumberModel nmodel = new SpinnerNumberModel(2, 0, 10, 0.5);
        //									처음 설정값, 최소값, 최대값, 증감값
        JSpinner spinner3 = new JSpinner(nmodel);

        this.add(slider);
        this.add(spinner);
        this.add(spinner2);
        this.add(spinner3);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SwingUI2();
    }
}