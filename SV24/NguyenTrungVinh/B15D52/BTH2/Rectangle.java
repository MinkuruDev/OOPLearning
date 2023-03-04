package SV24.NguyenTrungVinh.B15D52.BTH2;

public class Rectangle {
    private float length, width;

    public Rectangle(){
        length = 1f;
        width = 1f;
    }

    public Rectangle(float length, float width){
        this.length = length;
        this.width = width;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    public String toString(){
        return String.format("Rectamgle[length=%f, width=%f]", length, width);
    }

    public double getArea(){
        return 1d * length * width;
    }

    public double getPerimeter(){
        return 2d * (length + width);
    }
}
