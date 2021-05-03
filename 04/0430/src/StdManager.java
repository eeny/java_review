import java.util.Scanner;

class Student{
    private String name;//private이라서 다른 클래스()에서 접근 못한다!
    private int kor, eng, math;

    public Student(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    //getter, setter 필수!!! private이라서
    //외부로부터 name의 값을 받아서 현재 클래스의 클래스 변수 name에 값을 넣기 위해 존재한다
    void setName(String name){
        this.name = name;
    }

    String getName(){
        return name;
    }

    void setKor(int kor){
        this.kor = kor;
    }

    int getKor(){
        return kor;
    }

    void setEng(int eng){
        this.eng = eng;
    }

    int getEng(){
        return eng;
    }

    void setMath(int math){
        this.math = math;
    }

    int getMath(){
        return math;
    }

    int getTotal(){//return의 값을 바로 출력할 수 있게! void면 값을 보여줄 수 없으니까!
        return kor + eng + math;
    }

    double getAvg(){//return의 값을 바로 출력할 수 있게! void면 값을 보여줄 수 없으니까!
        return (kor + eng + math)/3;
    }
}

public class StdManager{
    Student[] stds;
    Scanner sc;

    //배열 = 변수를 담을 "공간" 설정 = 변수 10개 만들기
    //현재는 값이 없는 변수 10개 - stds[0] ~ stds[9]까지
    public StdManager(){
        stds = new Student[10];
        sc = new Scanner(System.in);

        setInit();//앞에 this 있어도 되고 없어도 됨
        startManager();
    }

    void setInit(){//초기화 해주는 메서드
        for(int i=0; i<stds.length; i++){
            stds[i] = new Student("내용없음", 0, 0, 0);//실제값(new로 생성된 값)을 넣는다
        }
		/*
		Student std0 ~ std9 == Student[] stds = new Student[10]; 이거 한 줄 작업이랑
		
		Student std0 = new Student("내용없음", 0, 0, 0); 이거 여러 줄 작업이랑 같은 말이다!!!
		...
		Student std9 = new Student("내용없음", 0, 0, 0);
		*/
    }

    void printData(){
        for(int i=0; i<stds.length;i++){
            System.out.print("이름: " + stds[i].getName());
            System.out.print(" 국어: " + stds[i].getKor());
            System.out.print(" 영어: " + stds[i].getEng());
            System.out.print(" 수학: " + stds[i].getMath());
            System.out.print(" 총점: " + stds[i].getTotal());
            System.out.println(" 평균: " + stds[i].getAvg());
        }
    }

    void startManager(){
        System.out.println("===학사 관리 시스템===");//한 번만 출력할

        while(true){
            System.out.print("1.정보입력 2.정보검색 3.정보삭제 0.종료 : ");
            int menu = sc.nextInt();

            if(menu==0){
                System.out.println("종료합니다.");
                break;
                //while을 빠져나가서 while 이후의 내용을 실행함.
                //여기서는 while 이후 내용이 없어서 그냥 종료된다!
            }

            System.out.print("학생 번호를 입력해주세요: ");
            int idx = sc.nextInt();

            if(menu==1){
                System.out.print("이름을 입력해주세요: ");
                String name = sc.next();
                System.out.print("국어 성적을 입력해주세요: ");
                int kor = sc.nextInt();
                System.out.print("영어 성적을 입력해주세요: ");
                int eng = sc.nextInt();
                System.out.print("수학 성적을 입력해주세요: ");
                int math = sc.nextInt();

                stds[idx].setName(name);
                stds[idx].setKor(kor);
                stds[idx].setEng(eng);
                stds[idx].setMath(math);

                printData();//입력이 다끝나면 들어간 값 전체 출력하기
            }else if(menu==2){
                System.out.print("이름: " + stds[idx].getName());
                System.out.print(" 국어: " + stds[idx].getKor());
                System.out.print(" 영어: " + stds[idx].getEng());
                System.out.println(" 수학: " + stds[idx].getMath());

            }else if(menu==3){
                stds[idx].setName("내용없음");
                stds[idx].setKor(0);
                stds[idx].setEng(0);
                stds[idx].setMath(0);
            }
        }
    }

    public static void main(String[] args) {
        new StdManager();
        //StdManager sm = new StdManager(); 이렇게 안해도 된다!
        //생성만 해도 바로 실행되니까 변수에 담을 필요가 없다!
        //이렇게 하기 위해서는 모든 실행 절차를 반드시 생성자안에서 불러야 한다!
    }
}