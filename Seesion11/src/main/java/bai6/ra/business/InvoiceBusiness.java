package bai6.ra.business;

import bai6.ra.entity.Invoice;
import bai6.ra.entity.Product;

import java.util.Scanner;

public class InvoiceBusiness {
    private static Invoice[] invoices = new Invoice[100];
    private static int currentIndex = 0;

    public static Invoice[] getInvoices() {
        return invoices;
    }

    public static int getCurrentIndex() {
        return currentIndex;
    }

    public static void addInvoice(Scanner scanner) {
        if (currentIndex >= invoices.length) {
            System.out.println("Bộ nhớ danh sách hóa đơn đã đầy!");
            return;
        }

        // Lấy kho dữ liệu sản phẩm từ hệ thống để truyền vào cho hóa đơn chọn mặt hàng
        Product[] activeProducts = ProductBusiness.getProducts();
        int productCount = ProductBusiness.getCurrentIndex();

        if (productCount == 0) {
            System.out.println("Hệ thống chưa có sản phẩm nào. Vui lòng tạo sản phẩm trước khi lập hóa đơn!");
            return;
        }

        Invoice newInvoice = new Invoice();

        // Vòng lặp bắt nhập ID hóa đơn và tự check trùng tại tầng Business
        do {
            newInvoice.inputData(scanner, activeProducts, productCount);
            boolean isExist = false;
            for (int i = 0; i < currentIndex; i++) {
                if (invoices[i].getInvoiceId().equalsIgnoreCase(newInvoice.getInvoiceId())) {
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                System.out.println("Mã hóa đơn này đã tồn tại trên hệ thống! Vui lòng nhập lại mã khác.");
            } else {
                break;
            }
        } while (true);

        invoices[currentIndex++] = newInvoice;
        System.out.println("Lập hóa đơn mới thành công!");
    }

    public static void displayInvoices() {
        if (currentIndex == 0) {
            System.out.println("Danh sách hóa đơn hiện đang trống!");
            return;
        }
        for (int i = 0; i < currentIndex; i++) {
            invoices[i].displayData();
        }
    }

    public static void updateInvoice(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Danh sách trống, không thể cập nhật!");
            return;
        }
        System.out.print("Nhập mã hóa đơn cần chỉnh sửa (Ví dụ: HD0001): ");
        String idInput = scanner.nextLine().trim();

        int foundIndex = -1;
        for (int i = 0; i < currentIndex; i++) {
            if (invoices[i].getInvoiceId().equalsIgnoreCase(idInput)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            Product[] activeProducts = ProductBusiness.getProducts();
            int productCount = ProductBusiness.getCurrentIndex();

            invoices[foundIndex].inputUpdateData(scanner, activeProducts, productCount);
            System.out.println("Cập nhật hóa đơn thành công!");
        } else {
            System.out.println("Không tìm thấy mã hóa đơn hợp lệ!");
        }
    }

    public static void deleteInvoice(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Danh sách trống, không thể xóa!");
            return;
        }
        System.out.print("Nhập mã hóa đơn muốn xóa: ");
        String deleteId = scanner.nextLine().trim();

        int foundIndex = -1;
        for (int i = 0; i < currentIndex; i++) {
            if (invoices[i].getInvoiceId().equalsIgnoreCase(deleteId)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            for (int i = foundIndex; i < currentIndex - 1; i++) {
                invoices[i] = invoices[i + 1];
            }
            invoices[currentIndex - 1] = null;
            currentIndex--;
            System.out.println("Đã xóa hóa đơn thành công!");
        } else {
            System.out.println("Mã hóa đơn không tồn tại!");
        }
    }

    public static void findInvoiceById(Scanner scanner) {
        System.out.print("Nhập mã hóa đơn cần tìm: ");
        String searchId = scanner.nextLine().trim();

        boolean found = false;
        for (int i = 0; i < currentIndex; i++) {
            if (invoices[i].getInvoiceId().equalsIgnoreCase(searchId)) {
                invoices[i].displayData();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy hóa đơn nào có mã là: " + searchId);
        }
    }

    public static void findInvoiceByCustomerName(Scanner scanner) {
        System.out.print("Nhập tên khách hàng cần tìm kiếm: ");
        String searchName = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        for (int i = 0; i < currentIndex; i++) {
            if (invoices[i].getCustomerName().toLowerCase().contains(searchName)) {
                invoices[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy hóa đơn nào khớp với tên khách hàng trên.");
        }
    }
}
