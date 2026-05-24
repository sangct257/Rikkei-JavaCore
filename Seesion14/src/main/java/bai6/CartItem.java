package bai6;

import java.text.NumberFormat;
import java.util.Locale;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem() {
    }

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
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

    // Phương thức tính thành tiền cho từng sản phẩm
    public double getAmount() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi","VN"));
        return "CartItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", amount=" + nf.format(getAmount()) +
                '}';
    }
}
