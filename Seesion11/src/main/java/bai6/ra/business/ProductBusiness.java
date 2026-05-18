package bai6.ra.business;

import bai6.ra.entity.Invoice;
import bai6.ra.entity.InvoiceDetail;
import bai6.ra.entity.Product;

import java.util.Scanner;

public class ProductBusiness {
    private static Product[] products = new Product[100];
    private static int currentIndex = 0;

    public static Product[] getProducts() {
        return products;
    }

    public static int getCurrentIndex() {
        return currentIndex;
    }

    public static void addProduct(Scanner scanner) {
        if (currentIndex >= products.length) {
            System.out.println("Bộ nhớ danh sách sản phẩm đã đầy!");
            return;
        }
        Product newProduct = new Product();
        newProduct.inputData(scanner, products, currentIndex);
        products[currentIndex++] = newProduct;
        System.out.println("Thêm sản phẩm mới thành công!");
    }

    public static void displayProducts() {
        if (currentIndex == 0) {
            System.out.println("Danh sách sản phẩm hiện đang trống!");
            return;
        }
        System.out.println("======================= DANH SÁCH SẢN PHẨM =======================");
        for (int i = 0; i < currentIndex; i++) {
            products[i].displayData();
        }
        System.out.println("==================================================================");
    }

    public static void updateProduct(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Danh sách trống, không thể cập nhật!");
            return;
        }
        System.out.print("Nhập mã sản phẩm cần cập nhật (Ví dụ: C001): ");
        String searchId = scanner.nextLine().trim();

        int foundIndex = -1;
        for (int i = 0; i < currentIndex; i++) {
            if (products[i].getProductId().equalsIgnoreCase(searchId)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            System.out.println("--- Cập nhật thông tin sản phẩm " + searchId + " ---");
            products[foundIndex].inputUpdateData(scanner, products, currentIndex);
            System.out.println("Cập nhật thông tin sản phẩm thành công!");
        } else {
            System.out.println("Mã sản phẩm không tồn tại trên hệ thống!");
        }
    }

    public static void deleteProduct(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Danh sách trống, không có sản phẩm để xóa!");
            return;
        }
        System.out.print("Nhập mã sản phẩm muốn xóa: ");
        String deleteId = scanner.nextLine().trim();

        int foundIndex = -1;
        for (int i = 0; i < currentIndex; i++) {
            if (products[i].getProductId().equalsIgnoreCase(deleteId)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex == -1) {
            System.out.println("Mã sản phẩm không tồn tại!");
            return;
        }

        // 🌟 KIỂM TRA RÀ RÀNG: Quét xem sản phẩm đã nằm trong hóa đơn nào chưa
        boolean isUsedInInvoice = false;
        Invoice[] allInvoices = InvoiceBusiness.getInvoices(); // Gọi sang bên InvoiceBusiness lấy danh sách HĐ
        int invoiceCount = InvoiceBusiness.getCurrentIndex();

        for (int i = 0; i < invoiceCount; i++) {
            InvoiceDetail[] details = allInvoices[i].getInvoiceDetails();
            if (details != null) {
                for (InvoiceDetail dt : details) {
                    if (dt != null && dt.getProduct().getProductId().equalsIgnoreCase(deleteId)) {
                        isUsedInInvoice = true;
                        break;
                    }
                }
            }
            if (isUsedInInvoice) break;
        }

        if (isUsedInInvoice) {
            System.out.println("Không thể xóa! Sản phẩm này đã tồn tại trong lịch sử hóa đơn bán hàng.");
        } else {
            // Thực hiện ghi đè để xóa phần tử khỏi mảng mượt mà
            for (int i = foundIndex; i < currentIndex - 1; i++) {
                products[i] = products[i + 1];
            }
            products[currentIndex - 1] = null;
            currentIndex--;
            System.out.println("Xóa sản phẩm thành công!");
        }
    }

    public static void searchProductByName(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Danh sách sản phẩm trống!");
            return;
        }
        System.out.print("Nhập tên sản phẩm muốn tìm kiếm: ");
        String searchName = scanner.nextLine().trim().toLowerCase();

        boolean isFound = false;
        System.out.println("==================== KẾT QUẢ TÌM KIẾM ====================");
        for (int i = 0; i < currentIndex; i++) {
            if (products[i].getProductName().toLowerCase().contains(searchName)) {
                products[i].displayData();
                isFound = true;
            }
        }
        System.out.println("==========================================================");
        if (!isFound) {
            System.out.println("Không tìm thấy sản phẩm nào khớp với từ khóa của bạn.");
        }
    }
}
