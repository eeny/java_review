public class Average {
    //정수 2개와 정수 3개의 평균을 구하는 메서드
    int result;

    void getAverage(int a, int b){//2개의 정수 평균
        result = (a + b)/2;
        System.out.println("정수 2개의 평균은 " + result);
    }
    void getAverage(int a, int b, int c){//3개의 정수 평균
        result = (a + b + c)/3;
        System.out.println("정수 3개의 평균은 " + result);
    }

    public static void main(String[] args){
        Average a = new Average();
        a.getAverage(2, 4);
        a.getAverage(2, 4, 6);
    }
}
