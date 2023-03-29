package SV24.NguyenTrungVinh.BTH8;

public class Mouse extends Animal{
    private int weight;

    public Mouse(){
        super();
        weight = 0;
    }

    public Mouse(String name, int weight){
        super(name);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public void talk() {
        System.out.println("Chit chit");
    }
}
