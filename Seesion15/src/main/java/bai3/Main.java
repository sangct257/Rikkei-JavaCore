package bai3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Quản lý danh sách sản phẩm (List Interface)
        List<Product> productList = new ArrayList<>();

        // Quản lý đơn hàng bằng Map với Key là mã đơn hàng (String)
        Map<String, Order> orderMap = new HashMap<>();

        productList.add(new Product(1, "Bánh mỳ", 15000));
        productList.add(new Product(2, "Sữa tươi", 8000));
        productList.add(new Product(3, "Cà phê", 25000));

        while (true) {
            System.out.println("\n============== MENU ==============");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xóa sản phẩm");
            System.out.println("3. Hiển thị sản phẩm");
            System.out.println("4. Tạo đơn hàng");
            System.out.println("5. Thêm sản phẩm vào đơn hàng");
            System.out.println("6. Hiển thị đơn hàng");
            System.out.println("0. Thoát");
            System.out.println("==================================");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Lựa chọn phải là một số nguyên từ 0 đến 6!");
                continue;
            }

            if (choice == 0) {
                System.out.println("Cảm ơn bạn đã sử dụng hệ thống quản lý!");
                break;
            }

            switch (choice) {
                case 1: // Thêm sản phẩm mới vào kho
                    try {
                        System.out.print("Nhập ID sản phẩm (số nguyên): ");
                        int id = Integer.parseInt(scanner.nextLine());

                        // Kiểm tra trùng ID
                        boolean isExist = false;
                        for (Product p : productList) {
                            if (p.getId() == id) {
                                isExist = true;
                                break;
                            }
                        }
                        if (isExist) {
                            System.out.println("Lỗi: ID sản phẩm này đã tồn tại trên hệ thống!");
                            break;
                        }

                        System.out.print("Nhập tên sản phẩm: ");
                        String name = scanner.nextLine().trim();

                        System.out.print("Nhập giá sản phẩm: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        // kiểm tra lỗi giá <= 0
                        if (price <= 0) {
                            throw new InvalidProductPriceException("Lỗi: Giá sản phẩm phải lớn hơn 0!");
                        }

                        productList.add(new Product(id, name, price));
                        System.out.println("Thêm sản phẩm mới thành công!");

                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: ID hoặc Giá nhập vào không đúng định dạng số!");
                    } catch (InvalidProductPriceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2: // Xóa sản phẩm theo ID
                    try {
                        System.out.print("Nhập ID sản phẩm cần xóa: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());

                        Product productToRemove = null;
                        for (Product p : productList) {
                            if (p.getId() == deleteId) {
                                productToRemove = p;
                                break;
                            }
                        }

                        // Phát sinh ngoại lệ nếu xóa sản phẩm không tồn tại
                        if (productToRemove == null) {
                            throw new ProductNotFoundException("Lỗi: Không tìm thấy sản phẩm có ID = " + deleteId + " để xóa!");
                        }

                        productList.remove(productToRemove);
                        System.out.println("Đã xóa sản phẩm thành công khỏi danh sách hệ thống.");

                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: ID sản phẩm phải là một số nguyên!");
                    } catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3: // Hiển thị danh sách sản phẩm hiện có
                    System.out.println("\n--- DANH SÁCH SẢN PHẨM ---");
                    if (productList.isEmpty()) {
                        System.out.println("(Danh sách trống)");
                    } else {
                        for (Product p : productList) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 4: // Tạo một đơn hàng mới rỗng
                    try {
                        System.out.print("Nhập mã đơn hàng muốn tạo (Ví dụ: HD001, HD002): ");
                        String orderCode = scanner.nextLine().trim();

                        if (orderMap.containsKey(orderCode)) {
                            System.out.println("Lỗi: Mã đơn hàng này đã tồn tại!");
                            break;
                        }

                        System.out.print("Nhập số ID đơn hàng (dạng số nguyên): ");
                        int orderId = Integer.parseInt(scanner.nextLine());

                        Order newOrder = new Order(orderId);
                        orderMap.put(orderCode, newOrder); // Lưu trữ đơn hàng theo mã đơn vào Map
                        System.out.println("Tạo đơn hàng [" + orderCode + "] thành công.");

                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: ID đơn hàng phải là một số nguyên!");
                    }
                    break;

                case 5: //Thêm sản phẩm có sẵn vào một đơn hàng cụ thể
                    try {
                        System.out.print("Nhập mã đơn hàng cần thêm sản phẩm: ");
                        String searchOrderCode = scanner.nextLine().trim();

                        // Kiểm tra đơn hàng tồn tại trong Map
                        if (!orderMap.containsKey(searchOrderCode)) {
                            throw new OrderNotFoundException("Lỗi: Đơn hàng [" + searchOrderCode + "] không tồn tại trên hệ thống!");
                        }

                        System.out.print("Nhập ID sản phẩm muốn thêm vào đơn: ");
                        int prodId = Integer.parseInt(scanner.nextLine());

                        // Kiểm tra sản phẩm có trong kho không
                        Product selectedProd = null;
                        for (Product p : productList) {
                            if (p.getId() == prodId) {
                                selectedProd = p;
                                break;
                            }
                        }

                        if (selectedProd == null) {
                            throw new ProductNotFoundException("Lỗi: Không tìm thấy sản phẩm có ID = " + prodId + " trong kho!");
                        }

                        // Tiến hành lấy đơn hàng từ Map ra và add sản phẩm vào đơn
                        Order currentOrder = orderMap.get(searchOrderCode);
                        currentOrder.addProductToOrder(selectedProd);
                        System.out.println("Đã thêm sản phẩm '" + selectedProd.getName() + "' vào đơn hàng [" + searchOrderCode + "] thành công.");

                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: ID sản phẩm phải là số nguyên!");
                    } catch (OrderNotFoundException | ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6: //Hiển thị thông tin chi tiết đơn hàng dựa vào mã đơn
                    try {
                        System.out.print("Nhập mã đơn hàng muốn xem chi tiết: ");
                        String viewOrderCode = scanner.nextLine().trim();

                        // Kiểm tra xem đơn hàng có tồn tại không
                        if (!orderMap.containsKey(viewOrderCode)) {
                            throw new OrderNotFoundException("Lỗi: Truy cập thất bại! Đơn hàng [" + viewOrderCode + "] không tồn tại.");
                        }

                        Order viewOrder = orderMap.get(viewOrderCode);
                        System.out.println("\n--- THÔNG TIN CHI TIẾT ĐƠN HÀNG [" + viewOrderCode + "] ---");
                        System.out.println("ID đơn hàng: " + viewOrder.getOrderId());
                        viewOrder.displayOrderDetails();

                    } catch (OrderNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại từ 0 đến 6.");
            }
        }
        scanner.close();
    }
}
