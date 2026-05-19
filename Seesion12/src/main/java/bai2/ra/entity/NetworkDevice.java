package bai2.ra.entity;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class NetworkDevice extends Asset {
    private int numberOfPorts;

    public NetworkDevice() {
    }

    public NetworkDevice(String assetCode, String name, double purchasePrice, int numberOfPorts) {
        super(assetCode, name, purchasePrice);
        this.numberOfPorts = numberOfPorts;
    }

    @Override
    public double getMarketValue() {
        return this.getPurchasePrice() * 0.9;
    }

    @Override
    public void inputData(Scanner scanner) {
        super.inputData(scanner);
        while (true) {
            try {
                System.out.print("Nhập số cổng mạng (Ports): ");
                this.numberOfPorts = Integer.parseInt(scanner.nextLine());
                if (this.numberOfPorts > 0) {
                    break;
                } else {
                    System.out.println("Số lượng cổng mạng phải lớn hơn 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Số cổng phải là số nguyên!");
            }
        }
    }

    @Override
    public void displayData() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi","VN"));
        super.displayData();
        System.out.println("Số Ports: "+this.numberOfPorts+", Giá hiện tại (đã khấu hao 10%): "+ nf.format(this.getMarketValue()));
    }
}
