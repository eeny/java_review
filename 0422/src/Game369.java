public class Game369 {
    public static void main(String[] args) {
        //1~100 369게임
        //(짝은 무조건 한번만 치기로 가정했다)

		int totalStr = 0;//총 짝 개수의 합

		for(int i=1; i<101; i++){
			String str = Integer.toString(i);//짝
			//contains()는 대상 문자열에 특정 문자열이 포함되어 있는지 확인하는 함수!
			//Integer.toString()은 int타입을 String으로 형변환해주는 함수!

			if(str.contains("3")||str.contains("6")||str.contains("9")){
				str = "짝";
				totalStr++;
			}else{
				str = Integer.toString(i);
			}
            System.out.print(str + " ");

            if (i%10==0) {
                System.out.println();
            }
		}
		System.out.println("총 짝의 개수는? " + totalStr + "개");


        //선생님 답안
        /*
        int cnt = 0;

        for(int i=1;i<=100;i++){
            if((i%10 !=0) && (i%10)%3==0){//13, 23, 33, ..., 99
                System.out.print("짝 ");
                cnt++;
            }else if(i>10 && ((int)(i*0.1))%3==0){//첫 줄 영향 안받고, 10단위에 369 찾기
                System.out.print("짝 ");
                cnt++;
            }else{
                System.out.print(i + " ");
            }

            if(i%10==0){//10개씩 나눠서 출력하기
                System.out.println();
            }
        }

        System.out.println("짝의 개수는 " + cnt);
         */
    }
}
