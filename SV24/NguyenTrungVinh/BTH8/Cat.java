package SV24.NguyenTrungVinh.BTH8;

public class Cat extends Animal{
    private int age, height;
    private String color;

    public Cat(){
        super();
        age = 0;
        height = 0;
        color = "#000000";
    }

    public Cat(String name, int age, int height, String color){
        super(name);
        this.age = age;
        this.height = height;
        this.color = color;
    }


    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void talk() {
        System.out.println("Meow meow");
    }
}
