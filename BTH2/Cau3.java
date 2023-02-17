package BTH2;

import java.util.Scanner;

public class Cau3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // final double PI = Math.PI;
        final double PI = 3.14d;

        System.out.print("Nhap vao 3 canh cua 1 tam giac: ");
        int a = sc.nextInt(),
            b = sc.nextInt(),
            c = sc.nextInt();
        calcTriangle(a, b, c);

        System.out.print("Nhap vao ban kinh r cua hinh tron: ");
        double r = sc.nextDouble();
        System.out.println("Chu vi hinh tron la: " + (2*r*PI));
        System.out.println("Dien tich hinh tron la: " + (r*r*PI));

        System.out.print("Nhap vao n de tim n so fibonacci dau tien: ");
        a = sc.nextInt();
        b = 0;
        for(int f : firstNthFibonacci(a)){
            System.out.printf("fibonacci[%d] = %d\n", b, f);
            b++;
        }

        System.out.print("Nhap vao so luong phan tu cua mang: ");
        a = sc.nextInt();
        int[] arr = new int[a];
        System.out.print("Nhap vao cac phan tu cua mang: ");
        for(int i = 0; i<a; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Nhap vao target: ");
        b = sc.nextInt();
        twoNumbers(arr, b);

        sc.close();
    }

    private static void twoNumbers(int[] arr, int target){
        int l = arr.length;
        for(int i = 0; i<l; i++){
            for(int j = i+1; j<l; j++){
                if(arr[i] + arr[j] == target){
                    System.out.printf("chi so cua 2 phan tu co tong la %d la %d, %d\n", target, i, j);
                    return;
                }
            }
        }

        System.out.println("Khong co dap an hop le");
    }

    private static int[] firstNthFibonacci(int n){
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;

        for(int i = 2; i<=n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib;
    }

    private static void calcTriangle(int a, int b, int c){
        if(! isTriangle(a, b, c)){
            System.out.printf("%d,%d,%d khong phai la ba canh cua tam giac\n", a,b,c);
            return;
        }

        System.out.println("Chu vi tam giac da nhap: " + (a+b+c));
        double p = (double)(a+b+c)/2;
        System.out.println("Dien tich tam giac da nhap: " + Math.sqrt(p*(p-a)*(p-b)*(p-c)));
    }

    private static boolean isTriangle(int a, int b, int c){
        if(a+b<=c) return false;
        if(b+c<=a) return false;
        if(c+a<=b) return false;

        return true;
    }
}
