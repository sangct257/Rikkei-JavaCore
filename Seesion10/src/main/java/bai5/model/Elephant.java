package bai5.model;

public class Elephant extends Mammal{

    public Elephant(String name, int age) {
        super(name, age, false);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Pawooooo!");
    }

    public void sprayWater() {
        System.out.println(name + " is spraying water!");
    }

}
