package Bai2;

import java.util.Scanner;

public class bai_tap_2 {
    public static void main(String[] args) {
        int mang[][],rows,columns;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào độ dài dòng :");
        rows = sc.nextInt();

        System.out.println("Nhập vào độ dài cột :");
        columns = sc.nextInt();

        mang = new int[rows][columns];
        int sumChan = 0;
        int sumLe  = 0;

        System.out.println("Nhập các phần tử của mảng :");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Phần tử ["+i+"]["+j+"] : \t");
                mang[i][j] = sc.nextInt();
                if (mang[i][j] % 2 == 0){
                    sumChan += mang[i][j];
                } else {
                    sumLe += mang[i][j];
                }
            }
        }

        System.out.println("Tổng các phần tử chẵn :"+sumChan);
        System.out.println("Tổng các phần tử lẻ :"+sumLe);

    }
}
