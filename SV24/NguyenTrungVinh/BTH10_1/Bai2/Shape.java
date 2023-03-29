package SV24.NguyenTrungVinh.BTH10_1.Bai2;

public abstract class Shape {
    private String color;
    private boolean filled;

    public Shape(){
        color = "white";
        filled = true;
    }

    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return String.format("Shape{color: %s, filled: %b}", color, filled);
    }
}
