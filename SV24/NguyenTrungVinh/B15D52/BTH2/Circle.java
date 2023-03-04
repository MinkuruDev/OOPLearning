package SV24.NguyenTrungVinh.B15D52.BTH2;

public class Circle {
    private double radius;
    private String color;

    public Circle(){
        radius = 1;
        color = "red";
    }

    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public double getRadius() {
        return radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getCircumference(){
        return radius * 2d * Math.PI;
    }

    public double getArea(){
        return radius * radius * Math.PI;
    }

    public String toString(){
        return String.format("Circle[radius=%f, circumference=%f, area=%f, color: %s]",
                            radius, getCircumference(), getArea(), color);
    }
}
