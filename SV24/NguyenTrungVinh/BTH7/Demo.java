package SV24.NguyenTrungVinh.BTH7;

public class Demo {
    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point(4, 7);

        System.out.println("Point 1: " + p1);
        System.out.println("Point 2: " + p2);

        p1.setX(3);
        p1.setY(5);

        Hinh hinh = new Hinh(p1);
        System.out.println("Hinh: " + hinh);

        HinhTron hinhTron = new HinhTron(p2, 2.5);
        System.out.println("Hinh tron: " + hinhTron);

        HinhChuNhat chuNhat = new HinhChuNhat(3, 4, 4, 5);
        System.out.println("Hinh chu nhat: " + chuNhat);
    }
}
