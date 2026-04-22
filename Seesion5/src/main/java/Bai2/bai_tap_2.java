package Bai2;

public class bai_tap_2 {
    public static void main(String[] args) {
        long startTime , endTime;

        String str = "Hello";
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            str += "Word";
        }
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với String : " + (endTime - startTime) + "ms");

        StringBuilder sb = new StringBuilder("Hello");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append("Word");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với StringBuilder : " +  (endTime - startTime) + "ms");

        StringBuffer sbf = new StringBuffer("Hello");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sbf.append("Word");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với StringBuffer : " +  (endTime - startTime) + "ms");

        System.out.println();
        System.out.println("Nhận xét");
        System.out.println("String : Không hiệu quả cho phép nối chuỗi nhiều lần do tạo ra nhiều đối tượng mới");
        System.out.println("StringBuilder : Hiệu quả và nhanh chóng, thích hợp cho nhiều thao tác nối chuỗi trong một luồng");
        System.out.println("StringBuffer : Tương tự như StringBuilder nhưng an toàn với đa luồng , có thể chậm hơn một chút do đồng bộ hoá");

    }
}
