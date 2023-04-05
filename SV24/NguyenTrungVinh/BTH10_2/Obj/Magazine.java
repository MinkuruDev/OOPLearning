package SV24.NguyenTrungVinh.BTH10_2.Obj;

import java.time.LocalDate;

public class Magazine extends Readable{
    private final int no;
    private final LocalDate publishDate;

    public Magazine(String title, LocalDate publishDate, int no, int price) {
        super(title, price);
        this.publishDate = publishDate;
        this.no = no;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public int getNo() {
        return no;
    }

    @Override
    public String toString() {
        return String.format("Magazine{ID: %d, Title: %s, publish date: %s, no: %d, price: %dvnd}",
                                id, title, publishDate, no, price);
    }
}
