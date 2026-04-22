package Bai5;

import java.util.Scanner;

public class bai_tap_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        while (true){
            System.out.println("****************************** MENU *******************************");
            System.out.println("1. Nhập chuỗi ");
            System.out.println("2. Đến số ký tự thường , hoa , số , đặc biệt");
            System.out.println("3. Đảo ngược chuỗi");
            System.out.println("4. Kiểm tra Palindrome");
            System.out.println("5. Chuẩn hoá chuỗi (xoá khoan trắng dư thừa , viết hoa chữ cái đầu");
            System.out.println("6. Thoát");
            System.out.println("********************************************************************");
            System.out.println("Lựa chọn chức nằng :");

            int chosse = Integer.parseInt(sc.nextLine());
            switch (chosse) {
                case 1:
                    System.out.println("Nhập chuỗi :");
                    str = sc.nextLine();
                    break;
                case 2:
                    if (str.isEmpty()){
                        System.out.println("Vui lòng chọn 1 trước.");
                        break;
                    }

                    int thuong = 0, hoa = 0, so = 0 , dacBiet = 0;
                    for (char c : str.toCharArray()){
                        if (Character.isLowerCase(c)) thuong++;
                        else if (Character.isUpperCase(c)) hoa++;
                        else if (Character.isDigit(c)) so++;
                        else dacBiet++;
                    }
                    System.out.println("Số ký tự thường: " + thuong);
                    System.out.println("Số ký tự hoa: " + hoa);
                    System.out.println("Số chữ số: " + so);
                    System.out.println("Số ký tự đặc biệt: " + dacBiet);
                    break;
                case 3:
                    if (str.isEmpty()){
                        System.out.println("Vui lòng chọn 1 trước.");
                        break;
                    }

                    String reversed = new StringBuilder(str).reverse().toString();
                    System.out.println("Chuỗi đảo ngược : " + reversed);
                    break;
                case 4:
                    if (str.isEmpty()){
                        System.out.println("Vui lòng chọn 1 trước.");
                        break;
                    }
                    String rev = new StringBuilder(str).reverse().toString();
                    if (str.equals(rev)){
                        System.out.println("Chuỗi là Palindrome.");
                    } else {
                        System.out.println("Chuỗi không phải Palindrome.");
                    }
                    break;
                case 5:
                    if (str.isEmpty()){
                        System.out.println("Vui lòng chọn 1 trước.");
                        break;
                    }

                    // replaceAll("\\s+", " ") dùng Regex để biến nhiều dấu cách ở giữa thành 1 dấu cách
                    String normalized = str.trim().replaceAll("\\s+", " ");

                    if (normalized.length() > 0) {
                        // Cắt chữ cái đầu viết hoa, toàn bộ phần đuôi ép về viết thường
                        normalized = normalized.substring(0, 1).toUpperCase() + normalized.substring(1).toLowerCase();
                    }
                    System.out.println("Chuỗi sau khi chuẩn hóa: " + normalized);
                    // Ghi đè lại chuỗi gốc
                    str = normalized;
                    break;
                case 6:
                    System.out.println("Tạm biệt!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn từ 1 đến 6!");
            }
        }
    }
}
