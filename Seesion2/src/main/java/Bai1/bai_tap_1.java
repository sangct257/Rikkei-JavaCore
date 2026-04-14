package Bai1;

import java.util.Scanner;

public class bai_tap_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhâ số nguyên N vào bán phím : ");
        int N = sc.nextInt();;

        if (N <= 0) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {
            int tong = 0;

            for (int i = 1; i < N; i++) {
                tong += i;
            }

            System.out.println("Tổng các số từ 1 đến " + N + " là : "+tong);
        }
    }
}
