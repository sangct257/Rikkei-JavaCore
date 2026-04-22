package Bai1;

import java.util.Scanner;

public class bai_tap_1 {
    public static void main(String[] args) {
        int mang[],n;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhập vào số phần tử mảng :");
            n = sc.nextInt();
            if (n < 1){
                System.out.println("Vui lòng nhập số phần tử > 0");
            }
        } while ( n < 1);

        mang = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ "+(i+1)+": ");
            mang[i] = sc.nextInt();
        }

        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (mang[j] < mang[j + 1]) {
                    int temp = mang[j];
                    mang[j] = mang[j + 1];
                    mang[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        System.out.println("Mảng sau khi sắp xếp giảm dần:");
        for (int i = 0; i < n; i++) {
            System.out.print(mang[i] + " ");
        }
    }
}
