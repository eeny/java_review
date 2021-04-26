public class Gugu {//2단을 x5까지 출력하기
    int x, y;

    void setNum(int a, int b){
        x = a;
        y = b;
    }
    void showData(){
        for(int i=1; i<(y+1); i++){
            System.out.println(x + "x" + i + "=" + (x*i));
        }
    }

    public static void main(String[] args) {
        Gugu g = new Gugu();
        g.setNum(2, 5);
        g.showData();
    }
}
