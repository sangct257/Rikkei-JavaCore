package Bai1;

import java.util.Scanner;

public class bai_tap_1 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Moi nhập bán kình hiình tròn : ");

        double radius = sc.nextDouble();

        double dienTich = Math.PI * radius * radius;

        System.out.printf("Diện tích hình tròn với bán kính là : %.2f - diện tích là : %.2f",radius,dienTich);

        sc.close();
    }
}
