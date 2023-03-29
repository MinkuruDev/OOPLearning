package SV24.NguyenTrungVinh.BTH8;

public class RobotCat extends Cat{
    private int battery;

    public RobotCat(){
        super();
        battery = 100;
    }

    public RobotCat(String name, int age, int height, String color, int battery){
        super(name, age, height, color);
        this.battery = battery;
    }

    public int getBattery() {
        return battery;
    }

    @Override
    public void talk() {
        System.out.println("Xin chao");
    }
}
