package Bai4;

import java.util.Scanner;

public class bai_tap_4 {
    public static void main(String[] args) {
        int mang[],n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập vào số phần tử của mảng: ");
        n = sc.nextInt();

        if (n == 0){
            System.out.println("Mảng không có phần tử");
            return; // thông báo lỗi và dừng luôn
        }

        mang = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Phần tử thứ "+(i+1)+": ");
            mang[i] = sc.nextInt();
        }

        // tạo mảng mơới để sắp xếp thứ tự
        int result[] = new int[n];
        int index = 0;

        // lấy ra số chẵn
        for (int i = 0; i < n; i++) {
            if (mang[i] % 2 == 0){
                result[index] = mang[i];
                index++;
            }
        }

        // lấy ra số lẻ
        for (int i = 0; i < n; i++) {
            if (mang[i] % 2 != 0){
                result[index] = mang[i];
                index++;
            }
        }

        System.out.println("Mảng sau khi sắp xếp: ");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i]+ " ");
        }
    }
}
