package SV24.NguyenTrungVinh.BTH10_2;

import SV24.NguyenTrungVinh.BTH10_2.Data.DataReader;
import SV24.NguyenTrungVinh.BTH10_2.Obj.*;

public class Main {
    public static void main(String[] args) {
        Libraly lib = new Libraly();
        DataReader.readAll(lib);

        LibralyManager manager = new LibralyManager(lib);
        manager.start();
    }
}
