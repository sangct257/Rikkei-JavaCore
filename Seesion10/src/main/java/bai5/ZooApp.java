package bai5;

import bai5.model.Animal;
import bai5.model.Cat;
import bai5.model.Dog;
import bai5.model.Elephant;
import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class ZooApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Dog dog = new Dog("Buddy", 3);
        Cat cat = new Cat("Mimi", 2);
        Elephant elephant = new Elephant("Dumbo", 10);

        int choice;
        do {
            System.out.println("===== ZOO MANAGEMENT MENU =====");
            System.out.println("1. Tạo đối tượng và hiển thị thông tin");
            System.out.println("2. Kiểm tra Overriding: makeSound()");
            System.out.println("3. Kiểm tra Overloading: eat()");
            System.out.println("4. Kiểm tra đa hình runtime (Animal array)");
            System.out.println("5. Gọi phương thức đặc trưng từng loài");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("----- THÔNG TIN CÁC ĐỘNG VẬT -------");
                    dog.showInfo();
                    cat.showInfo();
                    elephant.showInfo();
                    break;
                case 2:
                    System.out.println("------ OVERRIDING: makeSound() ---------");
                    dog.makeSound();
                    cat.makeSound();
                    elephant.makeSound();
                    break;
                case 3:
                    System.out.println("------- OVERRIDING: eat() ---------");
                    dog.eat();
                    dog.eat("meat");
                    cat.eat("fish");
                    elephant.eat();
                    break;
                case 4:
                    System.out.println("------- POLYMORPHISM RUNTIME ---------");
                    // Đa hình Runtime: Mảng kiểu Animal chứa các con vật khác nhau
                    Animal[] zoo = {dog, cat, elephant};
                    for (Animal a : zoo) {
                        a.makeSound();
                    }
                    break;
                case 5:
                    System.out.println("------- PHƯƠNG THỨC RIÊNG CỦA TỪNG LOÀI ---------");
                    dog.fetchBall();
                    cat.climbTree();
                    elephant.sprayWater();
                    break;
                case 0:
                    System.exit(0);
                    System.out.println("Thoát chung trình!");
            }
        } while (choice != 0);
    }
}
