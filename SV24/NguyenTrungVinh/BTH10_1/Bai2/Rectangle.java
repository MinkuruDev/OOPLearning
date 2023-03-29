package SV24.NguyenTrungVinh.BTH10_1.Bai2;

public class Rectangle extends Shape{
    private double width, length;

    public Rectangle(){
        width = 0;
        length = 0;
    }

    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return String.format("Rectangle{color: %s, filled: %b, width: %f, length: %f}",
                                getColor(), isFilled(), width, length);
    }

}
