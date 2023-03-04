package SV24.NguyenTrungVinh.B15D52.BTH1;

import java.util.Scanner;

public class TestComplex {
    private static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Complex[] complexes = new Complex[3];
        complexes[0] = new Complex(3, 4);
        System.out.println("Complex c0: " + complexes[0]);
        complexes[1] = nhapComplex();
        System.out.println("Complex c1: " + complexes[1]);

        complexes[2] = new Complex(Complex.add(complexes[0], complexes[1]));
        System.out.println("c0 + c1 = " + complexes[2]);
        System.out.println("c0 - c1 = " + Complex.sub(complexes[0], complexes[1]));
        System.out.println("c0 * c1 = " + Complex.multiple(complexes[0], complexes[1]));
        System.out.println("c0 / c1 = " + Complex.divide(complexes[0], complexes[1]));
        scanner.close();
    }

    public static Complex nhapComplex(){
        Complex result = new Complex();
        System.out.print("Nhap so phuc:\nNhap phan thuc: ");
        result.setReal(scanner.nextDouble());
        System.out.print("Nhap phan ao: ");
        result.setImag(scanner.nextDouble());

        return result;
    }
}
