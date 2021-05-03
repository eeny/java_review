public class ArrayTest2{
    public static void main(String[] args){
        int[][] arr = new int[10][10];//[행][열] 총 100칸

        int x = 0;

        for(int i=0; i<10; i++){//1~10
            for(int j=0; j<10; j++){//11~20
                x++;
                arr[i][j] = x;

                System.out.print("["+i+"]["+j+"]="+arr[i][j]+(arr[i][j]<10?" ":" "));
            }
            System.out.println();//10개씩 보기 좋게 출력하려고~~
        }
		/*
		//안에 집어 넣어도 된다~~~!!!
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				System.out.print("["+i+"]["+j+"]="+arr[i][j]+(arr[i][j]<10?"   ":" "));
			}
			System.out.println();
		}
		*/
    }
}