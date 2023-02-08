package BTH1;

public class Cau5 {
    public static void main(String[] args) {
        int n = 3;
        double result = 0;
        for(int i = 1; i<=n; i++){
            result += 1d / (2*i);
        }

        System.out.println(result);
    }
}
