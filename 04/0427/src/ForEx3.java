public class ForEx3 {
    //메서드 만들기
    //입력 받은 두 개 사이의 모든 단을 출력
	/*
	<출력 형태 1>
	2*1=2 2*2=4 ...
	...
	9*1=9 9*2=18 ...
	*/
    void multiply1(int s, int e){
        for(int i=s; i<=e; i++){
            for(int j=1; j<10; j++){
                System.out.print(i + "*" + j + "=" + (i*j) + "  ");
            }
            System.out.println();
        }
    }

    /*
    <출력 형태 2>
    2*1=2 ... 9*1=9
    ...
    2*9=18 ... 9*9=81
    */
    void multiply2(int s, int e){
        for(int i=1; i<10; i++){
            for(int j=s; j<=e; j++){
                System.out.print(j + "*" + i + "=" + (i*j) + "  ");
            }
            System.out.println();
        }
    }

    /*
    <출력 형태 1, 2, 3, 4>
    *		****		 *		****
    **		***		    **		 ***
    ***		**		   ***		  **
    ****	*		  ****		   *
    */
    void star1(String str){//str = "****"
        for(int i=0; i<str.length(); i++){
            for(int j=0; j<str.length(); j++){
                String c = "";
                c += str.substring(i, (j+1));
                System.out.println(c);
            }
        }
    }
    void star2(String str){//str = "****"
        for(int i=0; i<str.length(); i++){
            for(int j=str.length(); j>(str.length()-1); j--){
                String c = "";
                c += str.substring(i);
                System.out.println(c);
            }
        }
    }
    void star3(String str){//str = "****"

    }
    void star4(String str){//str = "****"

    }

    public static void main(String[] args){
        //1 ~100까지 출력하기
		/*
		for(int i=0; i<10; i++){
			for(int j=1; j<=10; j++){
				System.out.print((i*10) + j + " ");
			}
			System.out.println();//안의 for문이 한번 실행될 때마다 빠져나와서 줄바꿈하는 역할
		}
		*/

        ForEx3 f = new ForEx3();
        //f.multiply1(2, 9);
        //System.out.println();//결과 구분하려고 적음
        //f.multiply2(2, 9);
        f.star1("****");//실패 다시 풀어야함!!!
        //f.star2("****");//성공
    }
}
