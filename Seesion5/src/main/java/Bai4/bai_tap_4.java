package Bai4;

import java.util.Random;
import java.util.Scanner;

public class bai_tap_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào 1 số nguyên : ");
        // Chương trình nhận một số nguyên n từ người dùng nhập vào.
        int n = sc.nextInt();

        // Kiểm tra điều kiện đầu vào (1 <= n <= 1000)
        if (n < 1 || n > 1000){
            System.out.println("Chỉ nhập vào khoảng 1 - 1000");
        } else {
            // tạo một chuỗi ngẫu nhiên gồm chữ cái (A-Z, a-z) và số (0-9)
            String chuoiRandum = "ZXCVBNMLKJHGFDSAQWERTYUIOPzxcvbnmlkjhgfdsaqwertyuiop0123456789";

            // Sử dụng StringBuilder để nối chuỗi tối ưu hiệu suất
            StringBuilder randomString = new StringBuilder();

            // Khởi tạo đôi tượng randum;
            Random random = new Random();

            // Vòng lặp for để lấy ra ngẫu nhiên n ký tự
            for (int i = 0; i < n; i++) {
                // Tạo 1 số ngẫu nhiên từ 0 đến (độ dài - 1)
                int randomIndex = random.nextInt(chuoiRandum.length());

                // Lấy ký tự tại vị trí ngẫu nhiên ở trên để vào StringBuilder
                randomString.append(chuoiRandum.charAt(randomIndex));
            }

            System.out.println("Chuỗi ngẫu nhiên dc tạo ra là : " + randomString.toString());
        }
        sc.close();
    }
}
