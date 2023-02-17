package BTH2;

import java.util.Scanner;

public class Cau1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap 2 so: ");

        double a = sc.nextDouble(),
               b = sc.nextDouble();

        System.out.printf("%f + %f = %f\n", a, b, a+b);
        System.out.printf("%f - %f = %f\n", a, b, a-b);
        System.out.printf("%f * %f = %f\n", a, b, a*b);
        if(b == 0){
            System.out.println("Khong the chia cho 0");
        }else{
            System.out.printf("%f / %f = %f\n", a, b, a/b);
        }

        sc.close();
    }
}
