package Bai5;

import java.util.Scanner;

public class bai_tap_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Moi nhap can nang (kg) :");
        float canNang = sc.nextFloat();
        System.out.print("Moi nhap chieu cao (m) :");
        float chieuCao = sc.nextFloat();

        float BMI = canNang / (chieuCao * chieuCao);

        System.out.printf("Ket qua BIM = %f / (%f * %f) = %f",canNang,chieuCao,chieuCao,BMI);
        sc.close();
    }
}
