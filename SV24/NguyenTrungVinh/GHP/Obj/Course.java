package SV24.NguyenTrungVinh.GHP.Obj;

import SV24.NguyenTrungVinh.GHP.XmlElement.Courses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;

@XmlRootElement
public class Course {
    private String courseName;
    @XmlTransient
    private LocalDate startDate, finishDate;
    @XmlElement
    private String beginDate, endDate;
    private int teacherID;
    private ArrayList<Integer> studentIDs;
    private TreeSet<TimesInWeek> schedule;
    private long price;
    private int numberOfLecture;

    public Course(){
        studentIDs = new ArrayList<>();
        schedule = new TreeSet<>();
        Courses.addCourse(this);
    }

    public String getCourseName() {
        return courseName;
    }

    public Course setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }


    @XmlTransient
    public LocalDate getStartDate() {
        if(startDate == null)
            startDate = LocalDate.parse(beginDate);
        return startDate;
    }

    public Course setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        this.beginDate = startDate.toString();
        return this;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public Course setTeacherID(int teacherID) {
        this.teacherID = teacherID;
        return this;
    }

    public ArrayList<Integer> getStudentIDs() {
        return studentIDs;
    }

    public Course setStudentIDs(ArrayList<Integer> studentIDs) {
        this.studentIDs = studentIDs;
        return this;
    }

    public TreeSet<TimesInWeek> getSchedule() {
        return schedule;
    }

    public Course setSchedule(TreeSet<TimesInWeek> schedule) {
        this.schedule = schedule;
        return this;
    }

    public Course setFinishDate(LocalDate finnishDate) {
        this.finishDate = finnishDate;
        this.endDate = finnishDate.toString();
        return this;
    }

    @XmlTransient
    public LocalDate getFinishDate() {
        if(finishDate == null)
            finishDate = LocalDate.parse(endDate);
        return finishDate;
    }

    public long getPrice() {
        return price;
    }

    public Course setPrice(long price) {
        this.price = price;
        return this;
    }

    public Course setNumberOfLecture(int numberOfLecture) {
        this.numberOfLecture = numberOfLecture;
        return this;
    }

    public int getNumberOfLecture() {
        return numberOfLecture;
    }

    public boolean isConflictSchedule(Course other){
        if(this.startDate.isAfter(other.finishDate))
            // this course start after other
            return false;
        
        if(this.finishDate.isBefore(other.startDate))
            // this course end before other start
            return false;

        for(TimesInWeek d1 : schedule)
            for(TimesInWeek d2 : other.schedule)
                if(d1.compareTo(d2) == 0)
                    return true;

        return false;
    }
}
