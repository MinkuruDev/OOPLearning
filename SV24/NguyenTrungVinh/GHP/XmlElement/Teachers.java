package SV24.NguyenTrungVinh.GHP.XmlElement;

import SV24.NguyenTrungVinh.GHP.Obj.Teacher;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;

@XmlRootElement
public class Teachers implements Serializable {
    @XmlElement(name = "teacher")
    private final ArrayList<Teacher> teachers;

    private static Teachers instance = new Teachers();

    public static void init(Teachers teachers){
        if(teachers != null)
            instance = teachers;
    }

    private Teachers(){
        teachers = new ArrayList<>();
    }

    public static Teachers getInstance(){
        return instance;
    }

    public static void addTeacher(Teacher teacher){
        getInstance().teachers.add(teacher);
    }

    public static Teacher getTeacherById(int id){
        return instance.teachers.get(id-1);
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }
}