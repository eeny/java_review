public interface Drawable {
    // interface는 표준을 정한다!
    // 이 인터페이스를 사용하면 반드시 구현되어 있지 않은 메서드를 구현해줘야 한다!
    // => @override : 상속받거나 구현했을 때 그 메서드를 내용만 새로 작성해 주는 것
    // 인터페이스는 여러개 동시에 가능하고 이 때 불러오는 예약어가 implements

    void printDraw();
}