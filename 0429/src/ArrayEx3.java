import java.util.Scanner;

public class ArrayEx3 {
    public static void main(String[] args){
		/*
		System.out.println(args[0]);
		System.out.println(args[1]);
		//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
		//들어있는 값이 없어서 에러가 발생한다
		//메인에 있는 args도 사용하려면 할 수는 있다! 근데 아예 쓸 일이 없다~~!!!
		*/

        //1. 배열 정의 - 크기 할당(new)
        Scanner sc = new Scanner(System.in);
        System.out.print("배열의 크기를 정해주세요: ");
        int size = sc.nextInt();
        int[] data = new int[size];
        //배열은 변수의 집합 = 변수에다가 번호를 붙인다
        //1. 배열의 크기를 정한다. => new를 이용해서 크기를 미리 정해야 쓸 수 있다.
        //int[] data = new int[100];

        System.out.println("만드신 배열의 크기는(size) " + size + "입니다.");
        System.out.println("만드신 배열의 크기는(data.length) " + data.length + "입니다.");

        System.out.println("숫자를 " +  data.length + "개 입력해 주세요.");
        int total = 0;

        for(int i=0; i<data.length; i++){//data.length == size
            System.out.println((i+1) + "번째 숫자를 입력하세요.");
            data[i] = sc.nextInt();
            total += data[i];
        }
        System.out.println("평균은 " + (total/data.length) + "입니다.");
    }

}
