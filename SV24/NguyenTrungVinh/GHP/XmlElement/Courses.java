package SV24.NguyenTrungVinh.GHP.XmlElement;

import SV24.NguyenTrungVinh.GHP.Obj.Course;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;

@XmlRootElement
public class Courses implements Serializable {
    @XmlElement(name = "course")
    private final ArrayList<Course> courses;

    private static Courses instance = new Courses();

    public static void init(Courses courses){
        if(courses != null)
            instance = courses;
    }

    private Courses(){
        courses = new ArrayList<>();
    }

    public static Courses getInstance(){
        return instance;
    }

    public static Course getCourseById(int id){
        return instance.courses.get(id-1);
    }

    public static void addCourse(Course course){
        instance.courses.add(course);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

}