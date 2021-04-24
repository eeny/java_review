class Complex{
    int real;//실수
    int imag;//허수

    void print(){
        System.out.println(real + "+" + imag + "i");
    }
}

public class ComplexTest {
    public static void main(String[] args) {
        Complex cp = new Complex();
        cp.real = 10;
        cp.imag = 20;
        cp.print();
    }
}
