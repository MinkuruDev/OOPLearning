package SV24.NguyenTrungVinh.B15D52.BTH1;

public class Complex {
    private double real, imag;

    public Complex(){
        real = 0;
        imag = 0;
    }

    public Complex(double real){
        this.real = real;
        imag = 0;
    }

    public Complex(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    public Complex(Complex c){
        real = c.real;
        imag = c.imag;
    }

    public double getImag() {
        return imag;
    }

    public double getReal() {
        return real;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public String toString(){
        if(imag == 0) return real + "";
        if(real == 0) return imag + "i";
        if(imag > 0) return real + "+" + imag + "i";
        return real + "" + imag + "i";
    }

    public static Complex add(Complex c1, Complex c2){
        return new Complex(c1.real + c2.real, c1.imag + c2.imag);
    }

    public static Complex sub(Complex c1, Complex c2){
        return new Complex(c1.real - c2.real, c1.imag - c2.imag);
    }

    public static Complex multiple(Complex c1, Complex c2){
        double real = c1.real * c2.real - c1.imag * c2.imag;
        double imag = c1.real * c2.imag + c1.imag * c2.real;
        return new Complex(real, imag);
    }

    public static Complex divide(Complex c1, Complex c2){
        double denominator = c2.real * c2.real + c2.imag * c2.imag;
        double real = (c1.real * c2.real + c1.imag * c2.imag) / denominator;
        double imag = (c1.imag * c2.real - c1.real * c2.imag) / denominator;
        return new Complex(real, imag);
    }
}
