package SV24.NguyenTrungVinh.BTH10_2.Obj;

public class Book extends Readable{
    private final String author;
    private final int publishYear, eposide;

    public Book(String title, String author, int publishYear, int eposide, int price){
        super(title, price);
        this.author = author;
        this.publishYear = publishYear;
        this.eposide = eposide;
    }

    public int getEposide() {
        return eposide;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format(
            "Book{ID: %d, Title: %s, Author: %s, publish year: %d, eposide: %d, price: %dvnd}",
            id, title, author, publishYear, eposide, price);
    }
    
}
