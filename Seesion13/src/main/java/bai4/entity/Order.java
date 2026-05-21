package bai4.entity;

public class Order {
    private String id; // Mã đơn hàng (VD: Od0001, Od0002)
    private String customerName;

    public Order() {
    }

    public Order(String id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


}
