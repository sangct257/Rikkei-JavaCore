package bai6.entity;

import java.util.Objects;

public class Contact {
    private static int nextId = 1; // Cơ chế tự tăng ID
    private int id;
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.id = nextId++;
        this.name = name;
        this.phoneNumber = phoneNumber.trim();
    }

    // Constructor phụ hỗ trợ việc tạo đối tượng nhanh để so sánh bằng hàm .contains()
    public Contact(String phoneNumber) {
        this.phoneNumber = phoneNumber.trim();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // GHI ĐÈ EQUALS: Hai liên lạc được coi là trùng nhau ĐIỀU KIỆN là có số điện thoại giống nhau
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(phoneNumber, contact.phoneNumber);
    }

    // GHI ĐÈ HASHCODE: Đồng bộ đi kèm với hàm equals()
    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    @Override
    public String toString() {
        return "Mã: " + id + " | Tên: " + name + " | Số ĐT: " + phoneNumber;
    }
}
