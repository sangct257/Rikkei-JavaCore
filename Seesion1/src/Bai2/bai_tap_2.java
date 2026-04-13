package Bai2;

import java.util.Scanner;

public class bai_tap_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Moi nhap so dau tien : ");
        int firstNumber = sc.nextInt();

        System.out.print("Moi nhap so thu hai : ");
        int secondNumber = sc.nextInt();

        int tong = firstNumber + secondNumber;
        int hieu = firstNumber - secondNumber;
        int tich = firstNumber * secondNumber;
        int thuong = firstNumber / secondNumber;

        System.out.printf("Tong 2 so : %d + %d = %d \n",firstNumber,secondNumber,tong);
        System.out.printf("Hieu 2 so : %d - %d = %d \n" ,firstNumber,secondNumber,hieu);
        System.out.printf("Tich 2 so : %d * %d = %d \n",firstNumber,secondNumber,tich);
        System.out.printf("Thuong 2 so : %d / %d = %d \n",firstNumber,secondNumber,thuong);

        sc.close();
    }
}
