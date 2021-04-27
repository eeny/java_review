public class Book2 {
    private String title, author;

    void setTitle(String str){
        title = str;
    }
    String getTitle(){
        return title;
    }
    void setAuthor(String str){
        author = str;
    }
    String getAuthor(){
        return author;
    }

    public static void main(String[] args){
        Book2 b = new Book2();
        b.setTitle("해리포터와 마법사의 돌");
        b.setAuthor("조앤.K.롤링");
        System.out.println("제목은 " + b.getTitle());
        System.out.println("저자는 " + b.getAuthor());
    }
}
