package Bai3;

import java.util.Scanner;

public class bai_tap_3 {
    public static void main(String[] args) {
        String bienSo[] = new String[100]; // 100 biển số
        int count = 0;
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("**********QUẢN LÝ BIỂN SỐ XE**************");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm kiếm biển số xe theo mã tỉnh");
            System.out.println("5. Xắp sếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon){
                case 1:
                    System.out.print("Mời nhập vào biển số: ");
                    String bs = sc.nextLine();

                    String regexBienSo = "^\\d{2}[A-Z]-\\d{3}\\.\\d{2}$";

                    if (!bs.matches(regexBienSo)){
                        System.out.println("Biển số không hợp lệ");
                    } else {
                        bienSo[count] = bs;
                        count++;
                        System.out.println("Thêm thành công");
                    }
                    break;
                case 2:
                    System.out.println("Danh sách biển số: ");
                    if (count == 0){
                        System.out.println("Bạn chưa nhập biển số");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println("Biển số thứ "+(i+1)+" : "+bienSo[i]);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhập biển số cần tìm: ");
                    String x = sc.nextLine();
                    int index = -1;
                    for (int i = 0; i < count; i++) {
                        if (bienSo[i].equalsIgnoreCase(x)){
                            index = i;
                            break;
                        }
                    }

                    if (index != -1){
                        System.out.println("Tìm thấy biển xe ("+bienSo[index]+") tại vị trí "+index);
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã tỉnh: ");
                    String maTinh = sc.nextLine();
                    int tim = -1;
                    for (int i = 0; i < count; i++) {
                        if (bienSo[i].substring(0,2).equalsIgnoreCase(maTinh)){
                            System.out.println(bienSo[i]);
                            tim = i;
                        }
                    }
                    if (tim == -1){
                        System.out.println("Không tìm thấy bển số thuộc tỉnh này! ");
                    }
                    break;
                case 5:
                    for (int i = 0; i < count; i++) {
                        for (int j = 0; j < count - 1 - i; j++) {
                            if (bienSo[j].compareTo(bienSo[j+1]) > 0){
                                String temp = bienSo[j];
                                bienSo[j] = bienSo[j+1];
                                bienSo[j+1] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp tăng dần. ");
                    break;
                case 6:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                default:
                    System.out.println("Chọn sai");
            }
        }
    }
}
