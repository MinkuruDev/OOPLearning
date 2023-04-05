package SV24.NguyenTrungVinh.BTH10_2.Builder;

import java.time.LocalDate;

import SV24.NguyenTrungVinh.BTH10_2.Obj.Magazine;

public class MagazineBuilder {
    private String title;
    private int price, no;
    private LocalDate publishDate;
    
    public MagazineBuilder(){
        title = "";
        price = 10_000;
        no = 1;
        publishDate = LocalDate.now();
    }

    public MagazineBuilder title(String t){
        this.title = t;
        return this;
    }

    public MagazineBuilder price(int p){
        this.price = p;
        return this;
    }

    public MagazineBuilder no(int no){
        this.no = no;
        return this;
    }

    public MagazineBuilder publishDate(LocalDate d){
        this.publishDate = d;
        return this;
    }

    public MagazineBuilder publishDate(int day, int month, int year){
        this.publishDate = LocalDate.of(year, month, day);
        return this;
    }

    public MagazineBuilder publishDate(String date){
        this.publishDate = LocalDate.parse(date);
        return this;
    }

    public Magazine toMagazine(){
        return new Magazine(title, publishDate, no, price);
    }

}
