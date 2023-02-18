package BTH2;

import java.util.Scanner;
import BTH2.Cau4.Stack;

public class Cau5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so he 10: ");
        long num = sc.nextLong();
        System.out.print("Nhap co so muon chuyen: ");
        int base = sc.nextInt();
        Stack stack = convertToBase(num, base);

        System.out.print("So da duoc chuyen doi: ");
        while(! stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        sc.close();
    }

    /**
     * Chuyển đổi một số có hệ cơ số 10 thành hệ cơ số khác
     * @param num - Số ban đầu
     * @param base - Hệ cơ số muốn chuyển
     * @return - stack chứa những phần tử của hệ cơ số mới
     */
    private static Stack convertToBase(long num, int base){
        Stack stack = (new Cau4()).new Stack(64);
        for(; num > 0; num /= base)
            stack.push((int)(num % base));
        return stack;
    }
}
