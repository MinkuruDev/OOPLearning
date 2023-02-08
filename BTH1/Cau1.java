package BTH1;

public class Cau1 {
    public static void main(String[] args) {
        int a = 4,
            b = 2,
            c = 3;
        String res = isTriangle(a, b, c) ? "" : " khong phai";

        System.out.printf("%d,%d,%d%s la ba canh cua 1 tam giac\n", a, b, c, res);
    }

    /**
     * Kiem tra 3 so nguyen co phai la 3 canh cua 1 tam giac
     * @param a 
     * @param b 
     * @param c 
     * @return - true neu la tam giac, false neu khong phai
     */
    private static boolean isTriangle(int a, int b, int c){
        if(a+b<=c) return false;
        if(b+c<=a) return false;
        if(c+a<=b) return false;

        return true;
    }
}
