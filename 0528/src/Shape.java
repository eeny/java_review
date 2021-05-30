public abstract class Shape {
    // abstract class 추상클래스
    // 추상 클래스는 일반 클래스(구현된 일반 메서드를 가짐) + 구현되지 않은 메서드를 가졌다!
    // 구현되었다? 메서드의 바디{ } 실행 내용을 쓰는 부분이 있다는 뜻.

    abstract void printAbstract();// 추상 메서드
    // 추상 "클래스". 추상 클래스를 다른 클래스에서 사용하기 위해서는
    // 예약어 extends 상속을 사용한다!
    // 추상 클래스를 상속받을 경우 반드시 추상 클래스가 가지고 있는 추상 메서드를 구현해야한다.
    // (인터페이스와 비슷!)

    void printSahpe() {
        System.out.println("Shape");
    }
}