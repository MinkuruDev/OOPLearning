package SV24.NguyenTrungVinh.B15D52.BTH1;

import java.util.Scanner;

public class TestPoint {
    private static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Point point1 = new Point(6, 94, 20);
        System.out.println("Point1: " + point1);
        point1 = nhapPoint();
        System.out.println("Point1: " + point1);

        Point point2 = new Point(point1);
        System.out.println("Point2: " + point2);

        Point point3 = new Point();
        point3.setX(-6);
        point3.setY(1);
        point3.setZ(20);
        System.out.printf("Point3.x=%f, Point3.y=%f, Point3.z=%f\n",
                          point3.getX(), point3.getY(), point3.getZ());

        scanner.close();
    }

    public static Point nhapPoint(){
        System.out.print("Nhap x, y, z cho Point: ");
        double x = scanner.nextDouble(),
               y = scanner.nextDouble(),
               z = scanner.nextDouble();
        return new Point(x, y, z);
        
    }
}
