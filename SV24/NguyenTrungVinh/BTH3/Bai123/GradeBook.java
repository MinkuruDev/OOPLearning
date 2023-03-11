package SV24.NguyenTrungVinh.BTH3.Bai123;

public class GradeBook {
    private String courseName;

    public GradeBook(String courseName){
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String toString() {
        return "Chao Mung den voi khoa hoc " + courseName;
    }

    public void displayMessage(){
        System.out.println(this);
    }
}
