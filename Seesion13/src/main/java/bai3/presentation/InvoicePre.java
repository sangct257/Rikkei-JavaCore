package bai3.presentation;

import bai3.business.InvoiceManager;
import bai3.entity.Invoice;
import java.util.Scanner;

public class InvoicePre {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InvoiceManager manager = new InvoiceManager();
        int choice;

        do {
            System.out.println("***************** MENU QUẢN LÝ HÓA ĐƠN *****************");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Hiển thị danh sách hóa đơn");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn:\n");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1:
                    System.out.println("Nhập mã hóa đơn:");
                    String autoId = inputNonEmptyString();
                    // Người dùng chủ động nhập mã có chữ HD... (Ví dụ: HD001) theo ảnh 1

                    System.out.println("Nhập số tiền:");
                    double amount = inputValidAmount("Nhập số tiền:");

                    manager.add(new Invoice(autoId, amount));
                    break;

                case 2:
                    manager.display();
                    System.out.println("Nhập id hóa đơn cần sửa:");
                    String idEditStr = scanner.nextLine().trim();
                    try {
                        int indexEdit = Integer.parseInt(idEditStr);

                        if (indexEdit > 0 && indexEdit <= manager.getInvoiceList().size()) {
                            System.out.println("Nhập mã hóa đơn mới:");
                            String newId = inputNonEmptyString();

                            System.out.println("Nhập số tiền mới:");
                            double newAmount = inputValidAmount("Nhập số tiền mới:");

                            Invoice updatedInvoice = new Invoice(newId, newAmount);
                            manager.update(indexEdit, updatedInvoice);
                        } else {
                            System.out.println("Không tìm thấy hóa đơn nào có id = " + indexEdit);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Không tìm thấy hóa đơn nào có id = " + idEditStr);
                    }
                    break;

                case 3:
                    manager.display();
                    System.out.println("Nhập id hóa đơn cần xóa:");
                    String idDelStr = scanner.nextLine().trim();
                    try {
                        int indexDel = Integer.parseInt(idDelStr); // Đổi "01" -> 1
                        manager.delete(indexDel);
                    } catch (NumberFormatException e) {
                        System.out.println("Không tìm thấy hóa đơn nào có id = " + idDelStr);
                    }
                    break;

                case 4:
                    manager.display();
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn sai, vui lòng nhập lại.");
            }
            System.out.println();
        } while (choice != 5);
    }

    // Bắt lỗi không để trống mã hóa đơn
    private static String inputNonEmptyString() {
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("\nVui lòng ko để trống !");
            System.out.println("Nhập mã hóa đơn mới:");
        }
    }

    // Bắt lỗi số thực >= 0 và hiển thị lại dòng nhập số tiền tương ứng
    private static double inputValidAmount(String label) {
        while (true) {
            try {
                double val = Double.parseDouble(scanner.nextLine());
                if (val >= 0) {
                    return val;
                }
                System.out.println("\nVui lòng nhập số thực >= 0 !");
                System.out.println(label);
            } catch (NumberFormatException e) {
                System.out.println("\nVui lòng nhập số thực >= 0 !");
                System.out.println(label);
            }
        }
    }
}