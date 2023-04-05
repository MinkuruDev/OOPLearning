package SV24.NguyenTrungVinh.BTH10_2.Obj;

public abstract class Readable implements Comparable<Readable>{
    protected final int id, price;
    protected final String title;
    protected static int nextID = 0;

    public Readable(String title, int price){
        nextID++;
        this.id = nextID;
        this.title = title;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Readable other) {
        return id - other.id;
    }

}
