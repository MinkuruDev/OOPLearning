package SV24.NguyenTrungVinh.BTH10_2.Builder;

import java.time.LocalDate;

import SV24.NguyenTrungVinh.BTH10_2.Obj.Reader;

public class ReaderBuilder {
    private String name, adress, phoneNumber;
    private LocalDate birthday;

    public ReaderBuilder(){
        name = "";
        adress = "Ha Noi";
        phoneNumber = "";
        birthday = LocalDate.now().minusYears(18);
    }

    public ReaderBuilder name(String n){
        this.name = n;
        return this;
    }

    public ReaderBuilder address(String a){
        this.adress = a;
        return this;
    }

    public ReaderBuilder phoneNumber(String p){
        this.phoneNumber = p;
        return this;
    }

    public ReaderBuilder birthday(LocalDate b){
        this.birthday = b;
        return this;
    }

    public ReaderBuilder birthday(int day, int month, int year){
        this.birthday = LocalDate.of(year, month, day);
        return this;
    }

    public ReaderBuilder birthday(String b){
        this.birthday = LocalDate.parse(b);
        return this;
    }

    public Reader toReader(){
        return new Reader(name, adress, phoneNumber, birthday);
    }

}
