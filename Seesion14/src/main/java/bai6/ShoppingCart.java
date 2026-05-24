package bai6;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();

    public ShoppingCart() {
    }

    public ShoppingCart(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public void addToCart(Product product, int quantity){
        // Nếu sản phẩm đã tồn tại trong giỏ -> tăng số lượng
        for (CartItem cartItem: items){
            if (cartItem.getProduct().getId().equalsIgnoreCase(product.getId())){
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                return;
            }
        }

        // Nếu chưa tồn tại -> Thêm mới mục vào giỏ
        items.add(new CartItem(product, quantity));
    }

    public void removeFromCart(String productId) throws ProductNotFoundException {
        CartItem itemToRemove = null;
        for (CartItem item: items){
            if (item.getProduct().getId().equalsIgnoreCase(productId)){
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove == null){
            throw new ProductNotFoundException("Lỗi: Không tìm thấy sản phẩm trong giỏ hàng!");
        }

        items.remove(itemToRemove);
    }

    public void displayCart(){
        if (items.isEmpty()){
            System.out.println("Giỏ hàng của bạn đang trống.");
            return;
        }
        System.out.println("--- CHI TIẾT GIỎ HÀNG ---");
        for (CartItem item : items) {
            System.out.println(item);
        }
    }

    public double checkout(){
        double total = 0;
        for (CartItem item : items) {
            total += item.getAmount();
        }
        return total;
    }
}
