package SV24.NguyenTrungVinh.BTH7;

public class Hinh {
    private Point root;
    private double perimeter, area;

    public Hinh(){
        root = new Point();
        perimeter = 0;
        area = 0;
    }

    public Hinh(int x, int y){
        root = new Point(x, y);
        perimeter = 0;
        area = 0;
    }

    public Hinh(Point root){
        this.root = root;
        perimeter = 0;
        area = 0;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setRoot(Point root) {
        this.root = root;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public Point getRoot() {
        return root;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return String.format("Hinh{root=%s, perimeter=%f, area=%f}",
            root.toString(), perimeter, area);
    }
}
