package bai3;

import bai3.ra.entity.Coffee;
import bai3.ra.entity.Drink;
import bai3.ra.entity.FruitTea;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static Drink[] menuDrink = new Drink[50];
    private static int drinkCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n========== HỆ THỐNG MENU COFFEESHOP PRO ==========");
            System.out.println("1. Thêm món mới vào Menu");
            System.out.println("2. Hiển thị Menu của quán");
            System.out.println("3. Áp dụng chương trình giảm giá (%)");
            System.out.println("4. Xóa món khỏi danh mục Menu");
            System.out.println("5. Thống kê giá tiền trung bình");
            System.out.println("6. Thoát chương trình");
            System.out.print("Lựa chọn chức năng của bạn: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addDrink(scanner);
                        break;
                    case 2:
                        displayMenu();
                        break;
                    case 3:
                        applyPromotion(scanner);
                        break;
                    case 4:
                        deleteDrink(scanner);
                        break;
                    case 5:
                        calculateAveragePrice();
                        break;
                    case 6:
                        System.out.println("Thoát chương trình.");
                        System.exit(0);
                    default:
                        System.out.println("Vui lòng chọn đúng số từ 1 đến 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi nhập liệu: Lựa chọn menu phải là số nguyên!");
            }
        }
    }

    private static void addDrink(Scanner scanner) {
        if (drinkCount >= menuDrink.length) {
            System.out.println("Danh mục Menu đã đầy, không thể thêm món mới!");
            return;
        }

        while (true) {
            System.out.println("Chọn phân loại đồ uống: 1. Cà phê | 2. Trà trái cây");
            System.out.print("Lựa chọn: ");
            String type = scanner.nextLine();

            if (type.equals("1")) {
                Drink coffee = new Coffee();
                coffee.inputData(scanner);

                if (findDrinkIndexById(coffee.getId()) == -1) {
                    menuDrink[drinkCount++] = coffee;
                    System.out.println("Thêm món Cà phê vào Menu thành công!");
                    break;
                } else {
                    System.out.println("Mã đồ uống này đã tồn tại trên Menu!");
                }

            } else if (type.equals("2")) {
                Drink tea = new FruitTea();
                tea.inputData(scanner);

                if (findDrinkIndexById(tea.getId()) == -1) {
                    menuDrink[drinkCount++] = tea;
                    System.out.println("Thêm món Trà trái cây vào Menu thành công!");
                    break;
                } else {
                    System.out.println("Mã đồ uống này đã tồn tại trên Menu!");
                }
            } else {
                System.out.println("Sai lựa chọn! Vui lòng chỉ nhập số 1 hoặc số 2.");
            }
        }
    }

    private static void displayMenu() {
        if (drinkCount == 0) {
            System.out.println("Menu quán đang trống! Hãy chọn chức năng 1 để thêm món.");
            return;
        }
        System.out.println("\n-------------------- MENU COFFEESHOP PRO --------------------");
        for (int i = 0; i < drinkCount; i++) {
            menuDrink[i].displayData();
        }
        System.out.println("-------------------------------------------------------------");
    }

    private static void applyPromotion(Scanner scanner) {
        if (drinkCount == 0) {
            System.out.println("Không có món nào trên menu để áp dụng giảm giá.");
            return;
        }

        double percent = 0;
        while (true) {
            try {
                System.out.print("Nhập phần trăm giảm giá muốn áp dụng (0 - 100%): ");
                percent = Double.parseDouble(scanner.nextLine());
                if (percent >= 0 && percent <= 100) {
                    break;
                } else {
                    System.out.println("Phần trăm giảm giá phải nằm trong khoảng từ 0 đến 100%!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi nhập liệu: Phần trăm giảm giá phải là một số thực!");
            }
        }

        for (int i = 0; i < drinkCount; i++) {
            menuDrink[i].applyDiscount(percent);
        }
        System.out.println("Đã áp dụng giảm giá " + percent + "% thành công cho toàn bộ đồ uống trên Menu!");
    }

    private static void deleteDrink(Scanner scanner) {
        System.out.print("Nhập mã đồ uống muốn loại bỏ khỏi Menu: ");
        String delId = scanner.nextLine().trim();
        int delIndex = findDrinkIndexById(delId);

        if (delIndex != -1) {
            for (int i = delIndex; i < drinkCount - 1; i++) {
                menuDrink[i] = menuDrink[i + 1];
            }
            menuDrink[drinkCount - 1] = null;
            drinkCount--;
            System.out.println("Đã xóa món thành công khỏi danh mục Menu.");
        } else {
            System.out.println("Không tìm thấy mã đồ uống nào khớp yêu cầu trên Menu.");
        }
    }

    private static void calculateAveragePrice() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi","VN"));
        if (drinkCount == 0) {
            System.out.println("Giá tiền trung bình của thực đơn hiện tại: 0đ");
            return;
        }

        double totalSum = 0;
        for (int i = 0; i < drinkCount; i++) {
            totalSum += menuDrink[i].getPrice(); // Cộng dồn giá tiền
        }

        double average = totalSum / drinkCount;
        System.out.println("Thực đơn đang có "+drinkCount+" món , Tổng giá trị: "+ nf.format(totalSum));
        System.out.println("Giá bán trung bình của mỗi đồ uống: "+ nf.format(average));
    }

    private static int findDrinkIndexById(String id) {
        for (int i = 0; i < drinkCount; i++) {
            if (menuDrink[i].getId().equalsIgnoreCase(id)) return i;
        }
        return -1;
    }
}
