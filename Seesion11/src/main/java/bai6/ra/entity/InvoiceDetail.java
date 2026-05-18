package bai6.ra.entity;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class InvoiceDetail {
    private Product product;
    private int quantity;
    private double subTotal;

    public InvoiceDetail() {
    }

    public InvoiceDetail(Product product, int quantity, double subTotal) {
        this.product = product;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void inputData(Scanner scanner, Product[] arrProd, int prodIndex) {
        // 1. Tìm và chọn sản phẩm từ danh sách hệ thống dựa vào mã sản phẩm
        do {
            System.out.print("Mời nhập vào mã sản phẩm muốn mua (Ví dụ: C001, S002): ");
            String inputId = scanner.nextLine().trim();

            Product foundProduct = null;
            for (int i = 0; i < prodIndex; i++) {
                if (arrProd[i].getProductId().equalsIgnoreCase(inputId)) {
                    foundProduct = arrProd[i];
                    break;
                }
            }

            if (foundProduct != null) {
                this.product = foundProduct; // Gán thực thể sản phẩm tìm thấy
                System.out.println("Đã chọn sản phẩm: " + foundProduct.getProductName() + " | Giá bán: " + foundProduct.getPrice());
                break;
            } else {
                System.out.println("Mã sản phẩm không tồn tại trên hệ thống! Vui lòng chọn lại.");
            }
        } while (true);

        // 2. Nhập số lượng sản phẩm cần mua (> 0)
        do {
            try {
                System.out.print("Mời nhập vào số lượng mua: ");
                this.quantity = Integer.parseInt(scanner.nextLine().trim());
                if (this.quantity > 0) {
                    break; // Số lượng hợp lệ
                } else {
                    System.out.println("Số lượng mua bắt buộc phải lớn hơn 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Bạn phải nhập vào một số nguyên!");
            }
        } while (true);

        // 3. Tự động tính toán thành tiền lưu vào thuộc tính subTotal
        this.subTotal = this.product.getPrice() * this.quantity;
    }

    public void displayData() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi", "VN"));
        if (this.product != null) {
            System.out.println(this.product.getProductId() + ", " +
                    this.product.getProductName() + ", " +
                    nf.format(this.product.getPrice()) + ", " +
                    this.quantity + ", " +
                    nf.format(this.subTotal));
        } else {
            System.out.println("Chi tiết hóa đơn này chưa có thông tin sản phẩm!");
        }
    }
}
