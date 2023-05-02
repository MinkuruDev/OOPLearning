package SV24.NguyenTrungVinh.GHP.Obj;

public enum TimesInDay {
    Morning(0),
    Afternoon(1),
    Evening(2);

    private final int value;

    TimesInDay(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
