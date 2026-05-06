package bai2;

public class Book {
    private String title;
    private String author;
    private double price;

    public void printInfo(){
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Price: "+price);
        System.out.println();
    }
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
