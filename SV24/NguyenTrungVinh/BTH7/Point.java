package SV24.NguyenTrungVinh.BTH7;

public class Point {
    private int x,y;

    public Point(){
        x = 0;
        y = 0;
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("Point{x=%d, y=%d}", x, y);
    }
}
