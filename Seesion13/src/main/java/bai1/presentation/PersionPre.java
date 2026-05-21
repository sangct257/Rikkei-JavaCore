package bai1.presentation;

import bai1.business.PersonBusiness;

import java.util.Scanner;

public class PersionPre {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("""
                    ==================MENU QUẢN LÝ NGƯỜI DÙNG ===================
                    1. Thêm người dùng
                    2. Xoá người dùng theo email
                    3. Hiển thị người dùng
                    4. Thoát
                    Lựa chọn của bạn :
                    """);
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Sai định dạng!");
            }

            switch (choice){
                case 1:
                    PersonBusiness.addPerson();
                    break;
                case 2:
                    PersonBusiness.deletePersonByEmail();
                    break;
                case 3:
                    PersonBusiness.showDisplay();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 4");
            }

        } while (choice != 4);
    }
}
