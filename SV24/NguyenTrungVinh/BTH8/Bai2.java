package SV24.NguyenTrungVinh.BTH8;

import java.util.ArrayList;
import java.util.List;

public class Bai2 {
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        objects.add(500);
        objects.add("Mlynar");
        objects.add(6.9f);
        objects.add(12345678910L);
        objects.add(Math.PI);

        for(Object object : objects){
            String instanceOf = "Object";

            if(object instanceof String)
                instanceOf = "String";
            else if(object instanceof Integer)
                instanceOf = "int";
            else if(object instanceof Long)
                instanceOf = "long";
            else if(object instanceof Float)
                instanceOf = "Float";
            else if(object instanceof Double)
                instanceOf = "double";

            System.out.printf("%s is an instance of %s\n", object.toString(), instanceOf);
        }
    }
}
