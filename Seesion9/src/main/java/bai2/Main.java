package bai2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book[] listBooks = {
                new Book("Java", "James", 100.0),
                new Book("Python", "Guido", 120.0),
                new Book("C++", "Bjarne", 150.0)
        };
        System.out.println("------ LIST OF BOOKS ------");

        for (Book b : listBooks){
            b.printInfo();
        }
    }
}
