package SV24.NguyenTrungVinh.BTH13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhanSo {
    private int tu;
    private int mau;

    public PhanSo(int tu, int mau) throws ArithmeticException {
        this.tu = tu;
        if(mau == 0)
            throw new ArithmeticException("Mau so cua 1 phan so khong duoc phep bang 0");
        this.mau = mau;
        this.toiGian();
    }

    public PhanSo() {
        this.tu = 0;
        this.mau = 1;
    }

    public PhanSo(int tu) {
        this.tu = tu;
        this.mau = 1;
    }

    public static PhanSo input(String fileName) throws FileNotFoundException, Exception{
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        int tu = Integer.parseInt(sc.nextLine());
        int mau = Integer.parseInt(sc.nextLine());
        sc.close();

        return new PhanSo(tu, mau);
    }

    public PhanSo add(PhanSo other) {
        int newTu = this.tu * other.mau + other.tu * this.mau;
        int newMau = this.mau * other.mau;
        return new PhanSo(newTu, newMau);
    }

    public PhanSo sub(PhanSo other) {
        int newTu = this.tu * other.mau - other.tu * this.mau;
        int newMau = this.mau * other.mau;
        return new PhanSo(newTu, newMau);
    }

    public PhanSo multiple(PhanSo other) {
        int newTu = this.tu * other.tu;
        int newMau = this.mau * other.mau;
        return new PhanSo(newTu, newMau);
    }

    public PhanSo divide(PhanSo other) throws ArithmeticException {
        if(other.tu == 0) 
            throw new ArithmeticException("Khong the chia mot phan so cho 0");
        int newTu = this.tu * other.mau;
        int newMau = this.mau * other.tu;
        return new PhanSo(newTu, newMau);
    }

    public PhanSo toiGian() {
        if(mau < 0){
            tu *= -1;
            mau *= -1; 
        }
        int gcd = gcd(tu, mau);
        tu /= gcd;
        mau /= gcd;
        return this;
    }
    
    public int gcd(int a, int b) {
        if (b == 0)
            return Math.abs(a);
        return gcd(b, a % b);
    }

    @Override
    public String toString() {
        this.toiGian();
        return tu + "/" + mau;
    }
}