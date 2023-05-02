package SV24.NguyenTrungVinh.GHP.XmlElement;

import SV24.NguyenTrungVinh.GHP.Obj.Exam;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;

@XmlRootElement
public class Exams implements Serializable {
    private ArrayList<Exam> exams;
    private static Exams instance = new Exams();

    private Exams(){
        exams = new ArrayList<>();
    }

    public static void init(){
        if(instance == null)
            instance = new Exams();
    }

    public static void init(Exams exams){
        if(exams != null)
            instance = exams;
    }

    @XmlElement(name = "exam")
    public ArrayList<Exam> getExams() {
        return exams;
    }

    public void setExams(ArrayList<Exam> exams) {
        this.exams = exams;
    }

    public static Exams getInstance() {
        return instance;
    }

    public static void addExam(Exam exam){
        instance.exams.add(exam);
    }
}
