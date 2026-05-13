package bai6;

import bai6.model.Car;
import bai6.model.Motorcycle;
import bai6.model.Truck;
import bai6.model.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sử dụng ArrayList để có thể thêm phương tiện mới linh hoạt
        ArrayList<Vehicle> listVehicles = new ArrayList<>();

        // Khởi tạo sẵn một vài xe mẫu
        listVehicles.add(new Car("Toyota", 2020, "Gasoline"));
        listVehicles.add(new Motorcycle("Honda", 2018, "Gasoline"));
        listVehicles.add(new Truck("Volvo", 2022, "Diesel"));

        int choice;
        do {
            System.out.println("\n========== VEHICLE MANAGEMENT MENU ==========");
            System.out.println("1. Hiển thị thông tin tất cả phương tiện");
            System.out.println("2. Kiểm tra Overriding: startEngine()");
            System.out.println("3. Kiểm tra Overloading: move()");
            System.out.println("4. Kiểm tra đa hình runtime (Vehicle array)");
            System.out.println("5. Gọi các hành vi đặc trưng theo loại");
            System.out.println("6. Thêm phương tiện mới");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    System.out.println("--- THÔNG TIN PHƯƠNG TIỆN ---");
                    for (Vehicle v : listVehicles) {
                        v.showInfo();
                        System.out.println("----------");
                    }
                    break;
                case 2:
                    System.out.println("------ OVERRIDING: startEngine() ---------");
                    for (Vehicle v : listVehicles) {
                        v.startEngine();
                    }
                    break;
                case 3:
                    System.out.println("------ OVERRIDING: move() ---------");
                    if (!listVehicles.isEmpty()) {
                        listVehicles.get(0).move();
                        listVehicles.get(0).move(80);
                    }
                    break;
                case 4:
                    System.out.println("------- POLYMORPHISM RUNTIME ---------");
                    for (Vehicle v : listVehicles) {
                        v.startEngine();
                    }
                    break;
                case 5:
                    System.out.println("------- HÀNH VI ĐẶC TRƯNG CỦA TỪNG LOÀI ---------");
                    for (Vehicle v : listVehicles) {
                        if (v instanceof Car){
                            ((Car) v).openTrunk();
                        } else if (v instanceof Motorcycle) {
                            ((Motorcycle) v).doWheelie();
                        } else if (v instanceof Truck) {
                            ((Truck) v).loadCargo();
                        }
                    }
                    break;
                case 6:
                    System.out.println("--- THÊM PHƯƠNG TIỆN MỚI ---");
                    System.out.print("Loại (car/motorcycle/truck): ");
                    String type = sc.nextLine().toLowerCase();

                    System.out.print("Brand: ");
                    String brand = sc.nextLine();
                    System.out.print("Year: ");
                    int year = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Fuel Type: ");
                    String fuel = sc.nextLine();

                    if (type.equals("car")) {
                        listVehicles.add(new Car(brand, year, fuel));
                    } else if (type.equals("motorcycle")) {
                        listVehicles.add(new Motorcycle(brand, year, fuel));
                    } else if (type.equals("truck")) {
                        listVehicles.add(new Truck(brand, year, fuel));
                    } else {
                        System.out.println("Loại xe không hợp lệ!");
                    }
                    break;
                case 0:
                    System.exit(0);
                    System.out.println("Thoát chương trình...");
                default:
                    System.out.println("Chọn sai mời chọn lại");
            }
        }while (choice != 0);
    }
}
