class Movie{
    String title, director;//제목, 감독
    double grade;//평점
    int year;//발표 연도
    void print(String title, double grade, String director, int year){
        System.out.println("제목은 " + title);
        System.out.println("평점은 " + grade);
        System.out.println("감독은 " + director);
        System.out.println("발표된 연도는 " + year);
    }
}

public class MovieTest {
    public static void main(String[] args) {
        Movie m = new Movie();
        m.print("해리포터와 마법사의 돌", 9.9, "크리스 콜럼버스", 2001);
    }
}
