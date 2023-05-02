package SV24.NguyenTrungVinh.GHP.Obj;

public class FunctionalInterfaces {
    @FunctionalInterface
    public interface Filterable<T>{
        public boolean filter(T t);
    }

    @FunctionalInterface
    public interface OnDataChange{
        public void updateData(Object[][] data, Object[] props);
    }

    @FunctionalInterface
    public interface VoidFunction{
        public void action();
    }
}
