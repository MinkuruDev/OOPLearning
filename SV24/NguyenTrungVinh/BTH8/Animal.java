package SV24.NguyenTrungVinh.BTH8;

public abstract class Animal {
    private String name;

    public Animal(){
        name = "";
    }

    public Animal(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void talk();
}
