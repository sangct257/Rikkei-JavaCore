package Bai6;

import java.util.Scanner;

public class bai_tap_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.println("Mời nhập một số nguyên dương :");
            // Nếu người dùng không nhập vào số nguyên dương thì hiển thị thông báo “Số nhập vào không hợp lệ”
            // và yêu cầu người dùng nhập lại đến khi chính xác thì ngưng
            while (!sc.hasNextInt()){
                System.out.println("Số nhập vào không hợp lệ");
                sc.next();
            }
            n = sc.nextInt();
            if (n < 0) {
                System.out.println("Số nhập vào không hợp lệ! Vui lòng nhập số dương.");
            }

            // Sử dụng vòng lặp để duyệt qua các số từ 0 đến N.
            for (int i = 0; i <= n; i++) {
                if (isArmstrong(i)){
                    System.out.print(i+ " ");
                }
            }
        } while ( n < 0);
    }

    // hàm kiểm tra số có phải số có phải Armstrong
    public static boolean isArmstrong(int num) {
        if (num == 0) return true;

        // Với mỗi số, tính số chữ số của nó (k).
        int k = String.valueOf(num).length();

        // Tính tổng lũy thừa bậc k của từng chữ số.
        long sum = 0;
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, k);
            temp /= 10;
        }

        // So sánh
        return sum == num;
    }
}
