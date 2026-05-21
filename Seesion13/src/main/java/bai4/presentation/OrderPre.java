package bai4.presentation;

import bai4.business.OrderManager;
import bai4.entity.Order;

import java.util.Scanner;

public class OrderPre {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        int choice;

        do {
            System.out.println("***************** MENU QUẢN LÝ ĐƠN HÀNG *****************");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Sửa đơn hàng");
            System.out.println("3. Xóa đơn hàng");
            System.out.println("4. Hiển thị danh sách đơn hàng");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn:\n");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1:
                    System.out.println("Nhập mã đơn hàng:");
                    String id = inputNonEmptyString("Nhập mã đơn hàng:");

                    System.out.println("Nhập tên khách hàng:");
                    String customerName = inputNonEmptyString("Nhập tên khách hàng:");

                    manager.add(new Order(id, customerName));
                    break;

                case 2:
                    manager.display();
                    System.out.println("Nhập mã đơn hàng cần sửa:");
                    String idEdit = scanner.nextLine().trim();

                    int indexEdit = manager.findIndexById(idEdit);
                    if (indexEdit != -1) {
                        System.out.println("Nhập tên khách hàng mới:");
                        String newCustomerName = inputNonEmptyString("Nhập tên khách hàng mới:");

                        // Tạo đối tượng đơn hàng mới giữ nguyên mã hoặc cập nhật lại
                        Order updatedOrder = new Order(idEdit, newCustomerName);
                        // Gọi hàm update truyền vào index tìm được theo đúng cấu trúc Interface
                        manager.update(indexEdit, updatedOrder);
                    } else {
                        System.out.println("Không tìm thấy đơn hàng có mã " + idEdit);
                    }
                    break;

                case 3:
                    manager.display();
                    System.out.println("Nhập mã đơn hàng cần xóa:");
                    String idDel = scanner.nextLine().trim();

                    int indexDel = manager.findIndexById(idDel);
                    if (indexDel != -1) {
                        // Gọi hàm delete truyền vào index tìm được theo đúng cấu trúc Interface
                        manager.delete(indexDel);
                    } else {
                        System.out.println("Không tìm thấy đơn hàng có mã " + idDel);
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

    // Hàm bắt lỗi không cho phép bỏ trống trường nhập dữ liệu
    private static String inputNonEmptyString(String label) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("\nVui lòng ko để trống !");
            System.out.println(label);
        }
    }
}
