package SV24.NguyenTrungVinh.BTH10_2.Obj;

import java.util.ArrayList;

public class Shelf {
    @FunctionalInterface
    public interface Filterable{
        public boolean filter(ReadableAndAmount r);
    }

    ArrayList<ReadableAndAmount> readables = new ArrayList<>();

    public void addReadable(Readable readable, int amount){
        readables.add(new ReadableAndAmount(readable, amount));
    }

    public ArrayList<ReadableAndAmount> select(Filterable filterFunction){
        ArrayList<ReadableAndAmount> res = new ArrayList<>();
        for(ReadableAndAmount readable: readables)
            if(filterFunction.filter(readable))
                res.add(readable);
        
        return res;
    }
}
