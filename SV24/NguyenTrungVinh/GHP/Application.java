package SV24.NguyenTrungVinh.GHP;

import SV24.NguyenTrungVinh.GHP.Data.DataReader;
import SV24.NguyenTrungVinh.GHP.UI.LoginFrame;

public class Application {
    public static void main(String[] args) {
        DataReader.readAll();
        new LoginFrame();
    }
}
