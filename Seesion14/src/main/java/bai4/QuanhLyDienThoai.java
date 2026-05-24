package bai4;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanhLyDienThoai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> dsHopLe = new ArrayList<>();
        ArrayList<String> dsKhongHopLe = new ArrayList<>();

        System.out.println("Mời nhập chuỗi gồm nhiều số điện thoại (phân tách bằng dấu phẩy):");
        String input = scanner.nextLine();

        String[] phoneArray = input.split(",");

        for (String phone : phoneArray) {
            String cleanPhone = phone.trim();

            if (cleanPhone.isEmpty()) {
                continue;
            }

            try {
                validatePhoneNumber(cleanPhone);
                dsHopLe.add(cleanPhone);
            } catch (InvalidPhoneNumberLengthException e) {
                dsKhongHopLe.add(phone.trim() + " : " + e.getMessage());
            }
        }

        System.out.println("\nSố điện thoại hợp lệ:");
        if (dsHopLe.isEmpty()) {
            System.out.println("  (Không có)");
        } else {
            for (String sdt : dsHopLe) {
                System.out.println("  - " + sdt);
            }
        }

        System.out.println("\nSố điện thoại không hợp lệ:");
        if (dsKhongHopLe.isEmpty()) {
            System.out.println("  (Không có)");
        } else {
            for (String sdtLoi : dsKhongHopLe) {
                System.out.println("  - " + sdtLoi);
            }
        }

        scanner.close();
    }

    public static void validatePhoneNumber(String phone) throws InvalidPhoneNumberLengthException{
        if (phone.isEmpty()){
            throw new InvalidPhoneNumberLengthException("Không được để trống! ");
        }

        if (phone.contains(" ")){
            throw new InvalidPhoneNumberLengthException("Không được chứa khoảng trắng!");
        }

        if (!phone.matches("\\d+")){
            throw new InvalidPhoneNumberLengthException("Chứa ký tự không hợp lệ!");
        }

        if (phone.length() != 10){
            throw new InvalidPhoneNumberLengthException("Sai độ dài (Yêu cầu phải có 10 chữ số)");
        }
    }
}
