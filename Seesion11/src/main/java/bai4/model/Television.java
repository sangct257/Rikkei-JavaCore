package bai4.model;

public class Television extends Device implements Connectable{

    public Television(int id, String name) {
        super(id, name);
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " đã kết nối wifi");
    }

    @Override
    public void turnOn() {
        System.out.println(name + " đang mở màn hình");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " đang tắt");
    }
}
