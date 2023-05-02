package SV24.NguyenTrungVinh.GHP.Obj;

import SV24.NguyenTrungVinh.GHP.XmlElement.Students;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "student")
public class Student extends People {
    private static int nextID = 1;
    @XmlElement(name = "id")
    private final int id;

    public Student(){
        id = getNextID();
        nextID++;
        Students.addStudent(this);
    }

    private int getNextID(){
        ArrayList<Student> students = Students.getInstance().getStudents();
        if(students.size() == 0)
            return nextID;
        int lastID = students.get(students.size() - 1).getId();
        if(lastID >= nextID)
            nextID = lastID + 1;
        return nextID;
    }

    public int getId() {
        return id;
    }

}
