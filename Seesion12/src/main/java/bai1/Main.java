package bai1;

import bai1.ra.entity.AdminStaff;
import bai1.ra.entity.Lecturer;
import bai1.ra.entity.Staff;

import java.util.Scanner;

public class Main {
    private static Staff[] arrStaff = new Staff[100];
    private static int staffCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n========== QUẢN LÝ NHÂN SỰ EDUCAREER (MẢNG 1 CHIỀU) ==========");
            System.out.println("1. Thêm mới nhân sự");
            System.out.println("2. Hiển thị danh sách nhân sự (Tính lương Đa hình)");
            System.out.println("3. Cập nhật thông tin nhân sự theo ID");
            System.out.println("4. Xóa nhân sự theo ID");
            System.out.println("5. Thoát chương trình");
            System.out.print("Lựa chọn chức năng: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addNewStaff(scanner);
                        break;
                    case 2:
                        showAllStaff();
                        break;
                    case 3:
                        updateStaff(scanner);
                        break;
                    case 4:
                        deleteStaff(scanner);
                        break;
                    case 5:
                        System.out.println("Thoát chương trình!");
                        System.exit(0);
                    default:
                        System.out.println("Vui lòng chọn số từ 1 đến 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Lựa chọn menu phải là số nguyên!");
            }
        }
    }

    private static void addNewStaff(Scanner scanner) {
        if (staffCount >= arrStaff.length) {
            System.out.println("Bộ nhớ mảng đã đầy, không thể thêm mới!");
            return;
        }

        while (true) {
            System.out.println("Chọn nhóm nhân sự muốn thêm: 1. Giảng viên | 2. Nhân viên hành chính");
            System.out.print("Lựa chọn của bạn: ");
            String type = scanner.nextLine();

            if (type.equals("1")) {
                Staff lec = new Lecturer();
                lec.inputData(scanner);

                // Check trùng mã ID trong mảng
                if (findStaffIndexById(lec.getId()) == -1) {
                    arrStaff[staffCount] = lec;
                    staffCount++;
                    System.out.println("Thêm giảng viên thành công!");
                    break;
                } else {
                    System.out.println("Mã ID này đã tồn tại trong hệ thống!");
                }

            } else if (type.equals("2")) {
                Staff admin = new AdminStaff();
                admin.inputData(scanner);

                if (findStaffIndexById(admin.getId()) == -1) {
                    arrStaff[staffCount] = admin;
                    staffCount++;
                    System.out.println("Thêm nhân viên hành chính thành công!");
                    break;
                } else {
                    System.out.println("Mã ID này đã tồn tại trong hệ thống!");
                }
            } else {
                System.out.println("Vui lòng chỉ chọn số 1 hoặc số 2!");
            }
        }
    }

    private static void showAllStaff() {
        if (staffCount == 0) {
            System.out.println("⚠️ Hệ thống trống. Chưa có nhân sự nào đăng ký.");
            return;
        }
        System.out.println("\n--- DANH SÁCH NHÂN SỰ TOÀN TRUNG TÂM ---");
        for (int i = 0; i < staffCount; i++) {
            arrStaff[i].displayData();
        }
    }

    private static void updateStaff(Scanner scanner) {
        System.out.print("Nhập mã ID nhân sự cần sửa thông tin: ");
        String searchId = scanner.nextLine().trim();
        int foundIndex = findStaffIndexById(searchId);

        if (foundIndex != -1) {
            System.out.println("Tiến hành nhập thông tin mới cho nhân sự:");
            arrStaff[foundIndex].inputData(scanner);
            System.out.println("Cập nhật thông tin thành công!");
        } else {
            System.out.println("Không tìm thấy nhân sự mang mã ID: " + searchId);
        }
    }

    private static void deleteStaff(Scanner scanner) {
        System.out.print("Nhập mã ID nhân sự muốn xóa: ");
        String delId = scanner.nextLine().trim();
        int delIndex = findStaffIndexById(delId);

        if (delIndex != -1) {
            for (int i = delIndex; i < staffCount - 1; i++) {
                arrStaff[i] = arrStaff[i + 1];
            }
            arrStaff[staffCount - 1] = null;
            staffCount--;
            System.out.println("Đã xóa nhân sự thành công khỏi hệ thống.");
        } else {
            System.out.println("Không tìm thấy mã ID nhân sự cần xóa.");
        }
    }

    private static int findStaffIndexById(String id) {
        for (int i = 0; i < staffCount; i++) {
            if (arrStaff[i].getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
}
