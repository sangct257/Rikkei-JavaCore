package bai4;

import java.util.List;

public class ProductProcessorImpl implements ProductProcessor{
    @Override
    public double calculateTotalValue(List<Product> products) {
        if (products == null || products.isEmpty()) {
            return 0.0;
        }
        // Áp dụng Stream API để map đối tượng sang kiểu double rồi tính tổng
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
