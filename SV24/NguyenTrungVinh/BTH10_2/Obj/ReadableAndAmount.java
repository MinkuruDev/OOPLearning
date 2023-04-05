package SV24.NguyenTrungVinh.BTH10_2.Obj;

public class ReadableAndAmount extends Pair<Readable, Integer> {

    public ReadableAndAmount(Readable first, Integer second) {
        super(first, second);
    }

    public Readable readable(){
        return first();
    }

    public int amount(){
        return second();
    }

    public void addAmount(int n){
        second(second() + n);
    }
    
}
