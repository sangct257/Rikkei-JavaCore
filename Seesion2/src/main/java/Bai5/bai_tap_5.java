package Bai5;

import java.util.Scanner;

public class bai_tap_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào một số hợp lệ (100-999) :");
        int n = sc.nextInt();

        if(100 < n && n > 999) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {
            int hundreds = n / 100; // lấy chữ số hàng trăm
            int tens = (n / 10) % 10; // lấy chữ số hàng chục
            int units = n % 10; // lấy chữ số hàng đơn vị
            String ketQua = "";

            switch(hundreds){
                case 1: ketQua += "Một trăm "; break;
                case 2: ketQua += "Hai trăm "; break;
                case 3: ketQua += "Ba trăm "; break;
                case 4: ketQua += "Bốn trăm "; break;
                case 5: ketQua += "Năm trăm "; break;
                case 6: ketQua += "Sáu trăm "; break;
                case 7: ketQua += "Bảy trăm "; break;
                case 8: ketQua += "Tám trăm "; break;
                case 9: ketQua += "Chín trăm "; break;
            }

            switch(tens){
                case 0:
                    if (units != 0){
                        // nếu số là 101 đọc là nột trăm lẻ một
                        ketQua += "lẻ ";
                    }
                    break;
                case 1: ketQua += "mười "; break;
                case 2: ketQua += "hai mươi "; break;
                case 3: ketQua += "ba mươi "; break;
                case 4: ketQua += "bốn mươi "; break;
                case 5: ketQua += "năm mươi "; break;
                case 6: ketQua += "sáu mươi "; break;
                case 7: ketQua += "bảy mươi "; break;
                case 8: ketQua += "yám mươi "; break;
                case 9: ketQua += "chín mươi "; break;
            }

            switch(units){
                case 0:  break;
                case 1:
                    if(tens >= 2){
                        // nếu số là 131 đọc là một trăm ba mốt
                        ketQua += "mốt";
                    } else {
                        // nếu số là 111 đọc là một trăm mười một
                        ketQua += "một";
                    }
                    break;
                case 2: ketQua += "hai"; break;
                case 3: ketQua += "ba"; break;
                case 4: ketQua += "bốn"; break;
                case 5:
                    if (tens == 0){
                        // nếu số là 105 sẽ đọc là một trăm lẻ năm
                        ketQua += "năm";
                    } else {
                        // nếu số là 115 sẽ đọc là một trăm mười lăm
                        ketQua += "lăm";
                    }
                    break;
                case 6: ketQua += "sáu"; break;
                case 7: ketQua += "bảy"; break;
                case 8: ketQua += "tám"; break;
                case 9: ketQua += "chín"; break;
            }
            System.out.println(ketQua);
        }
    }
}
