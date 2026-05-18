package bai4.model;

public class Laptop extends Device implements Connectable,Chargeable{

    public Laptop(int id, String name) {
        super(id, name);
    }

    @Override
    public void charge() {
        System.out.println(name + " đang sạc");
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " đã kết nối wifi");
    }

    @Override
    public void turnOn() {
        System.out.println(name + " đang khởi động");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " đang tắt");
    }
}
