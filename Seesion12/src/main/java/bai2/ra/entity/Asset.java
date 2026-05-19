package bai2.ra.entity;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public abstract class Asset {
    private String assetCode;
    private String name;
    private double purchasePrice;

    public Asset() {
    }

    public Asset(String assetCode, String name, double purchasePrice) {
        this.assetCode = assetCode;
        this.name = name;
        this.purchasePrice = purchasePrice;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public abstract double getMarketValue();

    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã tài sản: ");
        this.assetCode = scanner.nextLine().trim();

        System.out.print("Nhập tên tài sản: ");
        this.name = scanner.nextLine().trim();

        while (true) {
            try {
                System.out.print("Nhập giá mua gốc: ");
                this.purchasePrice = Double.parseDouble(scanner.nextLine());
                if (this.purchasePrice > 0) {
                    break;
                } else {
                    System.out.println("Giá mua gốc phải lớn hơn 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Giá mua phải là một số thực!");
            }
        }
    }

    // Hàm hiển thị dữ liệu chung
    public void displayData() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi","VN"));
        System.out.println("Mã TS: "+this.assetCode+", Tên TS: "+this.name+", Giá gốc: "+ nf.format(this.purchasePrice));
    }
}
