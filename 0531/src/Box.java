public class Box<T> {// p536 예제
    // T는 타입을 의미한다.
    // 무슨 타입이든 타입을 넣으라는 뜻!
    private T data;

    public void set(T data) {
        this.data = data;
    }

    public T get() {
        return data;
    }
}