package SV24.NguyenTrungVinh.B15D52.BTH2;

import java.util.Scanner;

public class Demo {
    private static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Circle c1 = new Circle();
        System.out.println("Circle c1: " + c1);
        c1.setRadius(5);
        c1.setColor("#ff00ff");
        System.out.println("Circle c1: " + c1);

        Circle c2 = nhapCircle();
        System.out.println("Circle c2: " + c2);

        Rectangle r1 = new Rectangle();
        System.out.println("Rectangle r1: " + r1);
        r1.setLength(4);
        r1.setWidth(3);
        System.out.println("Rectangle r1: " + r1);

        Rectangle r2 = nhapRectangle();
        System.out.println("Rectangle r2: " + r2);
        System.out.println("Dien tich r2: " + r2.getArea());
        System.out.println("Chu vi r2: " + r2.getPerimeter());
        
        scanner.close();
    }

    public static Circle nhapCircle(){
        System.out.print("Nhap hinh tron:\nNhap ban kinh: ");
        double radius = scanner.nextDouble();
        System.out.print("Nhap mau: ");
        // https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
        scanner.nextLine(); // Consume newline left-over
        String color = scanner.nextLine();
        return new Circle(radius, color);
    }

    public static Rectangle nhapRectangle(){
        System.out.print("Nhap do dai 2 canh cua hinh chu nhat: ");
        float length = scanner.nextFloat(),
              width = scanner.nextFloat();

        return new Rectangle(length, width);
    }
}
