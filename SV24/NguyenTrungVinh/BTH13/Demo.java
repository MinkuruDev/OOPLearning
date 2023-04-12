package SV24.NguyenTrungVinh.BTH13;

public class Demo {
    public static void main(String[] args) {
        PhanSo phanSo1, phanSo2;
        try {
            phanSo1 = new PhanSo(3, 5);
            phanSo2 = PhanSo.input("fract.txt");
            // phanSo2 = new PhanSo(2, 7);
        } catch (Exception e) {
            System.out.println("Khong the khoi tao phan so do: " + e.getMessage());
            return;
        }
        
        System.out.println("Phan so 1: " + phanSo1);
        System.out.println("Phan so 2: " + phanSo2);

        System.out.println("phanSo1 + phanSo2 = " + phanSo1.add(phanSo2));
        System.out.println("phanSo1 - phanSo2 = " + phanSo1.sub(phanSo2));
        System.out.println("phanSo1 * phanSo2 = " + phanSo1.multiple(phanSo2));
        try{
            System.out.println("phanSo1 / phanSo2 = " + phanSo1.divide(phanSo2));
        }catch(ArithmeticException ae){
            System.out.println(ae.getMessage());
        }
    }
}
