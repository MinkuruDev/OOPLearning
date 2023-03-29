package SV24.NguyenTrungVinh.BTH8;

public class Duck extends Animal{
    private int weight;

    public Duck(){
        super();
        weight = 0;
    }

    public Duck(String name, int weight){
        super(name);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public void talk() {
        System.out.println("Quack quack");
    }
    
}
