package SV24.NguyenTrungVinh.GHP.Data;

import SV24.NguyenTrungVinh.GHP.Obj.*;
import SV24.NguyenTrungVinh.GHP.XmlElement.*;

import javax.swing.text.DateFormatter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DataViewer {

    public static final String[] studentProps = {
            "ID", "Full Name", "Age", "Phone", "Email", "Address"
    };
    public static final String[] teacherProps = {
            "ID", "Full Name", "Age", "Phone", "Email", "Address", "Salary"
    };
    public static final String[] courseProps = {
            "Course Name", "Start Date", "Finish Date", "Teacher Name", "Student Count", "Schedule", "Price"
    };
    public static final String[] examProps = {
            "Exam Name", "Certificate Name", "Exam Time", "Duration (minutes)", "Price"
    };

    public static final String[] documentProps = {
            "Title", "Author", "Publish Year", "Page Number", "Price"
    };

    public static ArrayList<Student> getStudents(FunctionalInterfaces.Filterable<Student> filterable){
        ArrayList<Student> result = new ArrayList<>();
        for(Student student : Students.getInstance().getStudents())
            if(filterable.filter(student))
                result.add(student);

        return result;
    }

    public static Object[][] studentsToData(ArrayList<Student> students){
        Object[][] result = new Object[students.size()][studentProps.length];
        for(int i = 0; i<students.size(); i++){
            Student student = students.get(i);
            Object[] objects = new Object[] {
                    student.getId(),
                    student.getFullName(),
                    student.getAge(),
                    student.getPhoneNumber(),
                    student.getEmail(),
                    student.getAddress()
            };
            result[i] = objects;
        }
        return result;
    }

    public static ArrayList<Teacher> getTeachers(FunctionalInterfaces.Filterable<Teacher> filterable){
        ArrayList<Teacher> result = new ArrayList<>();
        for(Teacher teacher : Teachers.getInstance().getTeachers())
            if(filterable.filter(teacher))
                result.add(teacher);

        return result;
    }

    public static Object[][] teacherToData(ArrayList<Teacher> teachers){
        Object[][] result = new Object[teachers.size()][teacherProps.length];
        for(int i = 0; i<teachers.size(); i++){
            Teacher teacher = teachers.get(i);
            Object[] objects = new Object[] {
                    teacher.getId(),
                    teacher.getFullName(),
                    teacher.getAge(),
                    teacher.getPhoneNumber(),
                    teacher.getEmail(),
                    teacher.getAddress(),
                    teacher.getSalary()
            };
            result[i] = objects;
        }
        return result;
    }

    public static ArrayList<Course> getCourses(FunctionalInterfaces.Filterable<Course> filterable){
        ArrayList<Course> result = new ArrayList<>();
        for(Course course : Courses.getInstance().getCourses())
            if(filterable.filter(course))
                result.add(course);

        return result;
    }

    public static Object[][] courseToData(ArrayList<Course> courses){
        Object[][] result = new Object[courses.size()][courseProps.length];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for(int i = 0; i<courses.size(); i++){
            Course course = courses.get(i);
            ArrayList<Teacher> teacher = getTeachers(t -> t.getId() == course.getTeacherID());
            Object[] objects = new Object[] {
                    course.getCourseName(),
                    course.getStartDate().format(formatter),
                    course.getFinishDate().format(formatter),
                    teacher.size() == 0 ? "!!!" : teacher.get(0).getFullName(),
                    course.getStudentIDs().size(),
                    "...",
                    course.getPrice()
            };
            result[i] = objects;
        }
        return result;
    }

    public static ArrayList<Exam> getExams(FunctionalInterfaces.Filterable<Exam> filterable){
        ArrayList<Exam> result = new ArrayList<>();
        for(Exam exam : Exams.getInstance().getExams())
            if(filterable.filter(exam))
                result.add(exam);

        return result;
    }

    public static Object[][] examToData(ArrayList<Exam> exams){
        Object[][] result = new Object[exams.size()][examProps.length];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm - dd/MM/yyyy");
        for(int i = 0; i<exams.size(); i++){
            Exam exam = exams.get(i);
            Object[] objects = new Object[] {
                    exam.getExamName(),
                    exam.getCertificateName(),
                    exam.getExamDateTime().format(formatter),
                    exam.getDurationInMinutes(),
                    exam.getPrice()
            };
            result[i] = objects;
        }
        return result;
    }

    public static ArrayList<Document> getDocuments(FunctionalInterfaces.Filterable<Document> filterable){
        ArrayList<Document> result = new ArrayList<>();
        for(Document document : Documents.getInstance().getDocuments())
            if(filterable.filter(document))
                result.add(document);

        return result;
    }

    public static Object[][] documentToData(ArrayList<Document> documents){
        Object[][] result = new Object[documents.size()][documentProps.length];
        for(int i = 0; i<documents.size(); i++){
            Document document = documents.get(i);
            Object[] objects = new Object[] {
                    document.getTitle(),
                    document.getAuthor(),
                    document.getPublishYear(),
                    document.getPageNumber(),
                    document.getPrice()
            };
            result[i] = objects;
        }
        return result;
    }
}
