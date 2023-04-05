package SV24.NguyenTrungVinh.BTH10_2.Obj;

public class Pair<F extends Comparable<F> ,S> implements Comparable<Pair<F,S>>{
    private F first;
    private S second;

    public Pair(F first, S second){
        this.first = first;
        this.second = second;
    }

    public void first(F first) {
        this.first = first;
    }

    public void second(S second) {
        this.second = second;
    }

    public F first() {
        return first;
    }

    public S second() {
        return second;
    }

    @Override
    public String toString() {
        return first.toString() + " - " + second.toString();
    }

    @Override
    public int compareTo(Pair<F, S> other) {
        return this.first().compareTo(other.first());
    }

}
