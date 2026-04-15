package Bai1;

import java.util.Scanner;

public class bai_tap_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=========== NHẬP THÔNG TIN HOÁ ĐƠN ============");
        System.out.print("Nhập tên khách hàng: ");
        String name = sc.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        String product = sc.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        float price = sc.nextFloat();

        System.out.print("Nhập số lượng mua: ");
        int quantity = sc.nextInt();

        System.out.print("Khách có thẻ thành viên? (true/false) :");
        boolean theThanhVien = sc.nextBoolean();

        float thanhTien = price * quantity;
        // nếu có thẻ thành viên thì giảm giá 10% k có thì giảm giá 0
        float giamGia = theThanhVien ? thanhTien * 10 /100 : 0;
        float VAT = thanhTien * 8/100;

        float tongThanhToan = thanhTien - giamGia + VAT;

        System.out.println("================== HOÁ ĐƠN ===================");
        System.out.println("Khách hàng : " + name);
        System.out.println("Sản phẩm : " + product);
        System.out.println("Số lượng : "+quantity);

        System.out.printf("Đơn giá : %,.2f VND \n",price);
        System.out.printf("Thành tiền : %,.2f VND \n",thanhTien);
        System.out.printf("Giảm giá thành viên (10%%) : %,.2f VND \n" ,giamGia);
        System.out.printf("Tiền VAT (8%%) : %,.2f VND \n",VAT);
        System.out.printf("Tổng tiền thanh toán : %,.2f VND \n" ,tongThanhToan);
        System.out.println("===============================================");
    }
}
