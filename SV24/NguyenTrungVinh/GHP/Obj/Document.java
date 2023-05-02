package SV24.NguyenTrungVinh.GHP.Obj;

import SV24.NguyenTrungVinh.GHP.XmlElement.Documents;

public class Document {
    private String title, author;
    private long price;
    private int pageNumber, publishYear;

    public Document(){
        Documents.addDocument(this);
    }

    public String getAuthor() {
        return author;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public long getPrice() {
        return price;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public String getTitle() {
        return title;
    }

    public Document setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Document setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public Document setPrice(long price) {
        this.price = price;
        return this;
    }

    public Document setPublishYear(int publishYear) {
        this.publishYear = publishYear;
        return this;
    }

    public Document setTitle(String title) {
        this.title = title;
        return this;
    }

}
