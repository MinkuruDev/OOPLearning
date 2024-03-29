package SV24.NguyenTrungVinh.BTH10_1.Bai2;

public class Circle extends Shape{
    private double radius;

    public Circle(){
        radius = 0;
    }

    public Circle(double radius){
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return radius * 2 * Math.PI;
    }
    
    @Override
    public String toString() {
        return String.format("Circle{color: %s, filled: %b, radius: %f}",
                                getColor(), isFilled(), radius);
    }
}
