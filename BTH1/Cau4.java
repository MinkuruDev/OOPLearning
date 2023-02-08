package BTH1;

public class Cau4 {
    public static void main(String[] args) {
        int n = 69;
        if(isPrime(n)){
            System.out.println(n + " la so nguyen to");
        }else{
            System.out.println(n + " khong phai la so nguyen to");
        }

        for(int prime : primeFrom2To(n)){
            System.out.print(prime + "\t");
        }
    }

    /**
     * kiem tra 1 so co phai la so nguen to
     * @param x - so can kiem tra
     * @return - true neu x la so nguyen to
     */
    private static boolean isPrime(int x){
        if(x < 2) return false;
        if(x == 2) return true;

        for(int i = 2; i*i<=x; i++){
            if(x % i == 0) return false;
        }

        return true;
    }

    /**
     * kiem tra nhung so nguen to tu 2 den x
     * @param x 
     * @return - nhung so nguen to tu 2 den x
     */
    private static int[] primeFrom2To(int x){
        boolean[] prime = new boolean[x+1];
        for(int i = 2; i<=x; i++){
            prime[i] = true;
        }

        for(int i = 2; i*i <= x; i++){
            if(! prime[i]) continue;
            for(int j = i * 2; j<=x; j+=i){
                prime[j] = false;
            }
        }

        int count = 0;
        for(int i = 2; i<=x; i++){
            if(prime[i])
                count++;
        }

        int[] result = new int[count];
        count = 0;
        for(int i = 2; i<=x; i++){
            if(prime[i]){
                result[count] = i;
                count++;
            }
        }

        return result;
    }
}
