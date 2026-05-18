package bai6.ra.entity;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private double price;
    private Status status;

    public Product() {
    }

    public Product(String productId, String productName, double price, Status status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, Product[] arrProd, int index) {
        getProductId(scanner, arrProd, index);
        getProductName(scanner, arrProd, index);
        getProductPrice(scanner);
        getProductStatus(scanner);
    }

    public void inputUpdateData(Scanner scanner, Product[] arrProd, int index) {
        getProductName(scanner, arrProd, index);
        getProductPrice(scanner);
        getProductStatus(scanner);
    }

    private void getProductId(Scanner scanner, Product[] arrProd, int index) {
        do {
            System.out.print("Mời nhập vào mã sản phẩm (Ví dụ: C001, S002, A003): ");
            this.productId = scanner.nextLine().trim();

            // Khớp định dạng: Bắt đầu bằng C, S hoặc A và theo sau là 3 chữ số (Tổng 4 ký tự)
            if (this.productId.matches("^[CSA]\\d{3}$")) {
                if (checkIdProductExist(this.productId, arrProd, index)) {
                    System.out.println("Mã sản phẩm đã tồn tại trên hệ thống!");
                } else {
                    break; // Thỏa mãn điều kiện
                }
            } else {
                System.out.println("Mã sản phẩm không đúng định dạng (Phải gồm 4 ký tự và bắt đầu bằng chữ C, S hoặc A)!");
            }
        } while (true);
    }

    private void getProductName(Scanner scanner, Product[] arrProd, int index) {
        do {
            System.out.print("Mời nhập vào tên sản phẩm (10-50 ký tự): ");
            this.productName = scanner.nextLine().trim();

            if (this.productName.length() >= 10 && this.productName.length() <= 50) {
                if (checkNameProductExist(this.productName, arrProd, index)) {
                    System.out.println("Tên sản phẩm đã tồn tại trên hệ thống!");
                } else {
                    break; // Thỏa mãn điều kiện
                }
            } else {
                System.out.println("Tên sản phẩm bắt buộc phải từ 10 đến 50 ký tự!");
            }
        } while (true);
    }

    private void getProductPrice(Scanner scanner) {
        do {
            try {
                System.out.print("Mời nhập vào giá bán sản phẩm (> 0): ");
                this.price = Double.parseDouble(scanner.nextLine().trim());
                if (this.price > 0) {
                    break;
                } else {
                    System.out.println("Giá bán sản phẩm phải lớn hơn 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Giá bán phải là một số thực hợp lệ!");
            }
        } while (true);
    }

    private void getProductStatus(Scanner scanner) {
        do {
            try {
                System.out.print("Chọn trạng thái sản phẩm (1. AVAILABLE, 2. OUT_OF_STOCK, 3. STOP_SELLING): ");
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= 1 && choice <= Status.values().length) {
                    this.status = Status.values()[choice - 1];
                    break;
                } else {
                    System.out.println("Vui lòng chỉ chọn số thứ tự từ 1 đến 3!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Bạn phải nhập vào số nguyên!");
            }
        } while (true);
    }

    public boolean checkIdProductExist(String id, Product[] products, int index) {
        for (int i = 0; i < index; i++) {
            if (products[i].getProductId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkNameProductExist(String name, Product[] products, int index) {
        for (int i = 0; i < index; i++) {
            // Khi cập nhật thông tin sản phẩm hiện tại, nếu người dùng giữ nguyên tên cũ 
            // thì không coi là trùng với chính nó. (Nếu tên trùng mà khác ID thì mới báo trùng)
            if (products[i].getProductName().equalsIgnoreCase(name)
                    && !products[i].getProductId().equalsIgnoreCase(this.productId)) {
                return true;
            }
        }
        return false;
    }

    public void displayData() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi", "VN"));
        System.out.println("Mã sản phẩm: " + this.productId + ", Tên sản phẩm: " + this.productName + ", Giá: " + nf.format(this.price) + ", Trạng thái: " + this.status);
    }
}
