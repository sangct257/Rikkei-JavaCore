package bai4;

import bai4.model.Car;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();

        car.accelerate();//10
        car.printStatus();

        car.accelerate(20);//30
        car.printStatus();

        car.accelerate(15,5);//50
        car.printStatus();
    }
}
