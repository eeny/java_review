import java.util.Scanner;

public class ArrayTest5{
    final static int STUDENTS = 5;

    private static void getValues(int[] array){//매개변수 = 같은 주소값의 배열
        Scanner scan = new Scanner(System.in);

        for(int i=0; i<array.length; i++){
            System.out.print("성적을 입력하시요: ");
            array[i] = scan.nextInt();
        }
    }

    private static void getAverage(int[] array){//매개변수 = 같은 주소값의 배열
        int total = 0;

        for(int i=0; i<array.length; i++){
            total += array[i];
        }
        System.out.println("평균 성적은 " + total / array.length + "입니다.");
    }

    public static void main(String[] args){//메인메서드
        int[] scores = new int[STUDENTS];
        getValues(scores);//scores배열객체 안의 데이터가 아닌 객체의 주소값을 넘긴다
        getAverage(scores);
    }
}