public class StaticEx2 {
    public static void main(String[] args){
        double ran = Math.random();//random
        String num1 = "1";
        int num2 = 2;
        int result = Integer.parseInt(num1) + num2;
		/*
		Integer.parseInt() 도 static이란 것을 알 수 있다!
		Integer i = new Integer();
		int num3 = i.parseInt(num1);
		원래는 이런식으로 객체 생성을 해야하는데 static이면 생성을 안해도 된다!
		필요할 때 바로 바로 쓸 수 있어서 효율적이다!
		*/
        System.out.println(num1 + num2);//출력 결과: 12
        System.out.println(result);//출력 결과: 3
    }

}
