package bai4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo danh sách sản phẩm mẫu
        List<Product> storeProducts = new ArrayList<>();
        storeProducts.add(new Product("Mì tôm", 5.5));
        storeProducts.add(new Product("Nước ngọt", 12.0));
        storeProducts.add(new Product("Tai nghe không dây", 150.0)); // Giá > 100
        storeProducts.add(new Product("Bàn phím cơ", 85.0));
        storeProducts.add(new Product("Sách lập trình Java", 120.0)); // Giá > 100

        // Khởi tạo đối tượng xử lý logic
        ProductProcessor processor = new ProductProcessorImpl();

        System.out.println("========= CHƯƠNG TRÌNH QUẢN LÝ CỬA HÀNG =========");

        // Kiểm tra xem cửa hàng có sản phẩm đắt tiền (> 100) hay không
        System.out.println("\n[1] Kiểm tra sản phẩm đắt tiền (> 100):");
        if (processor.hasExpensiveProduct(storeProducts)) {
            System.out.println("=> Cửa hàng CÓ chứa sản phẩm đắt tiền.");
            System.out.println("Danh sách các sản phẩm giá cao cụ thể:");
            // Sử dụng stream lọc nhanh và hiển thị các sản phẩm thỏa mãn điều kiện
            storeProducts.stream()
                    .filter(p -> p.getPrice() > 100)
                    .forEach(System.out::println);
        } else {
            System.out.println("=> Không có sản phẩm đắt tiền");
        }

        // Tính tổng giá trị toàn bộ kho hàng
        System.out.println("\n[2] Tính tổng giá trị kho hàng:");
        double totalValue = processor.calculateTotalValue(storeProducts);
        System.out.println("=> Tổng giá trị tất cả sản phẩm: $" + totalValue);

        // In toàn bộ danh sách bằng phương thức tĩnh static trong Interface
        System.out.println("\n[3] Xuất toàn bộ danh sách sản phẩm (Dùng Static Method):");
        ProductProcessor.printProductList(storeProducts);

        System.out.println("=================================================");
    }
}
