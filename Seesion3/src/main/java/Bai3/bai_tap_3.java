package Bai3;

import java.util.Scanner;

public class bai_tap_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tongNhanVien = 0;
        double tongLuong = 0;
        double luongMax = 0;
        double luongMin = 0;
        double tongThuong = 0;
        while (true){
            System.out.println("********* MENU NHẬP LƯƠNG ************");
            System.out.println("1. Nhập số lượng nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng tiền thưởng cho nhân viên");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn : ");
            int chosse = sc.nextInt();

            switch (chosse){
                case 1:
                    System.out.println("----Nhập lương nhân viên (nhập -1 để kết thúc) ----------");
                    while (true){
                        System.out.print("Nhập lương : ");
                        int luong = sc.nextInt();

                        if (luong == -1 ){
                            System.out.println("Kết thúc quá trình nhập.");
                            break;
                        }

                        if (luong < 0 || luong > 500000000){
                            System.out.println("Lương phải có giá trị từ 0 đến 500 triệu . Mời nhập lại");
                            continue;
                        }

                        // phân loại lương
                        if(luong < 5000000){
                            System.out.println("Thu nhập thấp");
                        } else if (luong >= 5000000 && luong < 15000000) {
                            System.out.println("Thu nhập trung bình");
                        } else if (luong >= 15000000 && luong < 50000000) {
                            System.out.println("Thu nhập khá");
                        } else {
                            System.out.println("Thu nhập cao");
                        }

                        // tính số tiền thưởng cho từng nhân viên
                        if (luong < 5000000) {
                            tongThuong += luong * 0.05;
                        } else if (luong < 15000000) {
                            tongThuong += luong * 0.10;
                        } else if (luong < 50000000) {
                            tongThuong += luong * 0.15;
                        } else if (luong <= 100000000) {
                            tongThuong += luong * 0.20;
                        } else {
                            tongThuong += luong * 0.25;
                        }
                        // đếm số lượng nhân viên
                        tongNhanVien ++;
                        // tổng lương
                        tongLuong += luong;

                        if (tongNhanVien == 1){
                            luongMax = luong;
                            luongMin = luong;
                        } else{
                            if (luong > luongMax) luongMax = luong;
                            if (luong < luongMin) luongMin = luong;
                        }
                    }
                    break;
                case 2:
                    System.out.println("******** THỐNG KÊ **********");
                    if (tongNhanVien == 0){
                        System.out.println("Chưa có dữ liệu");
                        break;
                    } else {
                        double luongTrungBinh = tongLuong / tongNhanVien;
                        System.out.println("Số nhân viên : "+tongNhanVien);
                        System.out.printf("Tổng lương       : %,.0f VND\n", tongLuong);
                        System.out.printf("Lương trung bình : %,.0f VND\n", luongTrungBinh);
                        System.out.printf("Lương cao nhất   : %,.0f VND\n", luongMax);
                        System.out.printf("Lương thấp nhất  : %,.0f VND\n", luongMin);
                    }
                    break;
                case 3:
                    System.out.println("********* Tính tổng tiêền thưởng nhân viên ************");
                    if (tongNhanVien == 0) {
                        System.out.println("Chưa có dữ liệu");
                        break;
                    } else {
                        System.out.printf("Tổng tiền thưởng nhân viên : %,.0f VND\n",tongThuong );
                    }
                    break;
                case 4:
                    System.out.println("Kết thúc chương trình.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chỉ nhập từ 1 đến 4.");
            }
        }
    }
}
