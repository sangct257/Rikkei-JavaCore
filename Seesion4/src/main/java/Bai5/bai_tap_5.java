package Bai5;

import java.sql.SQLOutput;
import java.util.Scanner;

public class bai_tap_5 {
    public static void main(String[] args) {

        int n;
        double diem[];
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Nhập số lượng sinh viên: \t");
            n = sc.nextInt();
            if (n < 0){
                System.out.println("Số lượng sinh viên phải > 0. Nhập lại");
            }
        }while (n < 0);

        diem = new double[n];

        for (int i = 0; i < n; i++) {
            do {
                System.out.print("Nhập điểm sinh viên thứ "+(i+1)+": \t");
                diem[i] = sc.nextDouble();

                if (diem[i] < 0 || diem[i] > 10){
                    System.out.println("Điểm phải nằm trong khoảng từ 0 - 10. Nhập lại");
                }
            } while (diem[i] < 0 || diem[i] > 10);
        }

        // kiểm tra đã sắp xếp hay chưa
        boolean daSapXep = false;
        int kieuSapXep = 0;
        while (true){
            System.out.println("********* QUẢN LÝ ĐIỂM SINH VIÊN *********");
            System.out.println("1. Xem tất cả điểm ");
            System.out.println("2. Sắp xếp điểm  ");
            System.out.println("3. Tìm kiếm điểm ");
            System.out.println("4. Thống kê điểm ");
            System.out.println("5. Thoát ");
            System.out.print("Lựa chọn của bạn: \t");
            int chosse = sc.nextInt();
            switch (chosse){
                case 1:
                    System.out.println("Danh sách điểm: ");
                    for (int i = 0; i < n; i++) {
                        System.out.println("Sinh viên "+ (i+1) +": "+diem[i]+ " ");
                    }
                    break;
                case 2:
                    System.out.println("1. Tăng dần");
                    System.out.println("2: Giảm dần");
                    int chon = sc.nextInt();
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - 1 - i; j++) {
                            if ( (chon == 1 && diem[j] > diem[j+1]) ||
                                    (chon == 2 && diem[j] < diem[j+1]) ){
                                double temp = diem[j];
                                diem[j] = diem[j+1];
                                diem[j+1] = temp;
                            }
                        }
                    }

                    daSapXep = true;
                    kieuSapXep = chon;

                    if (chon == 1){
                        System.out.println("Đã sắp xếp tăng dần. ");
                    } else {
                        System.out.println("Đã sắp xếp giảm dần. ");
                    }
                    break;
                case 3:
                    System.out.println("Nhập giá trị cần tìm: ");
                    double x = sc.nextDouble();

                    // tìm kiếm tuyến tính
                    int index1 = -1;
                    for (int i = 0; i < n; i++) {
                        if (diem[i] == x){
                            index1 = i;
                            break;
                        }
                    }

                    // tìm kiếm nhị phân
                    int index2 = -1;
                    if (daSapXep){
                        int left = 0 , right = n - 1;

                        while (left <= right){
                            int mid = (left + right) /2 ;

                            if (diem[mid] == x){
                                index2 = mid;
                                break;
                            }
                            if (kieuSapXep == 1) {
                                // tăng dần
                                if (diem[mid] > x) right = mid - 1;
                                else left = mid + 1;
                            } else {
                                // giảm dần
                                if (diem[mid] < x) right = mid - 1;
                                else left = mid + 1;
                            }
                        }
                    }

                    if (index1 != -1 ){
                        System.out.println("Tìm kiếm tuyến tính: Tìm thấy tại vị trí: "+ index1);
                    } else {
                        System.out.println("Tìm kiếm tuyến tính : Không tìm thấy");
                    }

                    if (daSapXep){
                        if (index2 != -1){
                            if (kieuSapXep == 1){
                                System.out.println("Tìm kiếm nhị phân (mảng tăng dần) : Tìm thấy tại vị trí: "+index2);
                            } else {
                                System.out.println("Tìm kiếm nhị phân (mảng giảm dần) : Tìm thấy tại vị trí: "+index2);
                            }
                        } else {
                            System.out.println("Tìm kiếm nhị phân: Không tìm thấy");
                        }
                    } else {
                        System.out.println("Chưa sắp xếp: Không dùng được tìm kiếm nhị phân");
                    }
                    break;
                case 4:
                    double sum = 0;
                    double max = diem[0];
                    double min = diem[0];
                    int count = 0;

                    // duyệt mạng
                    for (int i = 0; i < n; i++) {
                        // tổng điểm
                        sum += diem[i];

                        // điểm cao nhất
                        if(diem[i] > max){
                            max = diem[i];
                        }

                        // điểm thấp nhất
                        if (diem[i] < min){
                            min = diem[i];
                        }
                    }

                    // tính trung bình
                    double avg = sum / n;

                    // đếm số sinh viên có điểm > trung bình
                    for (int i = 0; i < n; i++) {
                        if (diem[i] > avg){
                            count++;
                        }
                    }

                    System.out.println("Điểm trung bình: "+avg);
                    System.out.println("Diểm cao nhất: "+max);
                    System.out.println("Điểm thấp nhất: "+min);
                    System.out.println("Số sinh viên có điểm trên trung bình: "+count);
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Chọn sai!");
            }
        }
    }
}
