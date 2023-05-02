package SV24.NguyenTrungVinh.GHP.Obj;

public enum DaysInWeek {
    Monday(0),
    Tuesday(1),
    Wednesday(2),
    Thursday(3),
    Friday(4),
    Saturday(5),
    Sunday(6);

    DaysInWeek(int dayValues){
        this.dayValues = dayValues;
    }

    private final int dayValues;

    public final int getDayValues() {
        return dayValues;
    }
}
