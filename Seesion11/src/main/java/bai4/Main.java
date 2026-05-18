package bai4;

import bai4.model.*;

public class Main {
    public static void main(String[] args) {
        Device[] devices = new Device[3];
        devices[0] = new Laptop(1,"Laplop Dell");
        devices[1] = new SmartPhone(2,"Iphone XS Max");
        devices[2] = new Television(3,"Tivi Samsung");

        for (Device device : devices){
            device.turnOn();

            // kiểm tra hỗ trợ kết nối wifi
            if (device instanceof Connectable){
                ((Connectable) device).connectWifi();
            }

            // kiểm tra hỗ trợ sạc
            if (device instanceof Chargeable){
                ((Chargeable) device).charge();
            }

            device.turnOff();
            System.out.println("---------------------------");
        }
    }
}
