public class Multiple {
    public static void main(String[] args) {
        //1~100 중에서 3의 배수의 합
        int sum = 0;

        for(int i=1;i<101;i++){
            if(i%3==0){
                sum += i;
            }
        }

        System.out.println("총 합은: " + sum);
    }
}
