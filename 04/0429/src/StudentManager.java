import java.util.Scanner;

class Student{
    //학생  - 이름/국어/영어/수학
    private String name;
    private int kor;
    private int eng;
    private int math;
    //총점, 평균
    private int total;
    private int average;

    //생성자
    public Student(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        totalScore();
        averageScore();
    }

    //getter, setter 만들기
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

    //총점
    void totalScore(){
        total = kor + eng + math;
    }

    //평균
    void averageScore(){
        average = (kor + eng + math)/3;
    }

    //전체 정보 출력
    void printStudent(){
        System.out.println("이름: " + name + " 국어: " + kor + " 영어: " + eng + " 수학: " + math + " 총점: " + total + " 평균: " + average);
    }
}

public class StudentManager {
    Scanner sc = new Scanner(System.in);
    Student[] st;

    //생성자
    public StudentManager(){
        st = new Student[5];//5개의 Student 객체를 배열에 담았다

        for (int i=0; i<st.length; i++){//NullPointerException 방지하기 위해 초기값 설정
            st[i] = new Student("정보없음", 0, 0, 0);
        }
    }

    void insertStudent(int idx){//정보 입력
        System.out.println("학생의 이름을 입력: ");
        String name = sc.next();
        System.out.println("국어 점수를 입력: ");
        int kor = sc.nextInt();
        System.out.println("영어 점수를 입력: ");
        int eng = sc.nextInt();
        System.out.println("수학 점수를 입력: ");
        int math = sc.nextInt();

//        st[idx].setName(name);
//        st[idx].setKor(kor);
//        st[idx].setEng(eng);
//        st[idx].setMath(math);
        //위의 방법대로 하니까 생성자 안에 메서드는 실행이 안돼서 총점, 평균에 값이 안들어간다!

        st[idx] = new Student(name, kor, eng, math);
    }

    void selectStudent(int idx){//정보 출력
        st[idx].printStudent();
    }

    void deleteStudent(int idx){//정보 삭제
        st[idx].setName("정보없음");
        st[idx].setKor(0);
        st[idx].setEng(0);
        st[idx].setMath(0);
    }

    void startManager(){
        for (;;){
            System.out.println("===메뉴를 선택하세요===");
            System.out.println("1.정보입력 2.정보출력 3.정보삭제 4.종료");
            int menu = sc.nextInt();

            if (menu==4) {//4.종료
                System.out.println("종료됩니다.");
                break;
            } else if(menu!=1 && menu!=2 && menu!=3 && menu!=4){
                System.out.println("잘못된 입력");
                continue;
            }

            System.out.println("학생번호를 입력: ");
            int idx = sc.nextInt();

            if (menu==1) {//1.정보입력
                insertStudent(idx);
            } else if (menu==2) {//2.정보출력
                selectStudent(idx);
            } else if (menu==3) {//정보삭제
                deleteStudent(idx);
                System.out.println("삭제되었습니다.");
            }
        }
    }

    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        sm.startManager();
    }
}
