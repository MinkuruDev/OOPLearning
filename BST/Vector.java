package BST;

public class Vector extends Point{
    public Vector(int x, int y){
        super(x, y);
    }

    public Vector(Point a, Point b){
        super(b.x - a.x, b.y - a.y);
    }

    public double length(){
        return Math.sqrt(x*x + y*y);
    }

    public static double dot(Vector a, Vector b){
        return a.getX()*b.getX() + a.getY()*b.getY();
    }

    public static double Angle(Vector a, Vector b){
        double lenA = a.length();
        double lenB = b.length();
        final double eps = 1e-7;
        if ((Math.abs(lenA) < eps) || (Math.abs(lenA) < eps) )
            return 0.0;
        double AdotB = Vector.dot(a,b);
        double cosAB = AdotB/(lenA*lenB);

        return Math.acos(cosAB);
    }
}
