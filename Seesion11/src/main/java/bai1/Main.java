package bai1;

import bai1.model.Circle;
import bai1.model.Drawable;
import bai1.model.Rectangle;
import bai1.model.Shape;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Rectangle("Cổng trường",5.0,3.0);
        shapes[1] = new Circle("Bánh xe",2.5);

        for (Shape s : shapes){
            s.displayInfo();
            System.out.println("Diện tích: "+ s.getArea());
            System.out.println("Chu vi: "+ s.getPerimeter());

            if (s instanceof Drawable){
                ((Drawable) s).draw();
            }

            System.out.println("----------------------------");

            System.out.println("Bảng mã hiện tại: " + System.getProperty("file.encoding"));
        }

    }
}
