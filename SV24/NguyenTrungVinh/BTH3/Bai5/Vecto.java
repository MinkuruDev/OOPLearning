package SV24.NguyenTrungVinh.BTH3.Bai5;

import java.util.Scanner;

public class Vecto {
    private double[] value;

    public Vecto(int n){
        value = new double[n];
    }

    public Vecto(double[] value){
        this.value = value;
    }

    /**
     * Deep copy vector {@code other}
     * @param other
     */
    public Vecto(Vecto other){
        int length = other.value.length;
        value = new double[length];
        for(int i = 0; i<length; i++){
            value[i] = other.value[i];
        }
    }

    public void setValue(int index, double val){
        value[index] = val;
    }

    public double[] getValue() {
        return value;
    }

    public double getValue(int index){
        return value[index];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Vector[ ");
        for(double val : value){
            builder.append(val);
            builder.append(" ");
        }
        builder.append("]");
        return builder.toString();
    }

    public void print(){
        System.out.println(this);
    }

    public Vecto cong(Vecto other){
        int length = this.getValue().length;
        Vecto res = new Vecto(length);
        for(int i = 0; i<length; i++){
            res.value[i] = this.getValue(i) + other.getValue(i);
        }
        return res;
    }

    public Vecto hieu(Vecto other){
        return this.cong(other.tich(-1));
    }

    public double tichVoHuong(Vecto other){
        double res = 0.0;
        int length = this.getValue().length;
        for(int i = 0; i<length; i++){
            res += this.getValue(i) * other.getValue(i);
        }
        return res;
    }

    public double dodai(){
        return Math.sqrt(this.tichVoHuong(this));
    }

    public Vecto tich(double times){
        int length = this.getValue().length;
        Vecto res = new Vecto(length);
        for(int i = 0; i<length; i++){
            res.value[i] = this.getValue(i) * times;
        }
        return res;
    }

    public Vecto chuanHoa(){
        value = this.tich(1 / this.dodai()).getValue();
        return this;
    }

    /**
     * <p> Kiểm tra vector {@code this} có giá trị gần bằng vector {@code other} hay không với sai số 10^-8 </p>
     * <p> So sánh gần bằng là cần thiêt bởi {@code 0.1f + 0.2f = 0.3}; {@code 0.1d + 0.2d = 0.30000000000000004} </p>
     * @param other
     * @return
     */
    public boolean equals(Vecto other) {
        int length = other.getValue().length;
        if(value.length != length) return false;
        double epsilon = 1e-8;
        for(int i = 0; i<length; i++){
            if(Math.abs(this.getValue(i) - other.getValue(i)) > epsilon)
                return false;
        }

        return true;
    }

    public boolean congTuyen(Vecto other){
        return (new Vecto(this)).chuanHoa()
                .equals((new Vecto(other)).chuanHoa());
    }

    public boolean vuongGoc(Vecto other){
        return Math.abs(this.tichVoHuong(other)) < 1e-8;
    }

    public static Vecto nhap(Scanner scanner, String msg){
        System.out.println(msg);
        System.out.print("Nhap vao so chieu cua vector: ");
        int n = scanner.nextInt();

        Vecto res = new Vecto(n);
        for(int i = 0; i<n; i++){
            System.out.print("Nhap vao phan tu thu " + (i+1) + " cua vector: ");
            res.value[i] = scanner.nextDouble();
        }

        return res;
    }
}
