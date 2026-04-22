package Bai6;

import java.util.Scanner;

public class bai_tap_6 {
    public static void main(String[] args) {
        int n;
        double[] salaries;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Nhập số lượng nhân viên: \t");
            n = sc.nextInt();
            if (n < 0){
                System.out.println("Số lượng nhân viên phải > 0. Nhập lại");
            }
        } while (n < 0);

        salaries = new double[n];

        for (int i = 0; i < n; i++) {
            do {
                System.out.print("Nhập lương nhân viên "+(i+1)+ ": \t");
                salaries[i] = sc.nextDouble();
                if (salaries[i] < 0){
                    System.out.println("Lương nhân viên phải > 0. Nhập lại");
                }
            } while (salaries[i] < 0);
        }

        boolean daSapXep = false;
        int kieuSapXep = 0;
        while (true){
            System.out.println("----- QUẢN LÝ NHÂN VIÊN ---------");
            System.out.println("1. Xem danh sách lương ");
            System.out.println("2. Sắp xếp lương ");
            System.out.println("3. Tìm kiếm lương ");
            System.out.println("4. Thống kê lương ");
            System.out.println("5. Thoát ");
            System.out.print("Lựa chọn của bạn: \t");
            int choose = sc.nextInt();
            switch (choose){
                case 1:
                    System.out.println("Danh sách lương nhân viên: ");
                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhân viên "+(i+1)+": "+salaries[i]);
                    }
                    break;
                case 2:
                    System.out.println("1. Tăng dần");
                    System.out.println("2. Giảm dần");
                    int chon = sc.nextInt();
                    for (int i = 0; i < n-1; i++) {
                        for (int j = 0; j <n-1-i ; j++) {
                            if ((chon==1 && salaries[j] > salaries[j+1]) ||
                                    (chon ==2 && salaries[j] < salaries[j+1])){
                                double temp = salaries[j];
                                salaries[j] = salaries[j+1];
                                salaries[j+1] = temp;
                            }
                        }
                    }

                    daSapXep = true;
                    kieuSapXep = chon;

                    if (chon == 1){
                        System.out.println("Đã sắp xếp tăng dần.");
                    } else {
                        System.out.println("Đã sắp xếp giảm dần.");
                    }
                    break;
                case 3:
                    System.out.print("Nhập lương cần tìm: \t");
                    double x = sc.nextDouble();

                    // tìm kiếm tuyến tính
                    int index1 = -1;
                    for (int i = 0; i < n; i++) {
                        if (salaries[i] == x){
                            index1 = i;
                            break;
                        }
                    }

                    // tim kiếm nhị phân
                    int index2 = -1;
                    if (daSapXep){
                        int left = 0 , right = n -1;
                        while (left <= right){
                            int mid = (left + right) /2;
                            if (salaries[mid] == x){
                                index2 = mid;
                                break;
                            }

                            if (kieuSapXep == 1){
                                // tăng dần
                                if (salaries[mid] > x) right = mid - 1;
                                else left = mid + 1;
                            } else {
                                // giảm dần
                                if (salaries[mid] < x) right = mid - 1;
                                else left = mid + 1;
                            }
                        }
                    }
                    if (index1 != -1){
                        System.out.println("Linear Search: Tìm thấy tại vị trí: "+index1);
                    } else {
                        System.out.println("Linear Search: Không tìm thấy");
                    }

                    if (daSapXep){
                        if (index2 != -1){
                            if (kieuSapXep == 1){
                                System.out.println("Binary Search (mảng tăng dần): Tìm thấy tại vị trí: "+index2);
                            } else {
                                System.out.println("Binary Search (mảng giảm dần): Tìm thấy tại vị trí: "+index2);
                            }
                        } else {
                            System.out.println("Binary Search: Không tìm thấy");
                        }
                    } else {
                        System.out.println("Chưa sắp xếp: Không dùng được tìm kiếm nhị phân. ");
                    }
                    break;
                case 4:
                    double sum = 0;
                    double max = salaries[0];
                    double min = salaries[0];
                    int count = 0;
                    
                    // quyệt mảng
                    for (int i = 0; i < n; i++) {
                        // tổng lương
                        sum += salaries[i];
                        
                        //lương cao nhất
                        if (salaries[i] > max){
                            max = salaries[i];
                        }
                        
                        // lương thâấp nhất
                        if (salaries[i] < min){
                            min = salaries[i];
                        }
                    }
                    
                    // lương trung bình
                    double avg = sum / n;

                    for (int i = 0; i < n; i++) {
                        if (salaries[i] > avg){
                            count++;
                        }
                    }

                    System.out.println("Tổng lương :"+sum);
                    System.out.println("Lương trung bình: "+avg);
                    System.out.println("Lương cao nhất: "+max);
                    System.out.println("Lương thấp nhất: "+min);
                    System.out.println("Số nhân viên có lương trên trung bình: "+count);
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Chọn sai. Chọn lại!");
            }
        }
    }
}
