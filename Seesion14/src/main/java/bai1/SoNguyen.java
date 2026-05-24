package bai1;

import java.util.Scanner;

public class SoNguyen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        while (true){
            try {
                System.out.println("Mời nhập 1 số nguyên: ");
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0) {
                    System.out.println("Số nhập vào không hợp lệ để kiểm tra số nguyên tố (phải lớn hơn 0)");
                } else {
                    if (isPrime(n)) {
                        System.out.println(n + " : là số nguyên tố ");
                        break;
                    } else {
                        System.out.println(n + " : không phải số nguyên tố ");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Dữ liệu nhập vào không phải là một số nguyên!");
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false; // Số 1 không phải là số nguyên tố
        }
        // Kiểm tra từ 2 đến căn bậc hai của n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // Chia hết cho số khác ngoài 1 và chính nó
            }
        }
        return true;
    }
}
