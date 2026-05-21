package bai1.business;

import bai1.entity.Person;

import java.util.LinkedList;
import java.util.Scanner;

public class PersonBusiness {
    private static LinkedList<Person> personLinkedList = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static String inputNonEmpty(String prompt){
        String input;
        while (true) {
            System.out.println(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()){
                return input;
            } else {
                System.err.println("Vui lòng không để trống!");
            }
        }
    }

    public static void addPerson(){
        String name = inputNonEmpty("Nhập tên người dùng: ");
        String email = inputNonEmpty("Nhập email người dùng: ");
        if (email.matches("^[\\\\w.-]+@[\\\\w.-]+\\\\.\\\\w{2,}$")){
            return;
        } else {
            System.err.println("Email không đúng định dạng!");
        }

        String phone = inputNonEmpty("Nhập số điện thoại: ");
        if (phone.matches("^-?\\d+$")){
            if (phone.startsWith("0") && phone.length() == 10){
                return;
            }
        } else {
            System.err.println("Số điện thoại không đúng định dạng ");
        }

        Person person = new Person();
        personLinkedList.add(person);

        System.out.println("Thêm thành công người dùng");
    }

    public static void deletePersonByEmail(){
        System.out.println("Mời nhập email để xoá: ");
        String emailToDelete = scanner.nextLine().trim();
        boolean found = false;
        for (int i = 0; i < personLinkedList.size(); i++) {
            if (personLinkedList.get(i).getEmail().equalsIgnoreCase(emailToDelete)){
                personLinkedList.remove();
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("Không tìm thấy email người dùng này");
        } else {
            System.out.println("Xoá thành công");
        }
    }

    public static void showDisplay(){
        System.out.println("Danh sách người dùng: ");
        if (personLinkedList.isEmpty()){
            System.out.println("Chưa có người dùng nào.");
            return;
        }
        for (Person person : personLinkedList){
            System.out.println(person);
        }
    }
}
