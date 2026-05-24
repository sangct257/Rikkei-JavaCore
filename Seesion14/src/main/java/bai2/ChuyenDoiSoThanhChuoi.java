package bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class ChuyenDoiSoThanhChuoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> danhSachSoNguyen = new ArrayList<>();
        int soLuongKhongHopLe = 0;
        String input;

        while (true){
            System.out.print("Nhập chuỗi : ");
            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")){
                System.out.println("Kết thúc chương trình!");
                break;
            }
            if (input.isEmpty()){
                System.out.println("Không được để trống!");
            }

            try {
                danhSachSoNguyen.add(Integer.parseInt(input));
            }catch (NumberFormatException e){
                soLuongKhongHopLe++;
            }
        }

        System.out.println("Số chuỗi hợp lệ: "+danhSachSoNguyen.size());
        System.out.println("Số chuỗi không hợp lệ: "+soLuongKhongHopLe);
        System.out.println("Danh sách số nguyên hợp lệ: "+danhSachSoNguyen);
    }
}
