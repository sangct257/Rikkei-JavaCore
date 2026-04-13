package Bai3;

import java.util.Scanner;

public class bai_tap_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Moi nhap so a :");
        int tu1 = sc.nextInt();

        System.out.print("Moi nhap so b :");
        int mau1 = sc.nextInt();

        System.out.print("Moi nhap so c :");
        int tu2 = sc.nextInt();

        System.out.print("Moi nhap so d :");
        int mau2 = sc.nextInt();

        int tongTu = (tu1 * mau2) + (tu2 * mau1) ;
        int tongMau = mau1 * mau2;

        System.out.printf("Ket qua la : %d / %d + %d / %d = (%d * %d) + (%d * %d) / %d * %d = %d / %d",tu1,mau1,tu2,mau2,tu1,mau2,tu2,mau1,mau1,mau2,tongTu,tongMau);

        sc.close();
    }
}
