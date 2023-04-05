package SV24.NguyenTrungVinh.BTH10_2.Builder;

public class ReadableBuilderHelper implements Comparable<ReadableBuilderHelper>{
    private Object builder;
    private String shelfType;
    private int id, amount;

    public ReadableBuilderHelper(String shelfType, int amount, int id, Object builder){
        this.id = id;
        this.shelfType = shelfType;
        this.amount = amount;
        if(builder instanceof BookBuilder || builder instanceof MagazineBuilder)
            this.builder = builder;
        else
            System.out.println("fk it");
    }

    public Object getBuilder(){
        return builder;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getShelfType() {
        return shelfType;
    }

    @Override
    public int compareTo(ReadableBuilderHelper other) {
        return this.id - other.id;
    }
}
