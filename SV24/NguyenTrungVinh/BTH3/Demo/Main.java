package SV24.NguyenTrungVinh.BTH3.Demo;

import java.util.Scanner;

import SV24.NguyenTrungVinh.BTH3.Bai123.GradeBook;
import SV24.NguyenTrungVinh.BTH3.Bai4.Employee;
import SV24.NguyenTrungVinh.BTH3.Bai5.Vecto;
import SV24.NguyenTrungVinh.BTH3.Bai6.SoPhuc;
import SV24.NguyenTrungVinh.BTH3.Bai7.PhanSo;

public class Main {
    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        testGradeBook();
        testEmployee();
        testVector();
        testSoPhuc();
        testPhanSo();
        sc.close();
    }

    public static void testGradeBook(){
        System.out.println("\n---Test Grade Book---");
        System.out.print("Nhap ten khoa hoc: ");
        String courseName = sc.nextLine();
        GradeBook gradeBook = new GradeBook(courseName);
        gradeBook.displayMessage();
    }

    public static void testEmployee(){
        System.out.println("\n---Test Employee---");
        Employee employee1 = Employee.nhap(sc, "Nhap nhan vien 1: ");
        Employee employee2 = new Employee("Nguyen", "Van A", -100);

        System.out.println("Employee1: " + employee1);
        System.out.println("Employee2: " + employee2);
        employee2.setLuongThang(5);
        System.out.println("Employee2 sau khi dat lai luong thang: " + employee2);
        employee1.tangLuong(15);
        System.out.println("Employee1 sau khi tang luong 15%: " + employee1);
    }

    public static void testVector(){
        System.out.println("\n---Test Vecto---");
        Vecto vector1 = Vecto.nhap(sc, "Nhap Vector 1:");
        Vecto vector2 = Vecto.nhap(sc, "Nhap Vector 2:");

        System.out.println("Vecto 1: " + vector1);
        System.out.println("Vecto 2: " + vector2);

        System.out.println("Vecto1 + Vecto2 = " + vector1.cong(vector2));
        System.out.println("Vecto1 - Vecto2 = " + vector1.hieu(vector2));
        System.out.println("Vecto1 . Vecto2 = " + vector1.tichVoHuong(vector2));

        System.out.println("Vecto1 cong tuyen Vecto2 = " + vector1.congTuyen(vector2));
        System.out.println("Vecto1 vuong goc Vecto2 = " + vector1.vuongGoc(vector2));

        System.out.println("Vecto1 * 2.5 = " + vector1.tich(2.5));
        System.out.println("Do dai Vecto2 = " + vector2.dodai());
        System.out.println("Vecto1 chuan hoa = " + vector1.chuanHoa());
    }

    public static void testSoPhuc(){
        System.out.println("\n---Test So Phuc---");
        SoPhuc soPhuc1 = SoPhuc.nhap(sc, "Nhap so phuc 1: ");
        SoPhuc soPhuc2 = SoPhuc.nhap(sc, "Nhap so phuc 2: ");

        System.out.println("So phuc c1: " + soPhuc1);
        System.out.println("So phuc c2: " + soPhuc2);

        System.out.println("c1 + c2 = " + soPhuc1.cong(soPhuc2));
        System.out.println("c1 - c2 = " + soPhuc1.hieu(soPhuc2));
        System.out.println("c1 * c2 = " + soPhuc1.nhan(soPhuc2));
        System.out.println("c1 / c2 = " + soPhuc1.chia(soPhuc2));

        System.out.println("c1 == c2 = " + soPhuc1.soSanhBang(soPhuc2));
        System.out.println("c1 < c2 = " + soPhuc1.nhoHon(soPhuc2));
        System.out.println("c1 > c2 = " + soPhuc1.lonHon(soPhuc2));

        System.out.println("1 / c1 = " + soPhuc1.nghichDao());
    }

    public static void testPhanSo(){
        System.out.println("\n---Test Phan So---");
        PhanSo ps1 = PhanSo.nhap(sc, "Nhap phan so 1: ");
        PhanSo ps2 = PhanSo.nhap(sc, "Nhap phan so 2: ");

        System.out.println("Phan so ps1: " + ps1);
        System.out.println("Phan so ps2: " + ps2);

        System.out.println("ps1 + ps2 = " + ps1.cong(ps2));
        System.out.println("ps1 - ps2 = " + ps1.tru(ps2));
        System.out.println("ps1 * ps2 = " + ps1.nhan(ps2));
        System.out.println("ps1 / ps2 = " + ps1.chia(ps2));

        System.out.println("ps1 == ps2 = " + ps1.soSanhBang(ps2));
        System.out.println("ps1 < ps2 = " + ps1.nhoHon(ps2));
        System.out.println("ps1 > ps2 = " + ps1.lonHon(ps2));

        System.out.println("ps1 Nghich dao: " + ps1.nghichDao());
        System.out.println("ps2 Doi dau: " + ps2.doiDau());
    }
}
