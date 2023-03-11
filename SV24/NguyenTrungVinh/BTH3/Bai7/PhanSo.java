package SV24.NguyenTrungVinh.BTH3.Bai7;

import java.util.Scanner;

public class PhanSo {
    private int tuSo, mauSo;

    public PhanSo(){
        tuSo = 0;
        mauSo = 1;
    }

    public PhanSo(int ts, int ms){
        tuSo = ts;
        mauSo = ms;
    }

    @Override
    public String toString() {
        toiGian();
        if(mauSo == 1) return tuSo + "";
        return tuSo + "/" + mauSo;
    }

    public static int gcd(int a, int b){
        if(b == 0) return Math.abs(a);
        return gcd(b, a%b);
    }

    public PhanSo toiGian(){
        if(tuSo == 0 || mauSo == 0){
            mauSo = 1;
            return this;
        }

        if(mauSo < 0)
            this.nhan(-1);

        int gcd = gcd(tuSo, mauSo);
        tuSo /= gcd;
        mauSo /= gcd;

        return this;
    }

    public static void quyDong(PhanSo p1, PhanSo p2){
        p1.toiGian(); p2.toiGian();
        if(p1.mauSo == p2.mauSo) return;
        int temp = p1.mauSo;
        p1.nhan(p2.mauSo);
        p2.nhan(temp);
    }

    public PhanSo nhan(int times){
        tuSo *= times;
        mauSo *= times;
        return this;
    }

    public PhanSo cong(PhanSo other){
        quyDong(this, other);

        return new PhanSo(tuSo + other.tuSo, mauSo).toiGian();
    }

    public PhanSo tru(PhanSo other){
        quyDong(this, other);

        return new PhanSo(tuSo - other.tuSo, mauSo).toiGian();
    }

    public PhanSo nhan(PhanSo other){
        return new PhanSo(tuSo * other.tuSo, mauSo * other.mauSo).toiGian();
    }

    public PhanSo chia(PhanSo other){
        return new PhanSo(tuSo * other.mauSo, mauSo * other.tuSo).toiGian();
    }

    public PhanSo nghichDao(){
        int temp = tuSo;
        tuSo = mauSo;
        mauSo = temp;
        return this.toiGian();
    }

    public PhanSo doiDau(){
        tuSo = - tuSo;
        return this.toiGian();
    }

    public boolean soSanhBang(PhanSo other){
        this.toiGian();
        other.toiGian();
        return tuSo == other.tuSo && mauSo == other.mauSo;
    }

    public boolean nhoHon(PhanSo other){
        quyDong(this, other);
        return tuSo < other.tuSo;
    }

    public boolean lonHon(PhanSo other){
        return (! this.nhoHon(other)) && (! this.soSanhBang(other));
    }

    public void print(){
        System.out.println(this);
    }

    public static PhanSo nhap(Scanner sc, String msg){
        System.out.println(msg);
        System.out.print("Nhap phan so co dang a/b: ");
        String[] str = sc.next().split("/");
        int tuSo = Integer.parseInt(str[0]);
        int mauSo = Integer.parseInt(str[1]);
        return new PhanSo(tuSo, mauSo);
    }

}
