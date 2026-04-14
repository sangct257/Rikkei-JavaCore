package Bai3;

import java.util.Scanner;

public class bao_tap_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập số nguyên N, có thể âm hoặc dương, được nhập từ bàn phím :");
        int n = sc.nextInt();

        int temp = n;
        if (temp < 0){
            temp = -temp;
        }

        int tong = 0;
        while (temp > 0){
            int du = temp % 10; // chia lấy dư
            tong += du; //Tổng dư
            temp = temp / 10; // loại bỏ từng chữ số cuối cùng khi lấy dư
        }

        System.out.println("Tổng các chữ số "+ n +" là : "+tong);
    }
}
