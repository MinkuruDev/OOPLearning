package SV24.NguyenTrungVinh.BTH5;

import java.util.Scanner;

public class Bai1 {
    private static Integer[] arr;
    private static int count;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao so phan tu cua mang: ");
        count = scanner.nextInt();
        arr = new Integer[count];
        for(int i = 0; i<count; i++){
            System.out.print("Nhap vao gia tri cua phan tu thu " + i + ": ");
            arr[i] = scanner.nextInt();
        }

        printArr();
        timKiem(5);
        xoa(2);
        xoa(9);

        scanner.close();
    }

    public static void printArr(){
        dem();
        System.out.println("cac phan tu trong mang: ");
        for(int i = 0; i<count; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int dem(){
        System.out.println("So luong phan tu trong mang: " + count);
        return count;
    }

    public static int timKiem(int x){
        System.out.println("tim kiem gia tri " + x);

        for(int i = 0; i<count; i++){
            if(arr[i] == x){
                System.out.println("tim thay tai vi tri " + i);
                return i;
            }
        }
        
        System.out.println("Khong tim thay gia tri " + x);
        return -1;
    }

    public static boolean xoa(int x){
        System.out.println("Xoa gia tri " + x);
        int index = timKiem(x);
        if(index < 0){
            System.out.println("Khong the xoa gia tri " + x);
            return false;
        } 
        
        count--;
        arr[index] = arr[count];
        System.out.println("Da xoa gia tri " + x);
        printArr();
        return true;
    }
}
