package Bai6;

import java.util.Scanner;

public class bai_tap_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Moi nhap van toc (km/h) :");
        float vanToc = sc.nextFloat();

        if (vanToc < 0) {
            System.out.println("Van toc phai > 0");
            sc.close();
            return;
        }

        System.out.print("Moi nhap thoi gian (gio) :");
        float thoiGian = sc.nextFloat();
        if (thoiGian < 0) {
            System.out.println("Thoi gian phai > 0");
            sc.close();
            return;
        }

        float quangDuong = vanToc * thoiGian;

        System.out.printf("Ket qua quang duong la : %f * %f = %f \n",vanToc,thoiGian,quangDuong);

        sc.close();
    }
}
