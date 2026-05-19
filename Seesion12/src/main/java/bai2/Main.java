package bai2;

import bai2.ra.entity.Asset;
import bai2.ra.entity.Computer;
import bai2.ra.entity.NetworkDevice;

import java.util.Scanner;

public class Main {
    private static Asset[] arrAsset = new Asset[100];
    private static int assetCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n========== HỆ THỐNG QUẢN LÝ TÀI SẢN TECHASSET ==========");
            System.out.println("1. Nhập thông tin tài sản mới");
            System.out.println("2. Xuất báo cáo danh sách tài sản (Khấu hao)");
            System.out.println("3. Tìm kiếm tài sản");
            System.out.println("4. Sửa giá mua gốc của tài sản");
            System.out.println("5. Thoát chương trình");
            System.out.print("Lựa chọn của bạn: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        inputAsset(scanner);
                        break;
                    case 2:
                        exportReport();
                        break;
                    case 3:
                        handleSearch(scanner);
                        break;
                    case 4:
                        updatePurchasePrice(scanner);
                        break;
                    case 5:
                        System.out.println("Thoát chương trình!");
                        System.exit(0);
                    default:
                        System.out.println("Vui lòng chọn số từ 1 đến 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Menu yêu cầu nhập vào một chữ số nguyên!");
            }
        }
    }

    private static void inputAsset(Scanner scanner) {
        if (assetCount >= arrAsset.length) {
            System.out.println("Kho tài sản đã đầy bộ nhớ mảng!");
            return;
        }

        while (true) {
            System.out.println("Chọn loại tài sản: 1. Máy tính | 2. Thiết bị mạng");
            System.out.print("Lựa chọn: ");
            String type = scanner.nextLine();

            if (type.equals("1")) {
                Asset comp = new Computer();
                comp.inputData(scanner);

                // Kiểm tra trùng mã tài sản
                if (findAssetIndexByCode(comp.getAssetCode()) == -1) {
                    arrAsset[assetCount++] = comp;
                    System.out.println("Thêm máy tính thành công!");
                    break;
                } else {
                    System.out.println("Mã tài sản này đã tồn tại!");
                }

            } else if (type.equals("2")) {
                Asset net = new NetworkDevice();
                net.inputData(scanner);

                if (findAssetIndexByCode(net.getAssetCode()) == -1) {
                    arrAsset[assetCount++] = net;
                    System.out.println("Thêm thiết bị mạng thành công!");
                    break;
                } else {
                    System.out.println("Mã tài sản này đã tồn tại!");
                }
            } else {
                System.out.println("Vui lòng chọn đúng số 1 hoặc 2!");
            }
        }
    }

    private static void exportReport() {
        if (assetCount == 0) {
            System.out.println("Hệ thống chưa có tài sản nào.");
            return;
        }
        System.out.println("\n------------------- BÁO CÁO KHẤU HAO TÀI SẢN -------------------");
        for (int i = 0; i < assetCount; i++) {
            showValue(arrAsset[i]);
        }
    }

    private static void showValue(Asset a) {
        a.displayData();
    }

    private static void handleSearch(Scanner scanner) {
        if (assetCount == 0) {
            System.out.println("Chưa có tài sản nào để tìm kiếm.");
            return;
        }
        System.out.println("Chọn kiểu tìm kiếm: 1. Tìm theo Mã | 2. Tìm các máy có giá gốc lớn hơn mức quy định");
        System.out.print("Lựa chọn: ");
        String searchType = scanner.nextLine();

        if (searchType.equals("1")) {
            System.out.print("Nhập mã tài sản cần tìm: ");
            String code = scanner.nextLine().trim();
            System.out.println("\n--- Kết quả tìm kiếm theo mã: ---");
            searchAssets(code);

        } else if (searchType.equals("2")) {
            while (true) {
                try {
                    System.out.print("Nhập mức giá gốc tối thiểu: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.println("\n--- Kết quả tìm kiếm tài sản có giá gốc > " + price + ": ---");
                    searchAssets(price);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Giá tìm kiếm phải là một số thực hợp lệ!");
                }
            }
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    private static void searchAssets(String assetCode) {
        boolean found = false;
        for (int i = 0; i < assetCount; i++) {
            if (arrAsset[i].getAssetCode().equalsIgnoreCase(assetCode)) {
                arrAsset[i].displayData();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy tài sản nào có mã khớp yêu cầu.");
        }
    }

    private static void searchAssets(double purchasePrice) {
        boolean found = false;
        for (int i = 0; i < assetCount; i++) {
            if (arrAsset[i].getPurchasePrice() > purchasePrice) {
                arrAsset[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có tài sản nào có giá mua lớn hơn mức bạn nhập.");
        }
    }

    private static void updatePurchasePrice(Scanner scanner) {
        System.out.print("Nhập mã tài sản cần sửa giá gốc: ");
        String code = scanner.nextLine().trim();
        int index = findAssetIndexByCode(code);

        if (index != -1) {
            while (true) {
                try {
                    System.out.println("Tài sản hiện tại: " + arrAsset[index].getName() + " (Giá cũ: " + arrAsset[index].getPurchasePrice() + ")");
                    System.out.print("Nhập giá mua gốc mới: ");
                    double newPrice = Double.parseDouble(scanner.nextLine());
                    if (newPrice > 0) {
                        arrAsset[index].setPurchasePrice(newPrice);
                        System.out.println("Cập nhật giá gốc thành công!");
                        break;
                    }
                    System.out.println("Giá tiền phải lớn hơn 0!");
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi: Giá tiền mới phải là chữ số!");
                }
            }
        } else {
            System.out.println("Không tìm thấy mã tài sản cần cập nhật.");
        }
    }

    private static int findAssetIndexByCode(String code) {
        for (int i = 0; i < assetCount; i++) {
            if (arrAsset[i].getAssetCode().equalsIgnoreCase(code)) return i;
        }
        return -1;
    }
}
