package bai2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Event> eventList = new ArrayList<>();

        // Định dạng đọc dữ liệu đầu vào: dd/MM/yyyy HH:mm
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        while (true) {
            System.out.println("Nhập tên sự kiện (hoặc 'exit' để thoát):");
            String name = sc.nextLine().trim();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            // Xử lý kiểm tra chuỗi rỗng
            if (name.isEmpty()) {
                System.out.println("Can not enter empty string");
                continue;
            }

            LocalDateTime startDate = null;
            // Vòng lặp ép nhập đúng thời gian bắt đầu
            while (true) {
                System.out.println("Nhập thời gian bắt đầu (dd/MM/yyyy HH:mm):");
                String startStr = sc.nextLine().trim();
                try {
                    startDate = LocalDateTime.parse(startStr, inputFormatter);
                    break; // thoát vòng lặp
                } catch (DateTimeParseException e) {
                    System.out.println("Enter not valid date");
                }
            }

            LocalDateTime endDate = null;
            // Vòng lặp ép nhập đúng thời gian kết thúc
            while (true) {
                System.out.println("Nhập thời gian kết thúc (dd/MM/yyyy HH:mm):");
                String endStr = sc.nextLine().trim();
                try {
                    endDate = LocalDateTime.parse(endStr, inputFormatter);

                    // kiểm tra đảm bảo ngày kết thúc không nằm trước ngày bắt đầu
                    if (endDate.isBefore(startDate)) {
                        System.out.println("Thời gian kết thúc phải sau thời gian bắt đầu! Vui lòng nhập lại.");
                        continue;
                    }
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Enter not valid date");
                }
            }

            // Khởi tạo đối tượng và nạp vào danh sách quản lý
            Event event = new Event(name, startDate, endDate);
            eventList.add(event);
        }

        // Khối hiển thị toàn bộ danh sách kết quả sau khi thoát chương trình
        System.out.println("Danh sách sự kiện:");
        if (eventList.isEmpty()) {
            System.out.println("(Trống)");
        } else {
            eventList.forEach(System.out::println);
        }

        sc.close();
    }
}
