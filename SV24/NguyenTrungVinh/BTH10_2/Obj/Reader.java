package SV24.NguyenTrungVinh.BTH10_2.Obj;

import java.time.LocalDate;

public class Reader {
    private static int nextID = 0;
    private final int id;
    private final String name, adress, phoneNumber;
    private final LocalDate birthday;

    public Reader(String name, String adress, String phoneNumber, LocalDate birthday){
        nextID++;
        this.id = nextID;
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    public String getAdress() {
        return adress;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return String.format(
            "Reader{ID: %d, Name: %s, adress: %s, phone: %s, birthday: %s}", 
            id, name, adress, phoneNumber, birthday);
    }
}
