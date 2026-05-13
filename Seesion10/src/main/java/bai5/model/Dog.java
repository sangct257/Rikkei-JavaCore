package bai5.model;

public class Dog extends Mammal{

    public Dog(String name, int age) {
        super(name, age, true);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof Woof!");
    }

    public void fetchBall(){
        System.out.println(name + " is fetching the ball.");
    }
}
