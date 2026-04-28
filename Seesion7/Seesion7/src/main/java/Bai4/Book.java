package Bai4;

public class Book {
    public String title;
    public String author;
    public double price;

    public void printInfo(){
        System.out.println("---------Thông tin sách------------");
        System.out.println("Tiêu đề : "+title);
        System.out.println("Tác giả : "+author);
        System.out.println("Giá : "+price);
    }

    public static void main(String[] args) {
        Book myBook = new Book();

        myBook.title = "Lập trình Java cơ bản";
        myBook.author = "Nguyễn Văn A";
        myBook.price = 100000.0;

        myBook.printInfo();
    }
}
