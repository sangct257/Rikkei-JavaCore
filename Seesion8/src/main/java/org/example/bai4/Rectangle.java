package org.example.bai4;

public class Rectangle {
    private Double width;
    private Double height;

    public Rectangle(Double width, Double height) {
        this.width = width;
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }

    // getArea() — trả về width * height
    public Double getArea(){
        return getWidth()*getHeight();
    }

    // getPerimeter() — trả về 2 * (width + height)
    public Double getPerimeter(){
        return 2*(getWidth()+getHeight());
    }

    @Override
    public String toString() {
        return "Rectangle(" +
                "width=" + getWidth() +
                ", height=" + getHeight() +
                ", area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                ')';
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3d,4d);
        Rectangle r2 = new Rectangle(5d,2d);
        Rectangle r3 = new Rectangle(4.5,3.5);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        Double a1 = r1.getArea();
        Double a2 = r2.getArea();
        Double a3 = r3.getArea();

        Double maxArea = a1;
        if (a2 > maxArea) maxArea = a2;
        if (a3 > maxArea) maxArea = a3;

        Integer count = 0;
        if (a3.equals(maxArea)) count++;
        if (a2.equals(maxArea)) count++;
        if (a1.equals(maxArea)) count++;

        System.out.println("Diện tích lớn nhất là: "+maxArea);

        if (count > 1){
            System.out.println("Thông báo: Có " + count + " hình có diện tích lớn nhất bằng nhau.");
        }

        System.out.print("Các hình có diện tích lớn nhất: ");
        if (a1.equals(maxArea)) System.out.print("r1 ");
        if (a2.equals(maxArea)) System.out.print("r2 ");
        if (a3.equals(maxArea)) System.out.print("r3 ");
        System.out.println();
    }
}
