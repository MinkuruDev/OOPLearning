package SV24.NguyenTrungVinh.BTH3.Bai4;

import java.util.Scanner;

public class Employee {
    private String ho, ten;
    private double luongThang;

    public Employee(String ho, String ten, double luongThang){
        this.ho = ho;
        this.ten = ten;
        setLuongThang(luongThang);
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    public void setLuongThang(double luong) {
        if(luong < 0)
            luong = 0;
        luongThang = luong;
    }

    @Override
    public String toString() {
        return String.format("Employee[Ho va Ten: %s %s, luong thang: %f, luong nam: %f]",
                             ho, ten, luongThang, getLuongNam());
    }

    public static Employee nhap(Scanner sc, String msg){
        System.out.println(msg);
        System.out.print("Nhap ho: ");
        String ho = sc.next();
        System.out.print("Nhap ten: ");
        String ten = sc.next();
        System.out.print("Nhap luong thang: ");
        double luong = sc.nextDouble();

        return new Employee(ho, ten, luong);
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public double getLuongThang() {
        return luongThang;
    }

    public double getLuongNam() {
        return luongThang * 12;
    }

    public double tangLuong(double percennt){
        luongThang += luongThang * (percennt / 100);
        return luongThang;
    }
}
