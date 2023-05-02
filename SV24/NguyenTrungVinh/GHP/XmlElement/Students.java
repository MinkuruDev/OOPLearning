package SV24.NguyenTrungVinh.GHP.XmlElement;

import SV24.NguyenTrungVinh.GHP.Obj.Student;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;

@XmlRootElement
public class Students implements Serializable {
    @XmlElement(name = "student")
    private final ArrayList<Student> students;

    private static Students instance = new Students();

    public static void init(Students students){
        if(students != null)
            instance = students;
    }

    private Students(){
        students = new ArrayList<>();
    }

    public static Students getInstance(){
        return instance;
    }

    public static void addStudent(Student student){
        instance.students.add(student);
    }

    public static Student getStudentByIndex(int index){
        return instance.students.get(index);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
