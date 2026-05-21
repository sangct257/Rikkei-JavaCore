package bai6.business;

import bai6.entity.Contact;

import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contactList = new ArrayList<>();

    // Chức năng 1: Thêm liên lạc (Sử dụng hàm contains để check trùng)
    public void addContact(String name, String phoneNumber) {
        Contact dummyContact = new Contact(phoneNumber); // Tạo đối tượng giả để check trùng số điện thoại

        if (contactList.contains(dummyContact)) {
            System.out.println("Lỗi: Số điện thoại đã tồn tại!");
            return;
        }

        Contact newContact = new Contact(name, phoneNumber);
        contactList.add(newContact);
        System.out.println("Thêm liên lạc thành công.");
    }

    // Chức năng 2: Xóa liên lạc theo số điện thoại
    public void deleteByPhone(String phoneNumber) {
        Contact dummyContact = new Contact(phoneNumber);

        // contains() check nếu có tồn tại thì mới tiến hành tìm kiếm chỉ số để xóa
        if (contactList.contains(dummyContact)) {
            int index = contactList.indexOf(dummyContact);
            contactList.remove(index);
            System.out.println("Xóa liên lạc thành công.");
        } else {
            System.out.println("Không tìm thấy liên lạc có số điện thoại này.");
        }
    }

    // Chức năng 3: Tìm kiếm liên lạc (Sử dụng contains theo yêu cầu)
    public void searchByPhone(String phoneNumber) {
        Contact dummyContact = new Contact(phoneNumber);

        if (contactList.contains(dummyContact)) {
            int index = contactList.indexOf(dummyContact);
            System.out.println("Có tồn tại liên lạc!");
            System.out.println("-> Thông tin tìm thấy: " + contactList.get(index));
        } else {
            System.out.println("Không tồn tại liên lạc với số điện thoại này.");
        }
    }

    // Chức năng 4: In danh sách liên lạc
    public void displayAll() {
        if (contactList.isEmpty()) {
            System.out.println("Danh bạ hiện tại đang trống.");
            return;
        }
        System.out.println("--- DANH SÁCH LIÊN LẠC ---");
        for (Contact c : contactList) {
            System.out.println(c);
        }
    }
}
