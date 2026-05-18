package bai6.ra.presentation;

import bai6.ra.business.InvoiceBusiness;
import bai6.ra.business.InvoiceDetailBusiness;
import bai6.ra.business.ProductBusiness;

import java.util.Scanner;

public class InvoiceManagement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("""
                    ================ QUẢN LÝ HOÁ ĐƠN ===================
                    1. Quản lý sản phẩm
                    2. Quản lý hoá đơn
                    3. Quản lý doanh thu
                    4. Thoát
                    ==================================================
                    Lựa chọn của bạn: 
                    """);
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        menuProduct(scanner);
                        break;
                    case 2:
                        menuInvoice(scanner);
                        break;
                    case 3:
                        menuRevenue(scanner);
                        break;
                    case 4:
                        System.out.println("Thoát chương trình!");
                        System.exit(0);
                    default:
                        System.out.println("Vui lòng chọn từ 1 đến 4!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        } while (true);
    }

    public static void menuProduct(Scanner scanner) {
        do {
            System.out.print("""
                    ======================= QUẢN LÝ SẢN PHẨM =======================
                    1. Thêm sản phẩm
                    2. Hiển thị danh sách sản phẩm
                    3. Cập nhập thông tin sản phẩm
                    4. Xoá sản phẩm (nếu chưa có trong hoá đơn nào)
                    5. Tìm kiếm sản phẩm theo tên
                    6. Thoát
                    ===================================================================
                    Lựa chọn của bạn: 
                    """);
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        ProductBusiness.addProduct(scanner);
                        break;
                    case 2:
                        ProductBusiness.displayProducts();
                        break;
                    case 3:
                        ProductBusiness.updateProduct(scanner);
                        break;
                    case 4:
                        ProductBusiness.deleteProduct(scanner);
                        break;
                    case 5:
                        ProductBusiness.searchProductByName(scanner);
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 đến 6!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        } while (true);
    }

    public static void menuInvoice(Scanner scanner) {
        do {
            System.out.print("""
                    ======================= QUẢN LÝ HOÁ ĐƠN =======================
                    1. Thêm hoá đơn
                    2. Hiển thị danh sách hoá đơn
                    3. Cập nhập thông tin hoá đơn
                    4. Xoá hoá đơn 
                    5. Tìm hoá đơn theo mã
                    6. Tìm hoá đơn theo tên khách hàng
                    7. Thoát
                    ==============================================================
                    Lựa chọn của bạn: 
                    """);
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        InvoiceBusiness.addInvoice(scanner);
                        break;
                    case 2:
                        InvoiceBusiness.displayInvoices();
                        break;
                    case 3:
                        InvoiceBusiness.updateInvoice(scanner);
                        break;
                    case 4:
                        InvoiceBusiness.deleteInvoice(scanner);
                        break;
                    case 5:
                        InvoiceBusiness.findInvoiceById(scanner);
                        break;
                    case 6:
                        InvoiceBusiness.findInvoiceByCustomerName(scanner);
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 đến 7!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        } while (true);
    }

    public static void menuRevenue(Scanner scanner) {
        do {
            System.out.print("""
                    ======================= QUẢN LÝ DOANH THU =======================
                    1. Tính tổng doanh thu tất cả hoá đơn
                    2. Tìm hoá đơn có giá trị lớn nhất
                    3. Thống kê số hoá đơn theo khoảng ngày (nhập từ - đến)
                    4. Thống kê tổng doanh thu theo khoảng ngày
                    5. Thoát
                    ==============================================================
                    Lựa chọn của bạn: 
                    """);
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        InvoiceDetailBusiness.calculateTotalRevenue();
                        break;
                    case 2:
                        InvoiceDetailBusiness.findMaxAmountInvoice();
                        break;
                    case 3:
                        InvoiceDetailBusiness.countInvoicesInDateRange(scanner);
                        break;
                    case 4:
                        InvoiceDetailBusiness.sumRevenueInDateRange(scanner);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Vui lòng nhập từ 1 đến 5!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        } while (true);
    }

}
