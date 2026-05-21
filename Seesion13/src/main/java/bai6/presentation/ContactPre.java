package bai6.presentation;

import bai6.business.ContactManager;

import java.util.Scanner;

public class ContactPre {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        int choice;

        do {
            System.out.println("=============== MENU ===============");
            System.out.println("1. Thêm liên lạc");
            System.out.println("2. Xóa liên lạc theo số điện thoại");
            System.out.println("3. Tìm kiếm liên lạc");
            System.out.println("4. Hiển thị danh bạ");
            System.out.println("0. Thoát");
            System.out.println("====================================");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên người liên lạc: ");
                    String name = inputNonEmptyString();
                    System.out.print("Nhập số điện thoại: ");
                    String phone = inputNonEmptyString();

                    manager.addContact(name, phone);
                    break;

                case 2:
                    System.out.print("Nhập số điện thoại cần xóa: ");
                    String phoneDel = inputNonEmptyString();
                    manager.deleteByPhone(phoneDel);
                    break;

                case 3:
                    System.out.print("Nhập số điện thoại cần tìm: ");
                    String phoneSearch = inputNonEmptyString();
                    manager.searchByPhone(phoneSearch);
                    break;

                case 4:
                    manager.displayAll();
                    break;

                case 0:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn sai, vui lòng chọn lại từ 0 đến 4!");
            }
            System.out.println(); // Ngắt dòng
        } while (choice != 0);
    }

    // Hàm validate chống để dữ liệu trống
    private static String inputNonEmptyString() {
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.print("Vui lòng ko để trống ! Mời nhập lại: ");
        }
    }
}
