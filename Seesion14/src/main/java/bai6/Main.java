package bai6;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi", "VN"));
        ShoppingCart cart = new ShoppingCart();

        List<Product> storeProducts = new ArrayList<>();
        storeProducts.add(new Product("P001", "Điện thoại iPhone", 25000000));
        storeProducts.add(new Product("P002", "Laptop Asus", 18500000));
        storeProducts.add(new Product("P003", "Tai nghe Sony", 3200000));

        int choice = -1;
        while (true) {
            System.out.println("\n============ MENU ============");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm vào giỏ hàng");
            System.out.println("3. Xóa sản phẩm khỏi giỏ hàng");
            System.out.println("4. Xem giỏ hàng");
            System.out.println("5. Thanh toán");
            System.out.println("0. Thoát");
            System.out.println("==============================");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Lựa chọn menu phải là số nguyên!");
                continue;
            }

            if (choice == 0) {
                System.out.println("Cảm ơn bạn đã sử dụng hệ thống!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("\n--- DANH SÁCH SẢN PHẨM CÓ SẴN ---");
                    for (Product p : storeProducts) {
                        System.out.println(p);
                    }
                    break;

                case 2:
                    System.out.print("Nhập mã sản phẩm muốn mua: ");
                    String addId = scanner.nextLine().trim();

                    Product selectedProduct = null;
                    for (Product p : storeProducts) {
                        if (p.getId().equalsIgnoreCase(addId)) {
                            selectedProduct = p;
                            break;
                        }
                    }

                    if (selectedProduct == null) {
                        System.out.println("Lỗi: Mã sản phẩm không tồn tại tại cửa hàng!");
                        break;
                    }

                    try {
                        System.out.print("Nhập số lượng cần mua: ");
                        int quantity = Integer.parseInt(scanner.nextLine());

                        if (quantity <= 0) {
                            throw new IllegalArgumentException();
                        }

                        cart.addToCart(selectedProduct, quantity);
                        System.out.println("Đã thêm sản phẩm vào giỏ hàng thành công.");

                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Số lượng không hợp lệ!");
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã sản phẩm cần xóa khỏi giỏ: ");
                    String removeId = scanner.nextLine().trim();
                    try {
                        cart.removeFromCart(removeId);
                        System.out.println("Đã xóa sản phẩm khỏi giỏ hàng thành công.");
                    } catch (ProductNotFoundException e) {

                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println();
                    cart.displayCart();
                    break;

                case 5:
                    System.out.println();
                    cart.displayCart();
                    double total = cart.checkout();
                    System.out.println("---------------------------------");
                    System.out.println("TỔNG TIỀN CẦN THANH TOÁN: " + nf.format(total));
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 0 đến 5.");
            }
        }
        scanner.close();
    }
}
