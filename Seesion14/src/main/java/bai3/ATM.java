package bai3;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double soDuBanDau = 1000000;
        final double soDuToiThieuPhaiDuyTri = 50000;

        double soTien;

        while (true) {
            try {
                NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi","VN"));

                System.out.println("Số dư ban đầu : "+nf.format(soDuBanDau));
                System.out.println("Số dư tối thiểu phải duy trì : "+nf.format(soDuToiThieuPhaiDuyTri));
                System.out.print("Nhập số tiền cần rút: ");
                soTien = Double.parseDouble(scanner.nextLine().trim());

                if (soTien <= 0) {
                    System.out.println("Lỗi: Số tiền rút phải lớn hơn 0!");
                } else if (soTien > soDuBanDau) {
                    System.out.println("Lỗi: Số tiền rút vượt quá số dư!");
                } else if ((soDuBanDau - soTien) < soDuToiThieuPhaiDuyTri) {
                    System.out.println("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
                } else {
                    System.out.println("Rút thành công!");
                    System.out.println("Số tiền đã rút: " + nf.format(soTien));
                    System.out.println("Số dư còn lại trong tài khoản: " + nf.format(soDuBanDau - soTien));
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
            }
        }
    }
}
