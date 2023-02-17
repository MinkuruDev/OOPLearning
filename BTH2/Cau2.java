package BTH2;

import java.util.Scanner;

public class Cau2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap 2 so: ");
        int a = sc.nextInt(),
            b = sc.nextInt();

        System.out.printf("Uoc chung lon nhat cua %d va %d la %d\n", a, b, GCD(a, b));
        System.out.printf("Boi chung nho nhat cua %d va %d la %d\n", a, b, LCM(a, b));

        sc.close();
    }

    /**
     * 
     * @param a
     * @param b
     * @return uoc chung lon nhat cua 2 so a va b
     */
    public static int GCD(int a, int b){
        if(b == 0) return Math.abs(a);
        return GCD(b, a%b);
    }

    /**
     * 
     * @param a
     * @param b
     * @return boi chung nho nhat cua 2 so a va b
     */
    public static int LCM(int a, int b){
        return (a * b) / GCD(a, b);
    }
}
