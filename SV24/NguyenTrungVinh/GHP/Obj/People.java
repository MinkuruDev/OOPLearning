package SV24.NguyenTrungVinh.GHP.Obj;

import java.time.LocalDate;

public class People {
    protected String fullName;
    protected int age;
    protected String phoneNumber;
    protected String email;
    protected String address;

    public People(){
        
    }

    public String getFullName() {
        return fullName;
    }

    public People setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public People setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public People setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public People setAddress(String address) {
        this.address = address;
        return this;
    }

    public int getAge() {
        return age;
    }

    public People setAge(int age) {
        this.age = age;
        return this;
    }
}
