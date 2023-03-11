package SV24.NguyenTrungVinh.BTH5;

import java.util.Random;

public class RandomPeople extends Random{
    private static final String[] FIRST_NAME = {
        "Nguyen",
        "Tran",
        "Le",
        "Hoang",
        "Pham",
        "Vu",
        "Dang",
        "Bui",
        "Ngo",
        "Duong",
    };

    private static final String[] LAST_NAME = {
        // male
        "Hung",
        "Nam",
        "Duc",
        "Phap",
        "Hoang",
        "Khanh",
        "Long",
        "Son",
        "Lam",

        // female
        "Hang",
        "Linh",
        "Mai",
        "Trang",
        "Thu",
        "Hoa",
        "Phuong",
        "Cuc",
        "Dao",
    };

    public int range(int from, int to){
        int res = this.nextInt();
        if(res < 0) res = - res;
        return res % (to - from) + from;
    }

    public String firstNameVN(){
        return FIRST_NAME[range(0, FIRST_NAME.length)];
    }

    public String lastNameVN(){
        return LAST_NAME[range(0, LAST_NAME.length)];
    }
}
