package SV24.NguyenTrungVinh.BTH14;

import java.util.Stack;

public class Bai1 {
    public static void main(String[] args) {
        long num = 18329843985323L;
        int base = 16;
        try {
            String res = convertNumToBase(num, base);
            System.out.printf("%d in base %d is: %s", num, base, res);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String convertNumToBase(long num, int base) throws Exception{
        if(base < 2 || base > 16)
            throw new Exception("Cannot convert " + num + " to base " + base);
        if(num == 0) return "0";
        Stack<Integer> stack = new Stack<>();
        
        while(num != 0){
            stack.push((int)(num % base));
            num /= base;
        }

        StringBuilder builder = new StringBuilder();

        while(!stack.empty()){
            int val = stack.pop();
            switch(val){
                case 10 -> builder.append('A');
                case 11 -> builder.append('B');
                case 12 -> builder.append('C');
                case 13 -> builder.append('D');
                case 14 -> builder.append('E');
                case 15 -> builder.append('F');
                default -> builder.append(val);
            }
        }
        
        return builder.toString();
    }
}
