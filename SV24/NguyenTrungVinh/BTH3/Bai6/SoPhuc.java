package SV24.NguyenTrungVinh.BTH3.Bai6;

import java.util.Scanner;

public class SoPhuc {
    private float phanThuc, phanAo;

    public SoPhuc(){
        phanThuc = 0;
        phanAo = 0;
    }

    public SoPhuc(float pt){
        this.phanThuc = pt;
        phanAo = 0;
    }

    public SoPhuc(float pt, float pa){
        this.phanThuc = pt;
        this.phanAo = pa;
    }

    public SoPhuc(SoPhuc c){
        phanThuc = c.phanThuc;
        phanAo = c.phanAo;
    }

    public float getPhanAo() {
        return phanAo;
    }

    public float getPhanThuc() {
        return phanThuc;
    }

    public void setPhanAo(float imag) {
        this.phanAo = imag;
    }

    public void setPhanThuc(float real) {
        this.phanThuc = real;
    }

    @Override
    public String toString(){
        if(phanAo == 0) return phanThuc + "";
        if(phanThuc == 0) return phanAo + "i";
        if(phanAo > 0) return phanThuc + "+" + phanAo + "i";
        return phanThuc + "" + phanAo + "i";
    }

    public void print(){
        System.out.println(this);
    };

    public SoPhuc cong(SoPhuc other){
        return new SoPhuc(this.phanThuc + other.phanThuc, this.phanAo + other.phanAo);
    }

    public SoPhuc hieu(SoPhuc other){
        return new SoPhuc(this.phanThuc - other.phanThuc, this.phanAo - other.phanAo);
    }

    public SoPhuc nhan(SoPhuc other){
        float real = this.phanThuc * other.phanThuc - this.phanAo * other.phanAo;
        float imag = this.phanThuc * other.phanAo + this.phanAo * other.phanThuc;
        return new SoPhuc(real, imag);
    }

    public SoPhuc chia(SoPhuc other){
        float mauSo = other.phanThuc * other.phanThuc + other.phanAo * other.phanAo;
        float real = (this.phanThuc * other.phanThuc + this.phanAo * other.phanAo) / mauSo;
        float imag = (this.phanAo * other.phanThuc - this.phanThuc * other.phanAo) / mauSo;
        return new SoPhuc(real, imag);
    }

    public SoPhuc nghichDao(){
        return (new SoPhuc(1)).chia(this);
    }

    public boolean soSanhBang(SoPhuc other){
        return this.getPhanThuc() == other.getPhanThuc() &&
               this.getPhanAo() == other.getPhanAo();
    }

    public boolean nhoHon(SoPhuc other){
        float diff = this.getPhanThuc() - other.getPhanThuc();
        if(diff == 0)
            return this.getPhanAo() < other.getPhanAo();
        return diff < 0;
    }

    public boolean lonHon(SoPhuc other){
        return (! this.nhoHon(other)) && (! this.soSanhBang(other));
    }

    public static SoPhuc nhap(Scanner sc, String msg){
        System.out.println(msg);
        System.out.print("Nhap phan thuc: ");
        float real = sc.nextFloat();
        System.out.print("Nhap phan ao: ");
        float imag = sc.nextFloat();

        return new SoPhuc(real, imag);
    }
}
