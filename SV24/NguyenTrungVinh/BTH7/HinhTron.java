package SV24.NguyenTrungVinh.BTH7;

public class HinhTron extends Hinh {
    public static final double PI = 3.14;
    private double radius;

    public HinhTron(){
        radius = 0;
    }

    public HinhTron(int x, int y, double radius){
        super(x, y);
        setRadius(radius);
    }

    public HinhTron(Point root, double radius){
        super(root);
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        setPerimeter(radius * 2 * PI);
        setArea(radius * radius * PI);
    }

    @Override
    public String toString() {
        return String.format("HinhTron{root=%s, radius=%f, perimeter=%f, area=%f}", 
            getRoot().toString(), radius, getPerimeter(), getArea());
    }

}
