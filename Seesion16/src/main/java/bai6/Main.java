package bai6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo danh sách 5 đơn hàng mẫu
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Nguyễn Văn A", LocalDate.of(2025, 3, 10), LocalDate.of(2025, 3, 15)));
        orders.add(new Order(2, "Trần Thị B", LocalDate.of(2025, 3, 15), LocalDate.of(2025, 3, 18)));
        orders.add(new Order(3, "Lê Hoàng C", LocalDate.of(2025, 3, 16), null));
        orders.add(new Order(4, "Phạm Minh D", LocalDate.of(2025, 3, 17), LocalDate.of(2025, 3, 22)));
        orders.add(new Order(5, "Vũ Lệ E", LocalDate.of(2025, 3, 20), null));

        System.out.println("================ SYSTEM ORDER MANAGEMENT ================");

        // Liệt kê các đơn hàng đã được giao
        System.out.println("\n[1] Danh sách đơn hàng ĐÃ ĐƯỢC GIAO:");
        orders.stream()
                .filter(o -> o.getDeliveryDate().isPresent()) // Lọc những đơn có dữ liệu ngày giao
                .map(Order::toDisplayString)
                .forEach(System.out::println);

        // Liệt kê các đơn hàng chưa được giao
        System.out.println("\n[2] Danh sách đơn hàng CHƯA ĐƯỢC GIAO:");
        orders.stream()
                .filter(o -> !o.getDeliveryDate().isPresent())
                .map(Order::toDisplayString)
                .forEach(System.out::println);

        // Đếm số đơn hàng đã giao trong khoảng từ 2025-03-17 đến 2025-03-23
        LocalDate startDate = LocalDate.of(2025, 3, 17);
        LocalDate endDate = LocalDate.of(2025, 3, 23);

        long count = orders.stream()
                .filter(o -> o.getDeliveryDate().isPresent())
                .filter(o -> {
                    LocalDate dDate = o.getDeliveryDate().get();
                    // Kiểm tra ngày nằm trong khoảng [startDate, endDate] (Bao gồm cả 2 ngày mốc)
                    return !dDate.isBefore(startDate) && !dDate.isAfter(endDate);
                })
                .count();

        System.out.println(String.format("\n[3] Số đơn hàng đã giao từ %s đến %s: %d đơn hàng.", startDate, endDate, count));

        // In thông tin tất cả đơn hàng
        System.out.println("\n[4] Toàn bộ thông tin đơn hàng trong hệ thống:");
        printOrders(orders);

        System.out.println("=========================================================");
    }

    // Hàm tiện ích in danh sách đơn hàng theo gợi ý của đề bài
    public static void printOrders(List<Order> orderList) {
        if (orderList == null || orderList.isEmpty()) {
            System.out.println("(Danh sách trống)");
            return;
        }
        orderList.forEach(o -> System.out.println(o.toDisplayString()));
    }
}
