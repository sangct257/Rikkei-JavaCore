package Bai2;

import java.util.Scanner;

public class Bai_tap_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int soHocvien = 0;
        double tongDiem = 0;
        double diemMax = 0;
        double diemMin = 0;

        while (true){
            System.out.println("********* MENU NHẬP ĐIỂM ************");
            System.out.println("1. Nhập điểm học viên ");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn : ");
            int chosse = sc.nextInt();

            switch (chosse){
                case 1:
                    System.out.println("--- Nhập điểm học viên (nhập -1 để dừng) ---");
                    // nhập điểm liên tục
                    while (true){
                        System.out.print("NHập điểm : ");
                        float diem = sc.nextFloat();

                        // thoát chương trình nhập
                        if (diem == -1){
                            System.out.println("Kết thúc quá trình nhập");
                            break;
                        }

                        // nếu điểm < 0 và > 10 thì sẽ yêu cầu nhập lại
                        if (0 < diem || diem > 10){
                            System.out.println("Điểm không hợp lệ! Vui lòng nhập trong khoảng 0 - 10.");
                            continue;
                        }

                        // xếp loại học lực
                        System.out.println("Xếp loại học lực");
                        if (diem >= 0 && diem < 5) {
                            System.out.println("Yếu");
                        } else if (diem >= 5 && diem < 7){
                            System.out.println("Trung bình");
                        } else if (diem >= 7 && diem < 8){
                            System.out.println("Khá");
                        } else if (diem >= 8 && diem < 9) {
                            System.out.println("Giỏi");
                        } else {
                            System.out.println("Xuất sắc");
                        }

                        // mỗi lần học viên nhập điểm tăng lên 1 đơn vị
                        soHocvien++;
                        // tổng điềm học viên đã nhập
                        tongDiem += diem;

                        // tìm max , min
                        if (soHocvien == 1){
                            // người dầu tiên nhập điểm thì nó vừa là max vừa là min
                            diemMax = diem;
                            diemMin = diem;
                        } else {
                            // từ người 2 so sánh vs max min người trước
                            if (diem > diemMax) diemMax = diem;
                            if (diem < diemMin) diemMin = diem;
                        }
                    }
                    break;
                case 2:
                    System.out.println("-------------- THỐNG KÊ --------------");
                    // kiểm tra đã có học viên nào nhập điểm chưa
                    if (soHocvien == 0){
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        double diemTrungBinh = tongDiem / soHocvien;
                        System.out.println("Số học viên đã nhập : "+ soHocvien);
                        System.out.println("Điểm trung bình : "+diemTrungBinh);
                        System.out.println("Điểm cao nhất : "+ diemMax);
                        System.out.println("Điểm thấp nhất : "+diemMin);
                    }
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình.");
                    sc.close();
                    System.exit(0); // ngắt toàn bộ chương trình
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chỉ nhập từ 1 đến 3.");
            }
        }
    }
}
