package SV24.NguyenTrungVinh.BTH10_2.Obj;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BorrowCard implements Comparable<BorrowCard>{
    // private static final int expireDay = 15;
    private final Reader reader;
    private final Readable readable;
    private final LocalDateTime borrowDate;
    private LocalDateTime returnDate;
    
    BorrowCard(Reader reader, Readable readable){
        this.reader = reader;
        this.readable = readable;
        this.borrowDate = LocalDateTime.now();
    }

    public BorrowCard(Reader readerID, Readable readableID, String dateTime){
        this.reader = readerID;
        this.readable = readableID;
        this.borrowDate = LocalDateTime.parse(dateTime);
    }

    public int returnReadable(){
        if(returnDate != null)
            return -1;
        returnDate = LocalDateTime.now();
        int days = (int)ChronoUnit.DAYS.between(borrowDate, returnDate);
        return days;
    }

    public Reader getReader() {
        return reader;
    }

    public Readable getReadable() {
        return readable;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    @Override
    public int compareTo(BorrowCard other) {
        return (int)ChronoUnit.SECONDS.between(other.borrowDate, borrowDate);
    }

    @Override
    public String toString() {
        return String.format(
            "Borrow time: %s\n%s\n%s\nReturn time:%s\n",
            borrowDate, reader, readable, (returnDate==null?" -":returnDate));
    }
}
