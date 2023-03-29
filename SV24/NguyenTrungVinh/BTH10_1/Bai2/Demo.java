package SV24.NguyenTrungVinh.BTH10_1.Bai2;

public class Demo {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(6, 9, "#00FF00", true);
        Square square = new Square(5, "Blue", false);
        Circle circle = new Circle(2.25, "#181818", false);

        printShape(rectangle);
        printShape(square);
        printShape(circle);
    }

    public static void printShape(Shape shape){
        System.out.println(shape);
        System.out.println("Area: " + shape.getArea());
        System.out.println("Perimeter: " + shape.getPerimeter());
    }
}
