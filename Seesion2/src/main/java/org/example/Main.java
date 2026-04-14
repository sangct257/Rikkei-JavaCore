package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // trước java 8
//        Date birthday;
//
//        Scanner sc = new Scanner(System.in);
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        System.out.println("Nhận vào ngày sinh của bạn :");
//
//        try {
//            birthday = sdf.parse(sc.nextLine());
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("Ngày sinh của bạn: "+sdf.format(birthday));
//        System.out.println("Ngày sinh không định dạng: "+birthday);

        // java 8
        LocalDate birthday;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Nhập vào ngày sinh của bạn: ");
        Scanner sc = new Scanner(System.in);

        birthday = LocalDate.parse(sc.nextLine(), formatter);

        System.out.println("Ngày sinh của bạn: "+birthday);
        System.out.println("Ngày sinh của bạn có format: "+birthday.format(formatter));
    }
}