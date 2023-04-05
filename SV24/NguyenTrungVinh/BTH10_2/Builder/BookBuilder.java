package SV24.NguyenTrungVinh.BTH10_2.Builder;

import java.time.Year;

import SV24.NguyenTrungVinh.BTH10_2.Obj.Book;

public class BookBuilder {
    private String title, author;
    private int publishYear, eposide, price;

    public BookBuilder(){
        title = "";
        author = "";
        publishYear = Year.now().getValue();
        eposide = 1;
        price = 20_000;
    }

    public Book toBook(){
        return new Book(title, author, publishYear, eposide, price);
    }

    public BookBuilder title(String t){
        this.title = t;
        return this;
    }

    public BookBuilder author(String a){
        this.author = a;
        return this;
    }

    public BookBuilder publishYear(int year){
        this.publishYear = year;
        return this;
    }

    public BookBuilder eposide(int e){
        this.eposide = e;
        return this;
    }

    public BookBuilder price(int p){
        this.price = p;
        return this;
    }

}
