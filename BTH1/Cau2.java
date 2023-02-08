package BTH1;

public class Cau2 {
    public static void main(String[] args) {
        int a = -69;
        String result = "";

        if(a < 0)
            result = "am";
        else if (a > 0)
            result = "duong";
        else 
            result = "khong";

        System.out.printf("%d la so %s", a, result);
    }
}
