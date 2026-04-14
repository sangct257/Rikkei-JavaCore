package Bai2;

import java.util.Scanner;

public class bai_tap_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập số nguyên từ 1 đến 12 (tương ứng với tháng) :");
        int thang = sc.nextInt();
        switch (thang){
            case 1,3,5,7,8,10,12 :
                System.out.println("Tháng " + thang + ": có 31 ngày");
                break;
            case 4,6,9,11 :
                System.out.println("Tháng "+ thang +": có 30 ngày");
                break;
            case 2 :
                System.out.println("Tháng "+thang +": có 28 hoặc 29 ngày");
                break;
            default:
                System.out.println("Tháng không hợp lệ.");
        }
    }
}
