package SV24.NguyenTrungVinh.B15D52.BTH1;

public class Point {
    private double x,y,z;

    public Point(){
        x = 0;
        y = 0;
        z = 0;
    }

    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(Point point){
        x = point.x;
        y = point.y;
        z = point.z;
    }

    public String toString(){
        return String.format("Point[x=%f, y=%f, z=%f]", x, y, z);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
