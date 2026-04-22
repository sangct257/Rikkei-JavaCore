package Bai3;

import java.util.Scanner;

public class bai_tap_3 {
    public static void main(String[] args) {
        int mang[],n;
        Scanner sc = new Scanner(System.in);
        // nhập số phần tử
        do {
            System.out.println("Nhập số phần tử của mảng: ");
            n = sc.nextInt();
            if (n<0){
                System.out.println("Phải nhập vào số > 0");
            }
        } while (n < 0);

        mang = new int[n];

        // nhập từng phần tử mảng
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ "+(i+1)+": ");
            mang[i] = sc.nextInt();
        }

        // sắp xếp giảm dần
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            // {5,1,4,2}
            for (int j = i + 1; j < n; j++) {//5
                if (mang[j] > mang[maxIndex]) {
                    maxIndex = j;
                }
            }

            int temp = mang[i];
            mang[i] = mang[maxIndex];
            mang[maxIndex] = temp;
        }

        // in mảng
        System.out.println("Mảng sau khi sắp xếp giảm dần: ");
        for (int i = 0; i < n; i++) {
            System.out.print(mang[i] + " ");
        }

        // nhập số cần tìm
        int x;
        System.out.println("\nNhập số cần tìm:");
        x = sc.nextInt();


        // TÌM KIẾM TUYẾN TÍNH
        int index1 = -1;
        for (int i = 0; i < n; i++) {
            if (mang[i] == x) {
                index1 = i;
                break;
            }
        }


        // TÌM KIẾM NHỊ PHÂN (mảng giảm dần)
        int index2 = -1;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (mang[mid] == x) {
                index2 = mid;
                break;
            } else if (mang[mid] < x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        if (index1 != -1) {
            System.out.println("Tuyến tính: tìm thấy tại vị trí " + index1);
        } else {
            System.out.println("Tuyến tính: không tìm thấy");
        }

        if (index2 != -1) {
            System.out.println("Nhị phân: tìm thấy tại vị trí " + index2);
        } else {
            System.out.println("Nhị phân: không tìm thấy");
        }
    }
}
