package BTH1;

public class Cau3 {
    public static void main(String[] args) {
        int a = 0;
        String result = "khong phai thu trong tuan";
        switch(a){
            case 2:
                result = "thu hai";
                break;
            case 3:
                result = "thu ba";
                break;
            case 4:
                result = "thu tu";
                break;
            case 5:
                result = "thu nam";
                break;
            case 6:
                result = "thu sau";
                break;
            case 7:
                result = "thu bay";
                break;
            case 8:
                result = "chu nhat";
                break;
        }

        System.out.println(result);
    }
}
