package Bai3;

import java.util.Scanner;

public class bai_tap_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mật khẩu :");
        String password = sc.nextLine();
        String passwordRegex = "^(?=.*[A-Z])" + // quét từ đầu đến cuối (.*) bắt buộc phải có 1 chữ in hoa
                "(?=.*[a-z])" + // quét từ đầu đến cuối (.*) bắt buộc phải có 1 chữ in thường
                "(?=.*\\d)" + // quét từ đầu đến cuối (.*) bắt buộc phải có ít nhất 1 chữ số (\d tương đương với [0-9])
                "(?=.*[@,#,$,!,%])" + // quét từ đầu đến cuối (.*) bắt buộc phải có ít nhất 1 ký tự đặc biệt (ví dụ: @, #, $, !, %)
                ".{8,}$"; // do độ dài từ đầu đến cuối tối thiểu là 8 k có giới hạn ký tự
        if (password.matches(passwordRegex)){
            System.out.println("Mật khẩu hợp lệ");
        } else {
            System.out.println("Mật khẩu không hợp lệ");
        }

        sc.close();
    }
}
