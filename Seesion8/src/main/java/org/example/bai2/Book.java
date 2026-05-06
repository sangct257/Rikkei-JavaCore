package org.example.bai2;

public class Book {
    private String title;
    private String author;
    private Double price;

    public Book() {
    }

    public Book(String title, String author, Double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Title: <" + title +
                ">, Author: <" + author +
                ">, Price: " + price + ">";
    }

    public static void main(String[] args) {
        Book book = new Book("Lập trình java","Nguyễn Văn A",1000000d);
        System.out.println(book);
    }
}
