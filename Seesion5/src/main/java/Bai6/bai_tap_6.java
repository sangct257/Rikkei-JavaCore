package Bai6;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Scanner;

public class bai_tap_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Tạo 1 danh sách chứa tối đa 100 sinh viên
        String[] danhSach = new String[100];
        // Biến đếm số lượng sinh viên có trong mảng
        int soLuong = 0;
        while (true){
            System.out.println("************** Quản Lý Tên Sinh Viên ************");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tìm tên sinh viên chứa từ khóa");
            System.out.println("4. Đếm số sinh viên có tên bắt đầu bằng chữ cái");
            System.out.println("5. Sắp xếp danh sách tên (A-Z)");
            System.out.println("6. Thoát");
            System.out.println("*************************************************");
            System.out.println("Chọn :");
            int chosse = Integer.parseInt(sc.nextLine());
            switch (chosse){
                case 1:
                    if (soLuong > 100){
                        System.out.println("Danh sách đã đầy (100/100), không thể thêm!");
                        break;
                    }
                    System.out.println("Nhập tên sinh viên : ");
                    String ten = sc.nextLine();
                    danhSach[soLuong] = ten; // thêm tên sinh viên vào mảngở vị trống tiếp theo
                    soLuong++; // tăng thêm 1 đơn vị
                    System.out.println("Đã thêm : " +ten);
                    break;
                case 2:
                    if (soLuong == 0) {
                        System.out.println("Danh sách đang trống!");
                        break;
                    }
                    System.out.println("Danh sách sinh viên :");
                    for (int i = 0; i < soLuong; i++) {
                        System.out.println(((i + 1) + ". " + danhSach[i]));
                    }
                    break;
                case 3:
                    if (soLuong == 0) {
                        System.out.println("Danh sách đang trống!");
                        break;
                    }
                    System.out.println("Nhập từ khoá : ");
                    String tuKhoa = sc.nextLine();
                    boolean timThay = false;
                    System.out.println("Kết quả tìm kiếm : ");
                    for (int i = 0; i < soLuong; i++) {
                        // Dùng contains() để xem tên có chứa từ khóa không (không phân biệt hoa thường)
                        if (danhSach[i].toLowerCase().contains(tuKhoa.toLowerCase())) {
                            System.out.println("- " + danhSach[i]);
                            timThay = true;
                        }
                    }
                        if (!timThay) System.out.println("Không tìm thấy sinh viên nào chứa từ khóa: " + tuKhoa);
                        break;
                case 4:
                    if (soLuong == 0) {
                        System.out.println("Danh sách đang trống!");
                        break;
                    }
                    System.out.print("Nhập chữ cái : ");
                    String chuCai = sc.nextLine();
                    int dem = 0;

                    for (int i = 0; i < soLuong; i++) {
                        // Dùng startsWith() để kiểm tra chữ cái đầu
                        if (danhSach[i].toLowerCase().startsWith(chuCai.toLowerCase())) {
                            dem++;
                        }
                    }
                    System.out.println("Số sinh viên có tên bắt dầu bằng '"+ chuCai + "' : " + dem);
                    break;
                case 5:
                    if (soLuong == 0) {
                        System.out.println("Danh sách đang trống!");
                        break;
                    }
                    // Nếu sếp sort cả mảng 100 phần tử, nó sẽ bị lỗi vì các phần tử trống mang giá trị null
                    Arrays.sort(danhSach, 0, soLuong);
                    System.out.println("Danh sách đã được sắp xếp A-Z. Bấm phím 2 để xem lại nhé!");
                    break;
                case 6:
                    System.out.println("Tạm biệt!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn từ 1 đến 6!");
            }
        }
    }
}
