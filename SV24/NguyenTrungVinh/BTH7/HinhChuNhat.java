package SV24.NguyenTrungVinh.BTH7;

public class HinhChuNhat extends Hinh {
    private double width, height;

    public HinhChuNhat(){
        width = 0;
        height = 0;
    }

    public HinhChuNhat(int x, int y, double width, double height){
        super(x, y);
        setSize(width, height);
    }

    public void setSize(double width, double height){
        this.width = width;
        this.height = height;
        setPerimeter((width + height) * 2);
        setArea(width * height);
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
        setPerimeter((width + height) * 2);
        setArea(width * height);
    }

    public void setHeight(double height) {
        this.height = height;
        setPerimeter((width + height) * 2);
        setArea(width * height);
    }

    @Override
    public String toString() {
        return String.format("HinhChuNhat{root=%s, width=%f, height=%f, perimeter=%f, area=%f}", 
            getRoot().toString(), width, height, getPerimeter(), getArea());
    }
}
