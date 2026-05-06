package org.example.bai3;

public class CurrencyConverter {
    /*
     * [Mục tiêu: Quản lý trạng thái toàn cục - Global State]
     * Sử dụng biến static để lưu trữ tỉ giá dùng chung cho toàn bộ hệ thống.
     * Thuộc tính để private để thực hiện tính đóng gói, tránh sửa đổi tùy tiện.
     */
    private static Double exchangeRate = 25000.0;

    /*
     * [Mô tả: Phương thức setRate]
     * Kiểm tra tỉ giá phải là số dương mới được phép cập nhật vào hệ thống.
     */
    public static void setRate(Double r){
        if (r > 0){
            exchangeRate = r;
            System.out.println("Cập nhật tỉ giá mới: 1 USD = " + r + " VND");
        } else {
            System.out.println("Lỗi: Tỉ giá phải lớn hơn 0");
        }
    }

    /*
     * [Mô tả: Phương thức getRate - Optional]
     * Cho phép các lớp bên ngoài truy xuất tỉ giá hiện hành mà không cần can thiệp trực tiếp vào biến.
     */
    public static Double getRate() {
        return exchangeRate;
    }

    /*
     * Nhận vào Integer (vì tiền VND không có xu lẻ) và trả về Double (USD cần phần thập phân).
     * Có xử lý ràng buộc để số tiền quy đổi không được âm.
     */
    public static Double toUSD(Integer vnd){
        if (vnd < 0){
            System.out.println("Lỗi: số tiền VND không được âm!");
            return 0.0;
        }
        return vnd / exchangeRate;
    }

    /*
     * Phương thức phụ trợ để làm tròn kết quả đến 2 chữ số thập phân.
     */
    public static String formatUSD(Double usd) {
        return String.format("%.2f USD", usd);
    }

    public static void main(String[] args) {
        Integer moneyVND = 1000000;

        System.out.println("--- THỰC THI QUY ĐỔI TIỀN TỆ ---");

        // Sử dụng tỉ giá mặc định được lưu trữ trong biến static
        System.out.println("Tỉ giá hiện tại: 1 USD = " + CurrencyConverter.getRate() + " VND");
        Double result1 = CurrencyConverter.toUSD(moneyVND);
        System.out.println("Kết quả: " + moneyVND + " VND = " + CurrencyConverter.formatUSD(result1));

        System.out.println();

        // Thay đổi trạng thái toàn cục (Thay đổi biến static qua phương thức static)
        System.out.println("--- CẬP NHẬT TỈ GIÁ THỊ TRƯỜNG ---");
        CurrencyConverter.setRate(25450.5);
        Double result2 = CurrencyConverter.toUSD(moneyVND);
        System.out.println("Kết quả sau khi đổi tỉ giá: " + moneyVND + " VND = " + CurrencyConverter.formatUSD(result2));
    }
}