package bai1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductManager {
    private static Map<Integer, Product> productMap = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        productMap.put(2, new Product(2, "Khoai tây chiên", 20000.0));
        productMap.put(3, new Product(3, "Kẹo cốm", 50.0));

        int choice;
        do {
            System.out.println("\n--- Product Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Filter Products (Price > 100)");
            System.out.println("6. Total Value of Products");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            // Xử lý chống trôi lệnh khi nhập số
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    displayProducts();
                    break;
                case 5:
                    filterProducts();
                    break;
                case 6:
                    totalValue();
                    break;
                case 0:
                    System.out.println("Exiting program... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    // Chức năng thêm mới sản phẩm
    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (productMap.containsKey(id)) {
            System.out.println("Product ID already exists!");
            return;
        }

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Product Price: ");
        double price = sc.nextDouble();

        Product p = new Product(id, name, price);
        productMap.put(id, p);
        System.out.println("Product added successfully.");
    }

    // Chức năng sửa đổi thông tin sản phẩm
    private static void editProduct() {
        System.out.print("Enter Product ID to edit: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!productMap.containsKey(id)) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter new Product Name: ");
        String newName = sc.nextLine();
        System.out.print("Enter new Product Price: ");
        double newPrice = sc.nextDouble();

        Product p = productMap.get(id);
        p.setName(newName);
        p.setPrice(newPrice);
        System.out.println("Product updated successfully.");
    }

    // Chức năng xóa sản phẩm theo ID
    private static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();

        if (productMap.containsKey(id)) {
            productMap.remove(id);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Chức năng hiển thị toàn bộ danh sách sản phẩm
    private static void displayProducts() {
        if (productMap.isEmpty()) {
            System.out.println("The product list is empty.");
            return;
        }
        productMap.values().forEach(System.out::println);
    }

    // Chức năng lọc sản phẩm có Price > 100 sử dụng Streams API
    private static void filterProducts() {
        System.out.println("Products with price greater than 100:");
        productMap.values().stream()
                .filter(p -> p.getPrice() > 100)
                .forEach(System.out::println);
    }

    // Chức năng tính tổng giá trị toàn bộ sản phẩm bằng Streams API
    private static void totalValue() {
        double total = productMap.values().stream()
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("Total value of products: " + total);
    }
}
