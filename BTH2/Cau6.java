package BTH2;

import java.util.Scanner;

public class Cau6 {
    public static void main(String[] args) {
        int[][] arr = {
            {1,2,3,4,5},
            {6,7,8,9,10}
        };
        int[][] arr2 = {
            {6, 9},
            {42, 0}
        };
        MaTran mat = MaTran.from2dArray(arr);
        MaTran mat2 = MaTran.from2dArray(arr2);
        // mat = MaTran.nhap("Nhap vao ma tran 1:\n");
        // mat2 = MaTran.nhap("Nhap vao ma tran 2:\n");
        System.out.println("Ma tran 1: ");
        mat.print();
        if(mat.maTranVuong())
            System.out.println("Ma tran 1 la ma tran vuong");
        else
            System.out.println("Ma tran 1 khong phai la ma tran vuong");
        System.out.println("Ma tran 1 Sau khi doi dau: ");
        mat.doiDau().print();
        System.out.println("Ma tran 2: ");
        mat2.print();
        System.out.println("Ma tran 2 sau khi chuyen vi: ");
        mat2.chuyenVi().print();
        System.out.println("Tong cua ma tran 1 va ma tran 2: ");
        MaTran.tong(mat, mat2).print();
        System.out.println("Hieu cua ma tran 1 va ma tran 2: ");
        MaTran.hieu(mat, mat2).print();
        System.out.println("Ket qua nhan ma tran 1 va ma tran 2: ");
        MaTran.tich(mat, mat2).print();
        System.out.println("Tong hang 0 cua ma tran 1: " + mat.tongHangK(0));
        System.out.println("Tong cot 1 cua ma tran 2: " + mat2.tongCotK(1));
        
    }

    public class MaTran{
        private int[][] arr;
        private int row, col;

        public MaTran(int sh, int sc){
            arr = new int[sh][sc];
            row = sh;
            col = sc;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getElementAt(int row, int col){
            return arr[row][col];
        }

        public void print(){
            for(int i = 0; i<row; i++){
                for(int j = 0; j<col; j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }

        /**
         * Tạo ma trận mới với lệnh ngắn hơn
         * @param row - số hàng của ma trận muốn tạo
         * @param col - số cột của ma trận muốn tạo
         * @return ma trận đã được tạo
         */
        public static MaTran fromSize(int row, int col){
            return (new Cau6()).new MaTran(row, col);
        }

        public static MaTran from2dArray(int[][] arr){
            int row = arr.length;
            int col = arr[0].length;
            MaTran res = MaTran.fromSize(row, col);
            res.arr = arr;
            return res;
        }

        /**
         * Nhập vào 1 ma trận
         * @return ma trận đã nhập 
         */
        public static MaTran nhap(String msg){
            Scanner sc = new Scanner(System.in);
            System.out.print(msg);
            System.out.print("Nhap so hang, so cot cua ma tran: ");
            int row = sc.nextInt(),
                col = sc.nextInt();
            MaTran res = MaTran.fromSize(row, col);

            for(int i = 0; i<row; i++){
                System.out.printf("Nhap %d phan tu cua hang so %d: ", col, i);
                for(int j = 0; j<col; j++){
                    res.arr[i][j] = sc.nextInt();
                }
            }

            sc.close();
            return res;
        }

        public static MaTran tong(MaTran self, MaTran other){
            if(self.getCol() != other.getCol() || self.getRow() != other.getRow()){
                System.out.println("2 Ma tran khong cung kich thuoc");
                return MaTran.fromSize(0, 0);
            }
            MaTran res = MaTran.fromSize(self.getRow(), self.getCol());

            for(int i = 0; i<res.getRow(); i++){
                for(int j = 0; j<res.getCol(); j++){
                    res.arr[i][j] = self.getElementAt(i, j) + other.getElementAt(i, j);
                }
            }

            return res;
        }

        public static MaTran hieu(MaTran self, MaTran other){
            if(self.getCol() != other.getCol() || self.getRow() != other.getRow()){
                System.out.println("2 Ma tran khong cung kich thuoc");
                return MaTran.fromSize(0, 0);
            }
            MaTran res = MaTran.fromSize(self.getRow(), self.getCol());

            for(int i = 0; i<res.getRow(); i++){
                for(int j = 0; j<res.getCol(); j++){
                    res.arr[i][j] = self.getElementAt(i, j) - other.getElementAt(i, j);
                }
            }

            return res;
        }

        public static MaTran tich(MaTran self, MaTran other){
            if(self.getCol() != other.getRow()){
                System.out.println("Khong the nhan ma tran");
                return MaTran.fromSize(0, 0);
            }
            MaTran res = MaTran.fromSize(self.getRow(), other.getCol());

            for(int i = 0; i<res.getRow(); i++){
                for(int j = 0; j<res.getCol(); j++){
                    for(int k = 0; k<self.getCol(); k++){
                        res.arr[i][j] += self.getElementAt(i, k) * other.getElementAt(k, j);
                    }
                }
            }

            return res;
        }

        /**
         * Đổi dấu ma trận hiện tại (this)
         * @return 
         */
        public MaTran doiDau(){
            for(int i = 0; i<row; i++){
                for(int j = 0; j<col; j++){
                    arr[i][j] = -arr[i][j];
                }
            }
            return this;
        }

        public MaTran chuyenVi(){
            int[][] res = new int[col][row];
            for(int i = 0; i<row; i++){
                for(int j = 0; j<col; j++){
                    res[j][i] = arr[i][j];
                }
            }

            arr = res;
            int temp = col;
            col = row;
            row = temp;
            return this;
        }

        public boolean maTranVuong(){
            return row == col;
        }

        public int tongHangK(int k){
            if(k >= row || k<0){
                System.out.printf("Chi so %d khong hop le (chi so hop le trong doan [0-%d])", k, row-1);
                return Integer.MIN_VALUE;
            }
            int sum = 0;
            for(int i = 0; i<col; i++)
                sum += arr[k][i];
            return sum;
        }

        public int tongCotK(int k){
            if(k >= col || k<0){
                System.out.printf("Chi so %d khong hop le (chi so hop le trong doan [0-%d])", k, col-1);
                return Integer.MIN_VALUE;
            }
            int sum = 0;
            for(int i = 0; i<row; i++)
                sum += arr[i][k];
            return sum;
        }

    }
}
