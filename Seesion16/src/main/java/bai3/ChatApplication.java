package bai3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatApplication {
    private static List<Message> chatHistory = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        chatHistory.add(new Message("Trump", "Đi nhậu ko ?", LocalDateTime.of(2025, 5, 21, 10, 43)));
        chatHistory.add(new Message("Trump", "Nhiều mồi lắm :))", LocalDateTime.of(2025, 5, 21, 10, 44)));

        while (true) {
            System.out.println("Nhập tên người gửi (hoặc 'exit' để thoát):");
            String sender = sc.nextLine().trim();

            if (sender.equalsIgnoreCase("exit")) {
                System.out.println("Đã thoát ứng dụng chat.");
                break;
            }

            if (sender.isEmpty()) {
                System.out.println("Tên người gửi không được để trống!");
                continue;
            }

            System.out.println("Nhập nội dung tin nhắn:");
            String content = sc.nextLine().trim();

            // Lưu tin nhắn mới vào danh sách kèm thời gian hiện tại
            Message newMessage = new Message(sender, content, LocalDateTime.now());
            chatHistory.add(newMessage);

            // Menu điều hướng chức năng phụ bằng chuỗi ký tự theo yêu cầu của giao diện mẫu
            System.out.println("Nhập 'history' để xem lịch sử, hoặc 'filter' để lọc tin nhắn theo người gửi, hoặc 'date' để lọc theo ngày:");
            String option = sc.nextLine().trim().toLowerCase();

            switch (option) {
                case "history":
                    showHistory();
                    break;
                case "filter":
                    filterBySender();
                    break;
                case "date":
                    filterByDate();
                    break;
                default:
                    break;
            }
        }
    }

    // Xem lịch sử chat
    private static void showHistory() {
        System.out.println("Lịch sử chat:");
        if (chatHistory.isEmpty()) {
            System.out.println("(Chưa có tin nhắn nào)");
        } else {
            chatHistory.forEach(System.out::println);
        }
    }

    // Lọc tin nhắn theo người gửi bằng Streams API
    private static void filterBySender() {
        System.out.println("Nhập tên người gửi để lọc:");
        String targetSender = sc.nextLine().trim();
        System.out.println("Tin nhắn từ " + targetSender + ":");

        chatHistory.stream()
                .filter(msg -> msg.getSender().equalsIgnoreCase(targetSender))
                .forEach(System.out::println);
    }

    // Lọc tin nhắn theo ngày dùng Streams API và bẫy lỗi Try/Catch
    private static void filterByDate() {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Nhập ngày (dd-MM-yyyy):");
        String dateStr = sc.nextLine().trim();

        try {
            // Ép kiểu chuỗi người dùng nhập về đối tượng LocalDate
            LocalDate targetDate = LocalDate.parse(dateStr, inputFormatter);
            System.out.println("Tin nhắn trong ngày " + targetDate + ":");

            // Tiến hành so sánh phần Ngày (LocalDate) bóc tách từ Timestamp của tin nhắn
            chatHistory.stream()
                    .filter(msg -> msg.getTimestamp().toLocalDate().equals(targetDate))
                    .forEach(System.out::println);

        } catch (DateTimeParseException e) {
            System.out.println("Định dạng ngày không hợp lệ! Vui lòng kiểm tra lại quy cách (dd-MM-yyyy).");
        }
    }
}