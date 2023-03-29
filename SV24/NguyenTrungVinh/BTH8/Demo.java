package SV24.NguyenTrungVinh.BTH8;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Duck("May", 44));
        animals.add(new Cat("Ros", 15, 146, "White"));
        animals.add(new Mouse("Gravel", 50));
        animals.add(new RobotCat("Lancet", 2, 144, "Grey", 56));

        for(Animal animal : animals){
            String instanceOf = "Animal";
            if(animal instanceof Duck)
                instanceOf = "Duck";
            else if (animal instanceof RobotCat)
                instanceOf = "RobotCat";
            else if (animal instanceof Cat)
                instanceOf = "Cat";
            else if (animal instanceof Mouse)
                instanceOf = "Mouse";

            System.out.printf("%s is instance of %s\n", animal.getName(), instanceOf);
            animal.talk();
        }
    }
}
