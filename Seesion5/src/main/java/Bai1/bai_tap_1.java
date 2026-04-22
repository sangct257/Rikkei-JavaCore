package Bai1;

import java.util.Scanner;

public class bai_tap_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập địa chỉ email : ");

        // Nhập chuỗi
        String inputEmail = sc.nextLine();

        // Loại bỏ khoảng trắng
        String emailToValidate = inputEmail.trim();

        // Khai báo chuỗi regex kiểm tra định dạng email
        String emailRegex =
                "^[a-zA-Z0-9._]+" // ^: Chốt chặn bắt đầu chuỗi. // username: Cho phép chữ cái viết thường và viết hoa, số, dấu chấm, gạch dưới, +: Ít nhất phải có 1 ký tự.
                        + "@"     // @: Ký tự bắt buộc để ngăn cách user và domain.
                        + "[a-zA-Z0-9.]+" // domain: Cho phép chữ cái viết thường và viết hoa, số, dấu chấm, +: Ít nhất phải có 1 ký tự.

                        + "\\.[a-zA-Z]{2,6}$"; // Đuôi miền: \\. : Đại diện cho dấu chấm (.) thực sự trên bàn phím.
                                                // [a-zA-Z] : Đuôi miền chỉ được phép là chữ cái.
                                                // {2,6} : Giới hạn độ dài đuôi miền từ 2 đến 6 ký tự (VD: vn, com, edu...).
                                                // $ : Chốt chặn kết thúc chuỗi, không cho phép nhập dư ký tự rác ở cuối.

        // Kiểm tra
        if (emailToValidate.matches(emailRegex)){
            System.out.println("=> Kết quả: Email hợp lệ");
        } else {
            System.out.println("=> Kết quả: Email không hợp lệ");
        }
        System.out.println(emailToValidate);
        sc.close();
    }
}
