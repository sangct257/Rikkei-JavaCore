package Bai4;

import java.util.Scanner;

public class bai_tap_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Moi nhap chieu rong : ");
        float width = sc.nextFloat();

        System.out.print("Moi nhap chieu cao : ");
        float height = sc.nextFloat();

        float area = width * height;
        float perimeter = 2 * (width + height);

        System.out.printf("Dien tich hinh chu nhat : %f * %f = %f \n",width,height,area);
        System.out.printf("Chu vi hinh chu nhat : 2 * (%f + %f) = %f \n",width,height,perimeter);

        sc.close();
    }
}
