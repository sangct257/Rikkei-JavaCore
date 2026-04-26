package Bai2;

import java.util.Scanner;

public class bai_tap_2 {
    public static void main(String[] args) {
        String fullName = "", email = "", password ="" ,soDienThoai ="";
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("**********QUẢN LÝ NGƯỜI DÙNG************");
            System.out.println("1. Nhập thông tin người dùng ");
            System.out.println("2. Chuẩn hoá họ tên ");
            System.out.println("3. Kiểm tra email hợp lệ ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ ");
            System.out.println("6. Thoát ");
            System.out.print("Lựa chon của bạn : ");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon){
                case 1:
                    System.out.print("Mời nhập họ tên : ");
                    fullName = sc.nextLine();
                    System.out.print("Mời nhập email : ");
                    email = sc.nextLine();
                    System.out.print("Mời nhập số điện thoại : ");
                    soDienThoai = sc.nextLine();
                    System.out.print("Mời nhập mật khẩu : ");
                    password = sc.nextLine();

                    System.out.println("Họ tên là : "+fullName);
                    System.out.println("Email là : "+email);
                    System.out.println("Số điện thoại là : "+soDienThoai);
                    System.out.println("Mật khẩu là : "+password);
                    break;
                case 2:
                    fullName= fullName.trim().toLowerCase(); // xóa khoảng trắng + về chữ thường
                    String[] arr = fullName.split("\\s+"); // tách chuỗi dựa theo 1 hay nhiều khoảng trắng hoặc tab
                    String result = ""; // kết quả
                    for (int i = 0; i < arr.length; i++) {
                        result += arr[i].substring(0,1).toUpperCase() + arr[i].substring(1) + " "; // viết hoa chữ đầu + phần còn lại + 1 khoảng trắng
                    }
                    System.out.println("Họ tên sau khi chuẩn hoá : "+result.trim());
                    break;
                case 3:
                    String regexEmail = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
                    if (email.matches(regexEmail)){
                        System.out.println("Email hợp lệ");
                    }else {
                        System.out.println("Email không hợp lệ");
                    }
                    break;
                case 4:
                    String regexSoDienThoai = "^0\\d{9}$";
                    if (soDienThoai.matches(regexSoDienThoai)){
                        System.out.println("Số điện thoại hợp lệ");
                    } else {
                        System.out.println("Số điện thoại không hợp lệ");
                    }
                    break;
                case 5:
                    String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*+-=]).{8,}$";
                    if (password.matches(regexPassword)){
                        System.out.println("Mật khẩu hợp lệ ");
                    } else {
                        System.out.println("Mật khẩu không hợp lệ");
                    }
                    break;
                case 6:
                    System.out.println("Thoát chương trình!");
                    System.exit(0);
                default:
                    System.out.println("Chon sai!");
            }
        }
    }
}
