package bai4.business;

import bai3.entity.Manage;
import bai4.entity.Order;

import java.util.ArrayList;

public class OrderManager implements Manage<Order> {
    private ArrayList<Order> orderList = new ArrayList<>();

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    // Hàm tìm số thứ tự (index bắt đầu từ 1) dựa trên mã đơn hàng nhập vào
    public int findIndexById(String id) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getId().equalsIgnoreCase(id.trim())) {
                return i + 1; // Trả về index dạng 1, 2, 3... tương ứng để truyền vào interface
            }
        }
        return -1; // Không tìm thấy
    }


    @Override
    public void add(Order item) {
        orderList.add(item);
        System.out.println("Đơn hàng đã được thêm thành công.");
    }

    @Override
    public void update(int index, Order item) {
        int actualIndex = index - 1; // Chuyển về chỉ số mảng (0, 1...)
        if (actualIndex >= 0 && actualIndex < orderList.size()) {
            orderList.set(actualIndex, item);
            System.out.println("Đơn hàng đã được sửa thành công.");
        } else {
            System.out.println("Không tìm thấy đơn hàng tương ứng.");
        }
    }

    @Override
    public void delete(int index) {
        int actualIndex = index - 1;
        if (actualIndex >= 0 && actualIndex < orderList.size()) {
            orderList.remove(actualIndex);
            System.out.println("Đơn hàng đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy đơn hàng tương ứng.");
        }
    }

    @Override
    public void display() {
        if (orderList.isEmpty()) {
            return;
        }
        int displayIndex = 1;
        for (Order order : orderList) {
            // Định dạng hiển thị đầu dòng: 1. Mã đơn hàng: ...
            System.out.println(displayIndex + ". " + order);
            displayIndex++;
        }
    }
}
