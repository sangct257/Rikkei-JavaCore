package bai2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SubjectManager<Subject> manager = new SubjectManager<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        manager.addSubject(new Subject("MH01", "Lap trinh Java", 4, LocalDate.of(2026, 5, 1)));
        manager.addSubject(new Subject("MH02", "Co so du lieu", 3, LocalDate.of(2026, 5, 15)));
        manager.addSubject(new Subject("MH03", "Cau truc du lieu", 4, LocalDate.of(2026, 6, 1)));

        while (true) {
            System.out.println("\n============ QUẢN LÝ MÔN HỌC ============");
            System.out.println("1. Hiển thị danh sách môn học");
            System.out.println("2. Thêm môn học mới");
            System.out.println("3. Xóa môn học theo mã (Code)");
            System.out.println("4. Tìm kiếm môn học theo tên");
            System.out.println("5. Lọc môn học có tín chỉ > 3");
            System.out.println("0. Thoát");
            System.out.println("========================================");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên từ 0 đến 5!");
                continue;
            }

            if (choice == 0) {
                System.out.println("Đã đóng chương trình quản lý.");
                break;
            }

            switch (choice) {
                case 1: // Hiển thị danh sách
                    System.out.println("\n--- DANH SÁCH MÔN HỌC HIỆN CÓ ---");
                    manager.displayAll();
                    break;

                case 2: // Thêm môn học
                    System.out.print("Nhập mã môn học (code): ");
                    String code = scanner.nextLine().trim();
                    if (manager.isCodeExist(code)) {
                        System.out.println("Lỗi: Mã môn học này đã tồn tại trên hệ thống!");
                        break;
                    }

                    System.out.print("Nhập tên môn học (name): ");
                    String name = scanner.nextLine().trim();

                    // Vòng lặp kiểm tra tín chỉ + ném ngoại lệ vi phạm nghiệp vụ
                    int credits = -1;
                    while (true) {
                        System.out.print("Nhập số tín chỉ (credits): ");
                        try {
                            credits = Integer.parseInt(scanner.nextLine());
                            // Áp dụng Exception Handling cho số tín chỉ hợp lệ (0 < credits <= 10)
                            if (credits <= 0 || credits > 10) {
                                throw new IllegalArgumentException("Số tín chỉ không hợp lệ! Phải lớn hơn 0 và nhỏ hơn hoặc bằng 10.");
                            }
                            break; // Nhập đúng thì thoát vòng lặp bẫy lỗi
                        } catch (NumberFormatException e) {
                            System.out.println("Lỗi: Số tín chỉ nhập vào phải là định dạng số nguyên!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Lỗi: " + e.getMessage());
                        }
                    }

                    // Vòng lặp ép nhập đúng định dạng ngày tháng
                    LocalDate startDate = null;
                    while (startDate == null) {
                        System.out.print("Nhập ngày bắt đầu (dd-MM-yyyy): ");
                        try {
                            startDate = LocalDate.parse(scanner.nextLine().trim(), formatter);
                        } catch (DateTimeParseException e) {
                            System.out.println("Lỗi: Sai định dạng ngày! Vui lòng nhập lại đúng dạng ngày-tháng-năm (Ví dụ: 25-05-2026).");
                        }
                    }

                    manager.addSubject(new Subject(code, name, credits, startDate));
                    System.out.println("Thêm môn học mới thành công!");
                    break;

                case 3: // Xóa môn học
                    System.out.print("Nhập mã môn học cần xóa: ");
                    String removeCode = scanner.nextLine().trim();
                    if (manager.deleteByCode(removeCode)) {
                        System.out.println("Đã xóa môn học " + removeCode + " thành công.");
                    } else {
                        System.out.println("Lỗi: Không tìm thấy môn học có mã " + removeCode + " để xóa!");
                    }
                    break;

                case 4: // Tìm kiếm môn học theo tên (Sử dụng Optional)
                    System.out.print("Nhập tên môn học muốn tìm: ");
                    String searchName = scanner.nextLine().trim();
                    Optional<Subject> resultOpt = manager.searchByName(searchName);

                    // Thực hành Optional xử lý trường hợp không tìm thấy dữ liệu
                    if (resultOpt.isPresent()) {
                        System.out.println("Môn học tìm thấy: " + resultOpt.get());
                    } else {
                        System.out.println("Không có môn học phù hợp.");
                    }
                    break;

                case 5: // Lọc môn học theo tín chỉ (> 3)
                    System.out.println("\n--- CÁC MÔN HỌC CÓ TRÊN 3 TÍN CHỈ ---");
                    List<Subject> filteredList = manager.filterByCredits(3);
                    if (filteredList.isEmpty()) {
                        System.out.println("Không có môn học nào có số tín chỉ lớn hơn 3.");
                    } else {
                        filteredList.forEach(System.out::println);
                    }
                    break;

                default:
                    System.out.println("Lựa chọn không nằm trong danh mục menu! Vui lòng chọn lại.");
            }
        }
        scanner.close();
    }
}
