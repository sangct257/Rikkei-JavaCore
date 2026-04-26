package Bai1;

import java.util.Scanner;

public class bai_tap_1 {
    public static void main(String[] args) {
        double diem[] = null;
        int n = 0;
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("************QUẢN LÝ ĐIỂM SV*********************");
            System.out.println("1. Nhập danh sách điểm sinh viên ");
            System.out.println("2. In danh sách điểm sinh viên ");
            System.out.println("3. Tính điểm trung bình của các sinh viên ");
            System.out.println("4. Tìm điểm cao nhất và thấp nhất ");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt ");
            System.out.println("6. Sắp xếp điểm tăng dần ");
            System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc ");
            System.out.println("8. Thoát ");
            System.out.print("Lựa chọn của bạn : ");
            int chon = sc.nextInt();
            switch (chon){
                case 1:
                    System.out.print("Mời số sinh viên : ");
                    n = sc.nextInt();

                    diem = new double[n];

                    for (int i = 0; i < n; i++) {
                        do {
                            System.out.print("Điểm sinh viên thứ "+(i+1)+" : ");
                            diem[i] = sc.nextDouble();

                            if (diem[i] < 0 || diem[i] > 10){
                                System.out.println("Nhập lại điềm từ 1 - 10");
                            }
                        } while (diem[i] < 0 || diem[i] > 10);
                    }
                    break;
                case 2:
                    if (diem == null){
                        System.out.println("Chưa nhập dữ liệu");
                        break;
                    }
                    System.out.println("Danh sách điểm :");
                    for (int i = 0; i < n; i++) {
                        System.out.println("SV "+(i+1)+" : "+diem[i] + " điểm");
                    }
                    break;
                case 3:
                    double sum = 0;
                    for (int i = 0; i < n; i++) {
                        sum += diem[i];
                    }
                    double avg = sum / n;
                    System.out.println("Điểm trung bình của các sinh viên là : "+avg);
                    break;
                case 4:
                    double max = diem[0];
                    double min = diem[0];

                    for (int i = 0; i < n; i++) {
                        if (diem[i] > max) max = diem[i];
                        if (diem[i] < min) min = diem[i];
                    }

                    System.out.println("Điểm cao nhất là : "+max);
                    System.out.println("Điểm thấp nhất là : "+min);
                    break;
                case 5:
                    int dat = 0 , truot = 0;
                    for (int i = 0; i < n; i++) {
                        if (diem[i] >= 5) dat++;
                        else truot++;
                    }
                    System.out.println("Số sinh viên đạt : "+dat);
                    System.out.println("Số sinh viên trượt : "+truot);
                    break;
                case 6:
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n - 1 - i; j++) {
                            if (diem[j] > diem[j+1]){
                                double temp = diem[j];
                                diem[j] = diem[j+1];
                                diem[j+1] = temp;
                            }
                        }
                    }

                    System.out.println("Đã sắp xếp tăng dần!");
                    break;
                case 7:
                    int gioi = 0;
                    for (int i = 0; i < n; i++) {
                        if (diem[i] >= 8){
                            gioi++;
                        }
                    }
                    System.out.println("Số lượng sinh viên giỏi/xuất sắc : "+gioi);
                    break;
                case 8:
                    System.out.println("Thoát chuương trình");
                    System.exit(0);
                default:
                    System.out.println("Chọn sai !");
            }
        }
    }
}
