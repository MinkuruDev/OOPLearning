package SV24.NguyenTrungVinh.GHP.Obj;

import SV24.NguyenTrungVinh.GHP.XmlElement.Teachers;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Teacher extends People{
    private long salary;
    private int yearExp;
    private String bankInfo;
    private static int nextID = 1;
    @XmlElement
    private final int id;

    public Teacher(){
        id = getNextID();
        nextID++;
        Teachers.addTeacher(this);
    }

    private int getNextID(){
        ArrayList<Teacher> teachers = Teachers.getInstance().getTeachers();
        if(teachers.size() == 0)
            return nextID;
        int lastID = teachers.get(teachers.size() - 1).getId();
        if(lastID >= nextID)
            nextID = lastID + 1;
        return nextID;
    }

    public int getId() {
        return id;
    }

    public Teacher setSalary(long salary) {
        this.salary = salary;
        return this;
    }

    public long getSalary() {
        return salary;
    }

    public Teacher setBankInfo(String bankInfo) {
        this.bankInfo = bankInfo;
        return this;
    }

    public String getBankInfo() {
        return bankInfo;
    }

    public int getYearExp() {
        return yearExp;
    }

    public Teacher setYearExp(int yearExp) {
        this.yearExp = yearExp;
        return this;
    }

}
