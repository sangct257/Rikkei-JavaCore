package bai4;

import java.util.List;
import java.util.function.Predicate;

public interface ProductProcessor {
    // Phương thức trừu tượng (Abstract method)
    double calculateTotalValue(List<Product> products);

    // Phương thức tĩnh (Static method) - Dùng chung không cần khởi tạo đối tượng
    static void printProductList(List<Product> products) {
        if (products == null || products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }
        // Sử dụng for-each để in danh sách theo gợi ý
        for (Product p : products) {
            System.out.println(p);
        }
    }

    // Phương thức mặc định (Default method) - Có sẵn logic xử lý, dùng Predicate
    default boolean hasExpensiveProduct(List<Product> products) {
        // Định nghĩa bộ lọc Predicate: Điều kiện giá sản phẩm > 100
        Predicate<Product> isExpensive = p -> p.getPrice() > 100;

        // Sử dụng Streams API kết hợp Predicate kiểm tra nhanh
        return products.stream().anyMatch(isExpensive);
    }
}
